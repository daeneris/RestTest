package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.DTO.TopicDTO;
import ru.margarita.ExpertSystem.service.TopicService;

@RequestMapping("/api/topic")
@RestController
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public TopicDTO create(@RequestBody TopicDTO topicDTO) {
        return topicService.create(topicDTO);
    }

    @GetMapping(value = "/{id}")
    public TopicDTO read(@PathVariable int id) {
        return topicService.getById(id);
    }


    @GetMapping
    public Iterable<TopicDTO> getAll(@RequestParam (defaultValue = "0", required = false) int page,
                                     @RequestParam (defaultValue = "30", required = false) int size) {
        return topicService.getAll(page, size);
    }

    @PatchMapping
    public void update (@RequestBody TopicDTO topicDTO) {
        topicService.update(topicDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        topicService.delete(id);
    }
}
