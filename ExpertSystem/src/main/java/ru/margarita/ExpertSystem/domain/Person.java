package ru.margarita.ExpertSystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nick_name")
    private  String nickName;

    @Column(name="karma")
    private int karma;

    @Column(name="phone_number")
    private int phoneNumber;

}
