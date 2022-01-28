package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.margarita.ExpertSystem.DTO.DivisionDTO;
import ru.margarita.ExpertSystem.domain.Division;


import java.util.List;

@Mapper
public interface DivisionMapper {

    @Mapping(source="division", target="division_id")
    DivisionDTO toDivisionDTO(Division division);

    Division toDivision (DivisionDTO divisionDTO);

    List<Division> toDivisionDTOs (List<Division> division);

}
