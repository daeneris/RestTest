package ru.margarita.RestTestProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class DepartmentDTO {

    private Integer id;

    private String fullName;

    private String shortName;

    private String phoneNumber;
}
