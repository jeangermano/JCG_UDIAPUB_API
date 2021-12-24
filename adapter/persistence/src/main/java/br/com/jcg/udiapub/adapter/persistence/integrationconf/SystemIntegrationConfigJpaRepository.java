package br.com.jcg.udiapub.adapter.persistence.integrationconf;

import br.com.jcg.udiapub.application.port.out.SystemIntegrationConfigRepository;
import br.com.jcg.udiapub.domain.parameter.IntegrationParameter;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;

public class SystemIntegrationConfigJpaRepository implements SystemIntegrationConfigRepository {
    @Override
    public IntegrationParameter getByType(IntegrationType type) {
        return null;
    }
}
