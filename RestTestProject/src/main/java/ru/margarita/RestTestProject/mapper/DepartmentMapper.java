package ru.margarita.RestTestProject.mapper;

import org.mapstruct.Mapper;
import ru.margarita.RestTestProject.DTO.DepartmentDTO;
import ru.margarita.RestTestProject.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toDepartment (DepartmentDTO departmentDTO);

    DepartmentDTO toDepartmentDTO (Department department);
}
