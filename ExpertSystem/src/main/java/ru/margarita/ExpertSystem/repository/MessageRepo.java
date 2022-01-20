package ru.margarita.ExpertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
}
