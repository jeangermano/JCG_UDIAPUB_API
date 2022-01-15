package br.com.jcg.udiapub.adapter.job.broker.kafka;

import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.function.Consumer;

@NoArgsConstructor
public class KafkaService implements Closeable {

    private static final Logger LOGGER = LogManager.getLogger();

    private KafkaConsumer<String, String> consumer;
    private Consumer<String> parser;

    public KafkaService(String groupId, String topic, Consumer<String> parser) {
        this.consumer = new KafkaConsumer<>(properties(groupId));
        this.consumer.subscribe(Collections.singletonList(topic));
        this.parser = parser;
    }

    public void run() throws InterruptedException {
        var records = consumer.poll(Duration.ofSeconds(2));
        if(!records.isEmpty()) {
            for (var record : records) {
                LOGGER.log(Level.INFO, "Processing kafka message: " + record.key());
                parser.accept(record.value());
            }
        }
    }

    @Override
    public void close() {
        consumer.close();
    }

    private static Properties properties(String groupId) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        //Todos conectados no tópico recebem a mensagem, o group ID é uma forma de identificar quem consome.
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        //Consumir mensagem uma a uma para evitar conflito quando se utiliza paralelismo e se tem uma alta carga de mensagens
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        return properties;
    }
}
