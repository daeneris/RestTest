package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.domain.Division;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.service.DivisionService;
import ru.margarita.ExpertSystem.service.TopicService;

@RequestMapping("/api/division")
@RestController
@AllArgsConstructor
public class DivisionController {
    private final DivisionService divisionService;

    @PostMapping
    public Division create(@RequestBody Division division)
    {
        return divisionService.create(division);
    }

    @GetMapping
    public Division read(@RequestBody Division division) {
        return divisionService.getById(division.getId());
    }

    @GetMapping
    public Iterable<Division> getAll(@RequestBody Division division) {
        return divisionService.getAll();
    }

    @DeleteMapping
    public void delete (@RequestBody Division division) {
        divisionService.delete(division);
    }
}
