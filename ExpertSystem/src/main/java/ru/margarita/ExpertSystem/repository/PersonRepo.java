package ru.margarita.ExpertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
}
