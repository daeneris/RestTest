package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.service.PersonService;


@RequestMapping("/api/person")
@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @GetMapping(value = "/{id}")
    public Person read(@PathVariable int id) {
        return personService.getById(id);
    }

    @GetMapping
    public Iterable<Person> getAll() {
        return personService.getAll();
    }

    @PatchMapping
    public void update (@RequestBody Person person) {
        personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        personService.delete(id);
    }
}
