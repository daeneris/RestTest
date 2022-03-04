package ru.margarita.RestTestProject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.RestTestProject.DTO.DepartmentDTO;
import ru.margarita.RestTestProject.entity.Department;
import ru.margarita.RestTestProject.mapper.DepartmentMapper;
import ru.margarita.RestTestProject.repository.DepartmentRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepo departmentRepo;

    public DepartmentDTO create(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toDepartment(departmentDTO);
        department = departmentRepo.save(department);
        return departmentMapper.toDepartmentDTO(department);
    }

    public DepartmentDTO getById(int id) {
        Department department = departmentRepo.findById(id).orElseThrow();
        return departmentMapper.toDepartmentDTO(department);
    }

    public Iterable<DepartmentDTO> getAll() {
        Iterable<Department> departments = departmentRepo.findAll();
        List<DepartmentDTO> departmentDTOS = null;
        for (Department department : departments) {
            departmentDTOS.add(departmentMapper.toDepartmentDTO(department));
        }
        return departmentDTOS;
    }


    public void update(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toDepartment(departmentDTO);
        Department departmentToUpdate = departmentRepo.findById(department.getId())
                .orElseThrow();
        departmentRepo.save(departmentToUpdate);

    }

    public void delete(int id) {
        Department department = departmentRepo.findById(id).orElseThrow();
        departmentRepo.delete(department);
    }
}
