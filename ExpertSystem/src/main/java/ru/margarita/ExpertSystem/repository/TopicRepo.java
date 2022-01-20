package ru.margarita.ExpertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Topic;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Long> {
}
