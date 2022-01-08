package br.com.jcg.udiapub.adapter.persistence.parameter;

import br.com.jcg.udiapub.domain.parameter.IntegrationType;
import org.springframework.data.jpa.repository.JpaRepository;

interface IntegrationParameterScheduleSpringDataRepository extends JpaRepository<IntegrationParameterScheduleJpaEntity, Long> {
    IntegrationParameterScheduleJpaEntity findByType(IntegrationType type);
}
