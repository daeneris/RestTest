package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Topic;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepo extends JpaRepository<Topic, Integer> {

    Optional<Topic> findTopicByName(String name);

    List<Topic> findTopicsByDivision_Id(int divisionId);
}
