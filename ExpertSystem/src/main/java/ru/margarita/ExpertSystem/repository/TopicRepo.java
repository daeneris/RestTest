package ru.margarita.ExpertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Topic;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Integer> {

    Optional<Topic> findTopicByName(String name);

    List<Topic> findTopicsByDivision_Id(int divisionId);
}
