package br.com.jcg.udiapub.application.service.integration.event;

import br.com.jcg.udiapub.application.shared.ApplicationEvent;
import br.com.jcg.udiapub.application.shared.EventType;

import java.time.LocalDateTime;

public class CityCouncilorIntegrationEvent implements ApplicationEvent {

    private final Boolean status;
    private final EventType type = EventType.CITY_COUNCILOR_INTEGRATION;
    private final LocalDateTime dateTime = LocalDateTime.now();
    private final Exception exception;


    public CityCouncilorIntegrationEvent() {
        this.status = Boolean.TRUE;
        this.exception = null;
    }

    public CityCouncilorIntegrationEvent(Exception exception) {
        this.status = Boolean.FALSE;
        this.exception = exception;
    }

    @Override
    public EventType type() {
        return this.type;
    }

    @Override
    public Boolean status() {
        return this.status;
    }

    @Override
    public Exception exception() {
        return this.exception;
    }

    @Override
    public LocalDateTime dateTime() {
        return this.dateTime;
    }

}
