package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.DTO.MessageDTO;
import ru.margarita.ExpertSystem.service.MessageService;

@RequestMapping("/api/message")
@RestController
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public MessageDTO create(@RequestBody MessageDTO messageDTO) {
        return messageService.create(messageDTO);
    }

    @GetMapping(value = "/{id}")
    public MessageDTO read(@PathVariable int id) {
        return messageService.getById(id);
    }

    @GetMapping
    public Iterable<MessageDTO> getAll(@RequestParam (defaultValue = "0", required = false) int page,
             @RequestParam (defaultValue = "30", required = false) int size ) {
        return messageService.getAll(page, size);
    }

    @PatchMapping
    public void update (@RequestBody MessageDTO messageDTO) {
        messageService.update(messageDTO);
    }

    @DeleteMapping(value="/{id} ")
    public void delete (@PathVariable int id) {
        messageService.delete(id);
    }
}
