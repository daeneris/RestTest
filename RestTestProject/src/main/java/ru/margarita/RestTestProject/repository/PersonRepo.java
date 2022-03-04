package ru.margarita.RestTestProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.RestTestProject.entity.Person;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    List<Person> findDistinctBySurname(String surname);

    List<Person> findDistinctByDepartment_Id(int departmentId);

    List <Person> findDistinctByBirthDateBetween(Date fromDate, Date toDate);

    List<Person> findDistinctBySurnameAndBirthDateBetween(String surname, Date fromDate, Date toDate);

    List<Person> findDistinctByBirthDateBetweenAndDepartment_Id(Date fromDate, Date toDate, int departmentId);

    List<Person> findDistinctBySurnameAndDepartment_Id(String surname, int departmentId);

    List <Person> findDistinctBySurnameAndBirthDateBetweenAndDepartment_Id(String surname, Date fromDate,
                                                                              Date toDate, int departmentId);

}
