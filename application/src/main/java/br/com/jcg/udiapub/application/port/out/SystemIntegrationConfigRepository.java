package br.com.jcg.udiapub.application.port.out;

import br.com.jcg.udiapub.domain.parameter.IntegrationParameter;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;

public interface SystemIntegrationConfigRepository {

    IntegrationParameter getByType(IntegrationType type);

}
