package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.repository.RoleRepo;


@Mapper (componentModel = "spring")
public abstract class PersonMapper {

    @Autowired
    protected RoleRepo roleRepo;

    @Mapping(target = "roleId", source = "person.role.id")
    public abstract PersonDTO toPersonDTO(Person person);

    @Mapping(target = "role", expression = "java(roleRepo.findById(personDTO.getRoleId()).orElseThrow())")
    public abstract Person toPerson(PersonDTO personDTO);

}
