package br.com.jcg.udiapub.adapter.persistence.parameter.repository;

import br.com.jcg.udiapub.adapter.persistence.parameter.entity.IntegrationHistoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrationHistorySpringDataRepository extends JpaRepository<IntegrationHistoryJpaEntity, Long> {
}
