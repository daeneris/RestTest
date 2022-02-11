package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.service.PersonService;


@RequestMapping("/api/person")
@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping(value = "/{id}")
    public PersonDTO read(@PathVariable int id) {
        return personService.getById(id);
    }

    @GetMapping
    public Iterable<PersonDTO> getAll() {
        return personService.getAll();
    }

    @PatchMapping
    public void update (@RequestBody PersonDTO personDTO) {
        personService.update(personDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        personService.delete(id);
    }
}
