package br.com.jcg.udiapub.application.shared;

public interface EventPublisher {
    void publish(ApplicationEvent event);
}
