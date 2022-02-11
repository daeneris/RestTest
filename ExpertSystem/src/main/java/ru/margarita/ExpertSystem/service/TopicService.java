package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.mapper.TopicMapper;
import ru.margarita.ExpertSystem.repository.TopicRepo;

import java.util.List;


@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepo topicRepo;
    private final TopicMapper topicMapper;

    public TopicDTO create(TopicDTO topicDTO) {
        Topic topic = topicMapper.toTopic(topicDTO);
        topic = topicRepo.save(topic);
        return topicMapper.toTopicDTO(topic);
        }

    public TopicDTO getById(int id) {
        Topic topic = topicRepo.findById(id).orElseThrow();
        return topicMapper.toTopicDTO(topic);
    }

    public Iterable<TopicDTO> getAll(){
        Iterable<Topic> allTopic = topicRepo.findAll();
        List<TopicDTO> allTopicDTO = null;
        for (Topic topic:
             allTopic) {
           allTopicDTO.add(topicMapper.toTopicDTO(topic));
        }
        return allTopicDTO;
    }

    public void update (@org.jetbrains.annotations.NotNull TopicDTO topicDTO) {
        Topic topic = topicMapper.toTopic(topicDTO);
        Topic topicToUpdate = topicRepo.findById(topic.getId()).orElseThrow();
        topicRepo.save(topicToUpdate);
    }

    public void delete (int id) {
        Topic topicToDelete = topicRepo.findById(id).orElseThrow();
        topicRepo.delete(topicToDelete);
    }

}
