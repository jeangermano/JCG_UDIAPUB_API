package br.com.jcg.udiapub.adapter.persistence.parameter;

import br.com.jcg.udiapub.application.port.out.IntegrationParameterScheduleRepository;
import br.com.jcg.udiapub.domain.parameter.IntegrationParameterSchedule;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class IntegrationParameterScheduleJpaRepository implements IntegrationParameterScheduleRepository {

    IntegrationParameterScheduleSpringDataRepository integrationParameterScheduleSpringDataRepository;

    @Override
    public IntegrationParameterSchedule findByType(IntegrationType type) {
        var integrationEntity = integrationParameterScheduleSpringDataRepository.findByType(type);
        return Objects.nonNull(integrationEntity) ? IntegrationParameterScheduleMapper.MAPPER.map(integrationEntity) : null;
    }
}
