package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Message;
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

    public Iterable<TopicDTO> getAll(Integer page, Integer size){

        Page<Topic> topics = topicRepo.findAll(PageRequest.of(page, size));
        return topics.map(topicMapper::toTopicDTO);

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
