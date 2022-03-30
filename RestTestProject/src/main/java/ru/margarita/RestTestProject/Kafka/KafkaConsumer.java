package ru.margarita.RestTestProject.Kafka;

import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.margarita.RestTestProject.DTO.PersonDTO;
import ru.margarita.RestTestProject.entity.NewPerson;

@Service
@NoArgsConstructor
public class KafkaConsumer {
//
//    @KafkaListener(topics = "createdPerson", groupId = "group_id")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//    }


    //newPersonKafkaListenerFactory
    //kafkaListenerContainerFactory
    @KafkaListener(topics = "createdPerson", groupId = "group_json",
            containerFactory = "newPersonKafkaListenerFactory")
    public void consumeJson(PersonDTO personDTO) {
        System.out.println("Consumed JSON Message: " + personDTO);
    }



}



