package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.domain.Person;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonDTO toPersonDTO(Person person);

    Person toPerson (PersonDTO personDTO);

    List<PersonDTO> toPersonDTOs (List<Person> Person);
}
