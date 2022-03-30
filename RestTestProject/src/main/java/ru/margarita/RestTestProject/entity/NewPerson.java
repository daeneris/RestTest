package ru.margarita.RestTestProject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="new_person")
public class NewPerson {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name="department_id")
    private int department;

//    @Column(name="month_salary")
//    private Integer monthSalary;

    @Column(name = "creation_date")
    private Date date;

    @Column(name = "creation_time")
    private Date time;
}
