package ru.margarita.RestTestProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.RestTestProject.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
