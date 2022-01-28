package ru.margarita.ExpertSystem.mapper;

import org.mapstruct.Mapper;
import ru.margarita.ExpertSystem.DTO.MessageDTO;
import ru.margarita.ExpertSystem.domain.Message;


import java.util.List;

@Mapper
public interface MessageMapper {

    MessageDTO toMessageDTO(Message message);

    Message toMessage (MessageDTO messageDTO);

    List<MessageDTO> toMessageDTOs (List<Message> message);
}
