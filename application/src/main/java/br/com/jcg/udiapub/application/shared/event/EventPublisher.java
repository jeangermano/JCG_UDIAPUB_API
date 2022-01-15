package br.com.jcg.udiapub.application.shared.event;

public interface EventPublisher {
    void publish(ApplicationServiceEvent<?> event);
}
