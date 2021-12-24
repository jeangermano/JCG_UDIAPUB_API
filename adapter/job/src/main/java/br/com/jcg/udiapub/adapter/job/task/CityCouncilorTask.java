package br.com.jcg.udiapub.adapter.job.task;

import br.com.jcg.udiapub.application.port.in.CityCouncilorIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CityCouncilorTask {

    @Autowired
    CityCouncilorIntegration cityCouncilorIntegration;

    @Scheduled(fixedDelay = 600000)
    public void run() {
        cityCouncilorIntegration.loadLocalBase();
    }
}
