package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository <Person, Integer> {

    Person findByLogin(Integer login);
}
