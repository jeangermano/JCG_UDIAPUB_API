package br.com.jcg.udiapub.application.port.out;

import br.com.jcg.udiapub.domain.parameter.IntegrationParameterSchedule;
import br.com.jcg.udiapub.domain.parameter.IntegrationType;

public interface IntegrationParameterScheduleRepository {

    IntegrationParameterSchedule findByType(IntegrationType type);
}
