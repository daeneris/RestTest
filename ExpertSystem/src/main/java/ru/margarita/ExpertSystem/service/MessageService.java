package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.domain.Message;
import ru.margarita.ExpertSystem.repository.MessageRepo;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;

    public Message create (Message message) {
        return messageRepo.save(message);
    }

    public Message getById(int id) {
        return messageRepo.findById((long)id).get();
    }

    public Iterable<Message> getAll() {
        return messageRepo.findAll();
    }

    public void update (Message message) {
        Message messageToUpdate = messageRepo.findById((long) message.getId()).get();
        messageRepo.save(messageToUpdate);
    }

    public void delete (Message message) {
        messageRepo.delete(message);
    }
}
