package br.com.jcg.udiapub.adapter.job.broker.kafka;

import br.com.jcg.udiapub.application.shared.event.ApplicationServiceEvent;
import br.com.jcg.udiapub.application.shared.event.EventPublisher;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KafkaEventPublisher implements EventPublisher {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void publish(ApplicationServiceEvent<?> event) {
        try (var kafkaDispatcher = new KafkaDispatcher<>()){
            kafkaDispatcher.send(event.getType().getRoutingKey(), event.getKey(), event.getContext());
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "Error while trying publish message: ", e);
        }
    }
}
