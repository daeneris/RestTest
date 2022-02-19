package ru.margarita.ExpertSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="karma")
@NoArgsConstructor
@AllArgsConstructor
public class Karma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "operation")
    @Enumerated (EnumType.STRING)
    private Operation operation;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name="person_from_id")
    private Integer fromPersonID;

    @Column(name="person_to_id")
    private Integer toPersonID;

    @Column (name="date_time")
    private LocalDateTime dateTime;

    @Column (name = "amount")
    private Integer amount;

    public enum Operation {
        INCREASE,
        DECREASE

    //getName()

    }

    //собирает карму с сообщений
    // в теме, где человек эксперт, его оценка дает + 10 за сообщение, в остальных + 1

    public  enum Type {
        TOPIC,
        MESSAGE
    }

}
