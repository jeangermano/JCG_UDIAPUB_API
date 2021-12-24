package br.com.jcg.udiapub.domain.parameter;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class IntegrationParameter {

    private IntegrationType type;
    private IntegrationFrequencyType frequency;
    private LocalDateTime lastIntegration;
    private boolean isActive;
}
