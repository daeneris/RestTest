package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.margarita.ExpertSystem.DTO.MessageDTO;
import ru.margarita.ExpertSystem.domain.Message;



@Mapper (componentModel = "spring", uses=PersonMapper.class)
public interface MessageMapper {

    @Mapping(target = "topicId", source = "message.topic.id")
    MessageDTO toMessageDTO(Message message);

    Message toMessage (MessageDTO messageDTO);

}
