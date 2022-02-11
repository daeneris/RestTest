package ru.margarita.ExpertSystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="karma")
@NoArgsConstructor
public class Karma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //собирает количество написанных топиков
    private Integer topicKarma;

    //собирает карму с сообщений
    // в теме, где человек эксперт, его оценка дает + 10 за сообщение, в остальных + 1
    private Integer messageKarma;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;


}
