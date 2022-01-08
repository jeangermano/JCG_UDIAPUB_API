package br.com.jcg.udiapub.adapter.job.task;

import br.com.jcg.udiapub.application.port.in.usecase.CityCouncilorIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CityCouncilorTask {

    @Autowired
    CityCouncilorIntegration cityCouncilorIntegration;

    @Value("${job.active}")
    private Boolean isJobActive;

    @Scheduled(fixedDelay = 600000)
    public void run() {
        if(isJobActive)
            cityCouncilorIntegration.loadLocalBase();
    }
}
