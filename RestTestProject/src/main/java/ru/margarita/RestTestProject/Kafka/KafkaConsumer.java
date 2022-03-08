package ru.margarita.RestTestProject.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.margarita.RestTestProject.entity.NewPerson;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "newPersonKafkaListenerFactory")
    public void consumeJson(NewPerson newPerson) {
        System.out.println("Consumed JSON Message: " + newPerson);
    }
}



