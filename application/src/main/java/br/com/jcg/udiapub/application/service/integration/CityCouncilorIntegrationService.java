package br.com.jcg.udiapub.application.service.integration;

import br.com.jcg.udiapub.application.port.in.usecase.CityCouncilorIntegration;
import br.com.jcg.udiapub.application.port.out.CityCouncilorRepository;
import br.com.jcg.udiapub.application.port.out.IntegrationParameterScheduleRepository;
import br.com.jcg.udiapub.application.service.integration.event.CityCouncilorIntegrationEvent;
import br.com.jcg.udiapub.application.port.in.supplier.CityCouncilorSupplier;
import br.com.jcg.udiapub.application.shared.EventPublisher;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CityCouncilorIntegrationService implements CityCouncilorIntegration {

    private final IntegrationType integrationType = IntegrationType.CITY_COUNCILOR;

    IntegrationParameterScheduleRepository integrationParameterScheduleRepository;
    CityCouncilorRepository cityCouncilorRepository;
    CityCouncilorSupplier cityCouncilorSupplier;
    EventPublisher eventPublisher;

    @Override
    public boolean isToUpdateLocalBase() {

        var integrationParameterSchedule = integrationParameterScheduleRepository.findByType(integrationType);
        if(Objects.isNull(integrationParameterSchedule)) {
            return false;
        }

        return integrationParameterSchedule.isToUpdate();
    }

    @Override
    public void loadLocalBase() {

        if(isToUpdateLocalBase()) {

            try {
                var councilorsOfCurrentLegislature = cityCouncilorSupplier.getCouncilorsOfCurrentLegislature();

                var cityCouncilorInLocalBase = cityCouncilorRepository.getAll();
                if(cityCouncilorInLocalBase.isEmpty()) {
                    cityCouncilorRepository.saveAll(councilorsOfCurrentLegislature);
                    return;
                }

                var newCouncilors = councilorsOfCurrentLegislature.stream()
                    .filter(cl -> !cityCouncilorInLocalBase.contains(cl))
                    .collect(Collectors.toList());

                if(!newCouncilors.isEmpty()) {
                    cityCouncilorRepository.saveAll(newCouncilors);
                }

                eventPublisher.publish(new CityCouncilorIntegrationEvent());

            } catch (Exception e) {
                eventPublisher.publish(new CityCouncilorIntegrationEvent(e));
            }
        }
    }
}
