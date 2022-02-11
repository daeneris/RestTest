package ru.margarita.ExpertSystem.DTO;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.margarita.ExpertSystem.domain.Role;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {

    private int id;

    private String name;

    private  String nickName;

    private int phoneNumber;

    private String password;

    private Integer roleId;

}
