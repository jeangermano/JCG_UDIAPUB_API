package br.com.jcg.udiapub.application.service.integration;

import br.com.jcg.udiapub.application.port.in.supplier.CityCouncilorSupplier;
import br.com.jcg.udiapub.application.port.in.usecase.CityCouncilorIntegration;
import br.com.jcg.udiapub.application.port.out.repository.CityCouncilorRepository;
import br.com.jcg.udiapub.application.port.out.repository.IntegrationParameterScheduleRepository;
import br.com.jcg.udiapub.application.shared.event.ApplicationServiceEvent;
import br.com.jcg.udiapub.application.shared.event.EventPublisher;
import br.com.jcg.udiapub.application.shared.event.EventType;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CityCouncilorIntegrationService implements CityCouncilorIntegration {

    private static final Logger LOGGER = LogManager.getLogger();
    private final IntegrationType integrationType = IntegrationType.CITY_COUNCILOR;

    IntegrationParameterScheduleRepository integrationParameterScheduleRepository;
    CityCouncilorRepository cityCouncilorRepository;
    CityCouncilorSupplier cityCouncilorSupplier;
    EventPublisher eventPublisher;

    @Override
    public void loadLocalBase() {

        var integrationIdentifier = UUID.randomUUID().toString();
        LOGGER.log(Level.DEBUG, "Checking for pending updates: " + integrationIdentifier);

        var integrationParameterSchedule = integrationParameterScheduleRepository.findByType(integrationType);
        if(Objects.isNull(integrationParameterSchedule)) {
            LOGGER.log(Level.DEBUG, "Schedule parameter not found " + integrationIdentifier);
            return;
        }

        try {
            if(integrationParameterSchedule.isToUpdate()) {
                LOGGER.log(Level.DEBUG, "Start pending integration: " + integrationIdentifier);

                var councilorsOfCurrentLegislature = cityCouncilorSupplier.getCouncilorsOfCurrentLegislature();
                var cityCouncilorInLocalBase = cityCouncilorRepository.getAll();
                var newCouncilors = councilorsOfCurrentLegislature.stream()
                    .filter(cl -> !cityCouncilorInLocalBase.contains(cl))
                    .collect(Collectors.toList());

                var updatedData = false;
                if(!newCouncilors.isEmpty()) {
                    updatedData = true;
                    LOGGER.log(Level.DEBUG, "Save new councilors in local base: " + integrationIdentifier);
                    cityCouncilorRepository.saveAll(newCouncilors);
                }

                integrationParameterScheduleRepository.saveIntegrationHistory(integrationParameterSchedule, integrationIdentifier, updatedData);
                eventPublisher.publish(new ApplicationServiceEvent<>(EventType.CITY_COUNCILOR_INTEGRATION, integrationParameterSchedule, integrationIdentifier));

            } else {
                LOGGER.log(Level.DEBUG, "No pending integrations found: " + integrationIdentifier);
            }
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "Error while trying integrate city councilours base: " + integrationIdentifier);
            eventPublisher.publish(new ApplicationServiceEvent<>(EventType.CITY_COUNCILOR_INTEGRATION, e, integrationIdentifier));
        }
    }
}
