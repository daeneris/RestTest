package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.repository.TopicRepo;


@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;

    public Topic create(Topic topic) {
        return topicRepo.save(topic);
        }

    public Topic getById(int id) {
        return topicRepo.findById(id).orElseThrow();
    }

    public Iterable<Topic> getAll(){
        return topicRepo.findAll();
    }

    public void update (@org.jetbrains.annotations.NotNull Topic topic) {
        Topic topicToUpdate = topicRepo.findById(topic.getId()).orElseThrow();
        topicRepo.save(topicToUpdate);
    }

    public void delete (int id) {
        Topic topicToDelete = topicRepo.findById(id).orElseThrow();
        topicRepo.delete(topicToDelete);
    }

}
