package br.com.jcg.udiapub.adapter.persistence.parameter.repository;

import br.com.jcg.udiapub.adapter.persistence.parameter.entity.IntegrationParameterScheduleJpaEntity;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrationParameterScheduleSpringDataRepository extends JpaRepository<IntegrationParameterScheduleJpaEntity, Long> {
    IntegrationParameterScheduleJpaEntity findByType(IntegrationType type);
}
