package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.margarita.ExpertSystem.DTO.MessageDTO;
import ru.margarita.ExpertSystem.domain.Message;
import ru.margarita.ExpertSystem.repository.TopicRepo;


@Mapper (componentModel = "spring", uses=PersonMapper.class)
public abstract class MessageMapper {

    @Autowired
    protected TopicRepo topicRepo;

    @Mapping(target = "topicId", source = "message.topic.id")
    public abstract MessageDTO toMessageDTO(Message message);

    @Mapping(target = "topic", expression = "java(topicRepo.findById(messageDTO.getTopicId()).orElseThrow())")
    public abstract Message toMessage (MessageDTO messageDTO);
}
