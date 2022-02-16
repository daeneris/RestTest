package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Division;

@Repository
public interface DivisionRepo extends JpaRepository<Division, Integer> {
}

