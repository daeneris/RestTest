package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.MessageDTO;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.domain.Message;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.mapper.MessageMapper;
import ru.margarita.ExpertSystem.repository.MessageRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;
    private final MessageMapper messageMapper;

    public MessageDTO create (MessageDTO messageDTO) {
        Message message = messageMapper.toMessage(messageDTO);
        message = messageRepo.save(message);
        return messageMapper.toMessageDTO(message);
    }

    public MessageDTO getById(int id) {
        Message message = messageRepo.findById(id).orElseThrow();
        return messageMapper.toMessageDTO(message);
    }

    public Iterable<MessageDTO> getAll() {
//        Iterable<Message> allMessage = messageRepo.findAll(Pageable.ofSize());

        Pageable firstPageWithElements = PageRequest.of(0, 30);
        Page<Message> messages = messageRepo.findAll(Paging.of.firstPageWithElements);

        Iterable<Message> allMessage = messageRepo.findAll();
        List<MessageDTO> allMessageDTO = null;
        for (Message message: allMessage) {
            allMessageDTO.add(messageMapper.toMessageDTO(message));
        }
        return allMessageDTO;
    }

    public void update (MessageDTO messageDTO) {
        Message message = messageMapper.toMessage(messageDTO);
        Message messageToUpdate = messageRepo.findById(message.getId()).orElseThrow();
        messageRepo.save(messageToUpdate);
    }

    public void delete (int id) {
        Message messageToDelete = messageRepo.findById(id).orElseThrow();
        messageRepo.delete(messageToDelete);
    }
}
