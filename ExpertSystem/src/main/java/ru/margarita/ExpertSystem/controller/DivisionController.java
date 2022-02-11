package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.DTO.DivisionDTO;
import ru.margarita.ExpertSystem.service.DivisionService;


@RequestMapping("/api/division")
@RestController
@AllArgsConstructor
public class DivisionController {
    private final DivisionService divisionService;

    @PostMapping
    public DivisionDTO create(@RequestBody DivisionDTO divisionDTO)
    {
        return divisionService.create(divisionDTO);
    }

    @GetMapping(value = "/{id}")
    public DivisionDTO read(@PathVariable int id) {
        return divisionService.getById(id);
    }

    @GetMapping
    public Iterable<DivisionDTO> getAll() {
        return divisionService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        divisionService.delete(id);
    }
}
