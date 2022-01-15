package br.com.jcg.udiapub.application.port.out.task;

import br.com.jcg.udiapub.application.shared.event.EventType;

public abstract class CityCouncilorIntegrationLogTask {

    public abstract void run();

    public String rountingKey() {
        return EventType.CITY_COUNCILOR_INTEGRATION.getRoutingKey();
    }

    public void parse(String s) {
        System.out.println(s);
    }
}
