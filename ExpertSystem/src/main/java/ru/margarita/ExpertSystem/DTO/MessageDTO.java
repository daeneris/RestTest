package ru.margarita.ExpertSystem.DTO;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.margarita.ExpertSystem.domain.Person;


@Getter
@Setter
@AllArgsConstructor
public class MessageDTO {

    private int id;

    private String content;

    private PersonDTO owner;

    private Integer topicId;
}
