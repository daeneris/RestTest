package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Topic;

import java.util.List;

@Mapper
public interface TopicMapper {

    TopicDTO toTopicDTO(Topic topic);

    Topic toTopic (TopicDTO topicDTO);

    List<TopicDTO> toTopicDTOs (List<Topic> topic);
}
