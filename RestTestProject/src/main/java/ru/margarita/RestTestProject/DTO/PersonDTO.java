package ru.margarita.RestTestProject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {

    private int id;

    private String surname;

    private String name;

    private String middleName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
//    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date birthDate;

    private Integer departmentId;
}
