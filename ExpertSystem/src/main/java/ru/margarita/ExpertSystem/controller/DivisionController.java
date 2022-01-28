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

    @GetMapping(value = "/{id}")
    public Division read(@PathVariable int id) {
        return divisionService.getById(id);
    }

    @GetMapping
    public Iterable<Division> getAll() {
        return divisionService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        divisionService.delete(id);
    }
}
