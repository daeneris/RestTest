package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.domain.Topic;


@Mapper (componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "roleId", source = "person.role.id")
    PersonDTO toPersonDTO(Person person);

    @Mapping(target = "role", expression = "java(roleRepo.findById(personDTO.getRoleId()).orElseThrow())")
    Person toPerson (PersonDTO personDTO);

}
