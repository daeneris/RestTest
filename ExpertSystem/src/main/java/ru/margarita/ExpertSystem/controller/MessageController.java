package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.domain.Message;
import ru.margarita.ExpertSystem.service.MessageService;

@RequestMapping("/api/message")
@RestController
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageService.create(message);
    }

    @GetMapping
    public Message read(@RequestBody Message message) {
        return messageService.getById(message.getId());
    }

    @GetMapping
    public Iterable<Message> getAll(@RequestBody Message message) {
        return messageService.getAll();
    }

    @PatchMapping
    public void update (@RequestBody Message message) {
        messageService.update(message);
    }

    @DeleteMapping
    public void delete (@RequestBody Message message) {
        messageService.delete(message);
    }
}
