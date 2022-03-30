package ru.margarita.RestTestProject.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;
import ru.margarita.RestTestProject.DTO.PersonDTO;
import ru.margarita.RestTestProject.entity.Person;

import java.util.Map;

@Slf4j
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, PersonDTO> kafkaTemplate;

    public void sendKafka (String topic, PersonDTO person) {

        kafkaTemplate.send(topic, person).addCallback(success -> {
            log.info(success.toString());
        }, failure -> {
            log.error(failure.getMessage());
        });




}

}
