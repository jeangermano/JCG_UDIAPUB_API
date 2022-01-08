package br.com.jcg.udiapub.adapter.persistence.parameter;

import br.com.jcg.udiapub.domain.parameter.IntegrationFrequencyType;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "integration_parameter_schedule")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntegrationParameterScheduleJpaEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private IntegrationType type;

    @Column(name = "frequency")
    @Enumerated(EnumType.STRING)
    private IntegrationFrequencyType frequency;

    @Column(name = "last_integration")
    private LocalDateTime lastIntegration;

    @Column(name = "active")
    private boolean isActive;

}
