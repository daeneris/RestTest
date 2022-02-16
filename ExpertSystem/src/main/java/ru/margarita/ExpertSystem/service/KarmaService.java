package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.KarmaDTO;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Karma;
import ru.margarita.ExpertSystem.mapper.KarmaMapper;
import ru.margarita.ExpertSystem.repository.KarmaRepo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static ru.margarita.ExpertSystem.domain.Karma.Operation.INCREASE;
import static ru.margarita.ExpertSystem.domain.Karma.Type.TOPIC;

@Service
@AllArgsConstructor
public class KarmaService {
    private final KarmaRepo karmaRepo;
    private final KarmaMapper karmaMapper;
    private final PersonService personService;
    private final int ADDKARMA = 1; // куда это положить? мы говорили про класс Configure?


    public void addKarmaInTopic (Integer fromPersonID, Integer toPersonID, TopicDTO topicDTO){

        LocalDateTime dateTime = LocalDateTime.now();
        Integer amount = topicDTO.getKarma()+ADDKARMA;

        Karma karma = new Karma();

        karma.setOperation(INCREASE);
        karma.setType(TOPIC);
        karma.setDateTime(dateTime);
        karma.setPersonFromID(fromPersonID);
        karma.setPersonToID(toPersonID);
        karma.setAmount(amount);
        
    }

    public void distractKarma(){}

    public List<KarmaDTO> getAnonKarma(PersonDTO personDTO) {
        LocalDateTime showToDate = LocalDateTime.now().minusMonths(1);


        return null;

    }
}
