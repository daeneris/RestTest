package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.service.TopicService;

@RequestMapping("/api/topic")
@RestController
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public Topic create(@RequestBody Topic topic) {
        return topicService.create(topic);
    }

    @GetMapping(value = "/{id}")
    public Topic read(@PathVariable int id) {
        return topicService.getById(id);
    }

    @GetMapping
    public Iterable<Topic> getAll() {
        return topicService.getAll();
    }

    @PatchMapping
    public void update (@RequestBody Topic topic) {
        topicService.update(topic);
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        topicService.delete(id);
    }
}
