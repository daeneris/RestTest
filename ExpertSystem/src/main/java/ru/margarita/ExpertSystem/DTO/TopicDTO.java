package ru.margarita.ExpertSystem.DTO;

import lombok.AllArgsConstructor;
import ru.margarita.ExpertSystem.domain.Division;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
public class TopicDTO {

    private String name;

    private  String description;

    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;
}
