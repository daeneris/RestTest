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

    @GetMapping(value = "/{id}")
    public Message read(@PathVariable int id) {
        return messageService.getById(id);
    }

    @GetMapping
    public Iterable<Message> getAll() {
        return messageService.getAll();
    }

    @PatchMapping
    public void update (@RequestBody Message message) {
        messageService.update(message);
    }

    @DeleteMapping(value="/{id} ")
    public void delete (@PathVariable int id) {
        messageService.delete(id);
    }
}
