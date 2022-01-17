package br.com.jcg.udiapub.application.port.out.task;

import br.com.jcg.udiapub.application.shared.event.EventType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class CityCouncilorIntegrationLogTask {

    private static final Logger LOGGER = LogManager.getLogger();

    public String rountingKey() {
        return EventType.CITY_COUNCILOR_INTEGRATION.getRoutingKey();
    }

    public void run(String json) {
        LOGGER.log(Level.INFO, "Integration Status ::: " + json);
    }
}
