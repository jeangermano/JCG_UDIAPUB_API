package br.com.jcg.udiapub.application.shared;

import lombok.Getter;

@Getter
public enum EventType {

    CITY_COUNCILOR_INTEGRATION("service.integration.city.councilor");

    final String routingKey;

    EventType(String routingKey) {
        this.routingKey = routingKey;
    }

}
