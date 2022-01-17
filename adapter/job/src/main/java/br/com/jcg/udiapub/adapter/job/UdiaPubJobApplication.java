package br.com.jcg.udiapub.adapter.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class UdiaPubJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(UdiaPubJobApplication.class, args);
    }
}
