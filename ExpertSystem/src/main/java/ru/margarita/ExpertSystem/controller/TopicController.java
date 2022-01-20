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

    @GetMapping
    public Topic read(@RequestBody Topic topic) {
        return topicService.getById(topic.getId());
    }

    @GetMapping
    public Iterable<Topic> getAll(@RequestBody Topic topic) {
        return topicService.getAll();
    }

    @PatchMapping
    public void update (@RequestBody Topic topic) {
        topicService.update(topic);
    }

    @DeleteMapping
    public void delete (@RequestBody Topic topic) {
        topicService.delete(topic);
    }
}
