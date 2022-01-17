package br.com.jcg.udiapub.adapter.job.broker.kafka.publisher;

import br.com.jcg.udiapub.application.shared.event.ApplicationServiceEvent;
import br.com.jcg.udiapub.application.shared.event.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class KafkaEventPublisher implements EventPublisher {

    private static final Logger LOGGER = LogManager.getLogger();
    private final KafkaTemplate<String, String> kafkaTemplate;

    private String topicName;
    private String key;

    @Override
    public void publish(ApplicationServiceEvent<?> event) {

        this.topicName = event.getType().getRoutingKey();
        this.key= event.getKey();

        var objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            this.send(objectMapper.writeValueAsString(event.getContext()));
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.FATAL, "Error while trying convert context to json: ", e);
        }
    }

    private void send(String message){
        try {
            kafkaTemplate.send(topicName, key, message).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.FATAL, "Error while trying publish message: ", e);
        }
    }
}
