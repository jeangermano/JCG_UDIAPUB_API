package br.com.jcg.udiapub.adapter.persistence.parameter;

import br.com.jcg.udiapub.adapter.persistence.parameter.entity.IntegrationHistoryJpaEntity;
import br.com.jcg.udiapub.adapter.persistence.parameter.repository.IntegrationHistorySpringDataRepository;
import br.com.jcg.udiapub.adapter.persistence.parameter.repository.IntegrationParameterScheduleSpringDataRepository;
import br.com.jcg.udiapub.adapter.persistence.parameter.mapper.IntegrationParameterScheduleMapper;
import br.com.jcg.udiapub.application.port.out.repository.IntegrationParameterScheduleRepository;
import br.com.jcg.udiapub.domain.parameter.IntegrationParameterSchedule;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
public class IntegrationParameterScheduleJpaRepository implements IntegrationParameterScheduleRepository {

    IntegrationParameterScheduleSpringDataRepository integrationParameterScheduleSpringDataRepository;
    IntegrationHistorySpringDataRepository integrationHistorySpringDataRepository;

    @Override
    public IntegrationParameterSchedule findByType(IntegrationType type) {
        var integrationEntity = integrationParameterScheduleSpringDataRepository.findByType(type);
        return Objects.nonNull(integrationEntity) ? IntegrationParameterScheduleMapper.MAPPER.mapToDomain(integrationEntity) : null;
    }

    @Override
    public void saveIntegrationHistory(IntegrationParameterSchedule integrationParameterSchedule, String integrationIdentifier, boolean updatedData) {

        var integrationEntity = integrationParameterScheduleSpringDataRepository.findByType(integrationParameterSchedule.getType());
        integrationEntity.setLastIntegration(LocalDateTime.now());
        integrationParameterScheduleSpringDataRepository.save(integrationEntity);

        var integrationHistory = IntegrationHistoryJpaEntity.builder()
            .integrationParameterId(integrationEntity.getId())
            .integrationCode(integrationIdentifier)
            .updatedData(updatedData)
            .createDate(LocalDateTime.now())
            .build();
        integrationHistorySpringDataRepository.save(integrationHistory);
    }
}
