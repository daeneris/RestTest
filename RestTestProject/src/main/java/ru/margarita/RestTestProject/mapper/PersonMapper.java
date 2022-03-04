package ru.margarita.RestTestProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.margarita.RestTestProject.DTO.PersonDTO;
import ru.margarita.RestTestProject.entity.Person;
import ru.margarita.RestTestProject.repository.DepartmentRepo;


@Mapper (componentModel = "spring")
public abstract class PersonMapper {

    @Autowired
    protected DepartmentRepo departmentRepo;

    @Mapping(target = "departmentId", source = "person.department.id")
    public abstract PersonDTO toPersonDTO(Person person);

   @Mapping(target = "department", expression = "java(departmentRepo.findById(personDTO.getDepartmentId()).orElseThrow())")
//   @Mapping(target = "department", expression = "java(departmentRepo.findById(personDTO.getDepartmentId()).get())")
    public abstract Person toPerson(PersonDTO personDTO);


}
