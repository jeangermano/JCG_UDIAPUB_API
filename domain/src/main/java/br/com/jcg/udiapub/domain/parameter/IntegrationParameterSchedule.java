package br.com.jcg.udiapub.domain.parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class IntegrationParameterSchedule {

    private IntegrationType type;
    private IntegrationFrequencyType frequency;
    private LocalDateTime lastIntegration;
    private boolean isActive;

    public boolean isToUpdate() {

        if(!this.isActive()) {
            return false;
        }

        if(Objects.isNull(this.getLastIntegration())) {
            return true;
        }

        var lastIntegrationDay = this.getLastIntegration().toLocalDate();
        switch (this.getFrequency()) {
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

}
