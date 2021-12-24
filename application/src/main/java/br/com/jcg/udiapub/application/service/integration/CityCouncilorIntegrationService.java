package br.com.jcg.udiapub.application.service.integration;

import br.com.jcg.udiapub.application.port.in.CityCouncilorIntegration;
import br.com.jcg.udiapub.application.port.out.CityCouncilorRepository;
import br.com.jcg.udiapub.application.port.out.SystemIntegrationConfigRepository;
import br.com.jcg.udiapub.application.service.supplier.CityCouncilorSupplier;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Collectors;

public class CityCouncilorIntegrationService implements CityCouncilorIntegration {

    SystemIntegrationConfigRepository systemIntegrationConfigRepository;

    CityCouncilorRepository cityCouncilorRepository;

    CityCouncilorSupplier cityCouncilorSupplier;

    private final IntegrationType integrationType = IntegrationType.CITY_COUNCILOR;

    public CityCouncilorIntegrationService(SystemIntegrationConfigRepository systemIntegrationConfigRepository,
                                           CityCouncilorRepository cityCouncilorRepository,
                                           CityCouncilorSupplier cityCouncilorSupplier) {
        this.systemIntegrationConfigRepository = systemIntegrationConfigRepository;
        this.cityCouncilorRepository = cityCouncilorRepository;
        this.cityCouncilorSupplier = cityCouncilorSupplier;
    }

    @Override
    public boolean isToUpdateLocalBase() {

        var systemIntegrationConfig = systemIntegrationConfigRepository.getByType(integrationType);
        if(Objects.isNull(systemIntegrationConfig) || !systemIntegrationConfig.isActive()) {
            return false;
        }

        if(Objects.isNull(systemIntegrationConfig.getLastIntegration())) {
            return true;
        }

        var lastIntegrationDay = systemIntegrationConfig.getLastIntegration().toLocalDate();
        switch (systemIntegrationConfig.getFrequency()) {
            case DAILY:
                return lastIntegrationDay.isBefore(LocalDate.now());
            case MONTHLY:
                return lastIntegrationDay.getMonth().getValue() < LocalDate.now().getMonth().getValue();
            case YEARLY:
                return lastIntegrationDay.getYear() < LocalDate.now().getYear();
            default:
                return false;
        }
    }

    @Override
    public void loadLocalBase() {

        if(true) {

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
        }
    }
}
