package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {
}
