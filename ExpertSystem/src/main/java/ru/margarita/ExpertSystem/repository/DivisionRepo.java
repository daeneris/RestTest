package ru.margarita.ExpertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Division;

@Repository
public interface DivisionRepo extends CrudRepository<Division, Long> {
}

