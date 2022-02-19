package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.margarita.ExpertSystem.domain.Karma;

import java.time.LocalDateTime;
import java.util.List;

public interface KarmaRepo extends JpaRepository<Karma,Integer> {

    List<Karma> findAllByToPersonIDAndDateTimeAfter(Integer personID, LocalDateTime localDateTime);
}
