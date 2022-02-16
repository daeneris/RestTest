package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.margarita.ExpertSystem.domain.Karma;

public interface KarmaRepo extends JpaRepository<Karma,Integer> {
}
