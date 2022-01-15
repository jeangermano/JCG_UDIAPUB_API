package br.com.jcg.udiapub.application.shared.event;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApplicationServiceEvent<T> {

    private final EventType type;
    private final String key;
    private final T context;
    private final LocalDateTime eventTimestamp;
    private final boolean hasError;

    public ApplicationServiceEvent(EventType type, T context, String key) {
        this.type = type;
        this.key = key;
        this.context = context;
        this.eventTimestamp = LocalDateTime.now();
        this.hasError =  context instanceof RuntimeException;
    }
}
