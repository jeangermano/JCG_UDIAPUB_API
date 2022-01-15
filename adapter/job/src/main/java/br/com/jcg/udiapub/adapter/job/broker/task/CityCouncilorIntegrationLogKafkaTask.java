package br.com.jcg.udiapub.adapter.job.broker.task;

import br.com.jcg.udiapub.adapter.job.broker.kafka.KafkaService;
import br.com.jcg.udiapub.application.port.out.task.CityCouncilorIntegrationLogTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class CityCouncilorIntegrationLogKafkaTask extends CityCouncilorIntegrationLogTask {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    @Scheduled(fixedDelay = 600000)
    public void run() {
        try (var service = new KafkaService(this.getClass().getSimpleName(), this.rountingKey(), this::parse)) {
            service.run();
        } catch (InterruptedException e) {
            LOGGER.log(Level.FATAL, "Error while process CityCouncilorIntegrationLogKafkaTask", e);
        }
    }
}
