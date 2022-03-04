package ru.margarita.RestTestProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.margarita.RestTestProject.DTO.PersonDTO;
import ru.margarita.RestTestProject.service.PersonService;

import java.util.Date;


@RequestMapping("/api/person")
@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;



//    public @ResponseBody String testMe(@RequestParam("odate") @DateTimeFormat(pattern="yyyy-MM-dd") Date odate) {

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping(value = "/{id}")
    public PersonDTO read(@PathVariable int id) {
        return personService.getById(id);
    }


    //2.	REST для вывода списка сотрудников с фильтрами по фамилии, дате рождения, подразделению
    @GetMapping()
    public Iterable<PersonDTO> getAll(@RequestParam(required = false) String surname,
                                      @RequestParam(required = false) Date startDate,
                                      @RequestParam(required = false) Date endDate,
                                      @RequestParam(required = false) int departmentId) {
        return personService.getAll(surname, startDate,endDate, departmentId);
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
