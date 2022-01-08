package br.com.jcg.udiapub.application.shared;

import java.time.LocalDateTime;

public interface ApplicationEvent {
    EventType type();
    Boolean status();
    Exception exception();
    LocalDateTime dateTime();
}
