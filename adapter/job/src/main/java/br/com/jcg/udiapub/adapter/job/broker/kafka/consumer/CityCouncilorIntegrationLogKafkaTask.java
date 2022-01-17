package br.com.jcg.udiapub.adapter.job.broker.kafka.consumer;

import br.com.jcg.udiapub.application.port.out.task.CityCouncilorIntegrationLogTask;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CityCouncilorIntegrationLogKafkaTask extends CityCouncilorIntegrationLogTask {

    private static final Logger LOGGER = LogManager.getLogger();

    @KafkaListener(
        topics = "service.integration.city.councilor",
        groupId = "br.com.jcg.udiapub.adapter.job.broker.task.CityCouncilorIntegrationLogKafkaTask")
    public void consumer(String value) {
        LOGGER.log(Level.DEBUG,"Processing message ::: service.integration.city.councilor - CityCouncilorIntegrationLogKafkaTask");
        this.run(value);
    }
}
