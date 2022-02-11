package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.margarita.ExpertSystem.DTO.DivisionDTO;
import ru.margarita.ExpertSystem.domain.Division;


@Mapper (componentModel = "spring")
public interface DivisionMapper {


    DivisionDTO toDivisionDTO(Division division);

    Division toDivision (DivisionDTO divisionDTO);

}
