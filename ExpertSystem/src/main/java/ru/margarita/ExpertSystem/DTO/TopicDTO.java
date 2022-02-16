package ru.margarita.ExpertSystem.DTO;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TopicDTO {

    private int id;

    private String name;

    private  String description;

    private Integer divisionId;

    private int karma;
}
