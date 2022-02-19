package ru.margarita.ExpertSystem.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
    private Integer karma;

    @Column(name="phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

   // @ManyToOne
   // @JoinColumn(name="role_id")
    private String role;

}
