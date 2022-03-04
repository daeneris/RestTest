package ru.margarita.RestTestProject.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.margarita.RestTestProject.DTO.DepartmentDTO;
import ru.margarita.RestTestProject.service.DepartmentService;


@RequestMapping("/api/department")
@RestController
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;


    @ApiOperation(value = "Создание департамента")
    @PostMapping()
    public ResponseEntity<DepartmentDTO> create(@RequestBody DepartmentDTO departmentDTO)
    {
        return ResponseEntity.ok(departmentService.create(departmentDTO));
    }

   // @RequestMapping(value = "/custom", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public DepartmentDTO read(@PathVariable int id) {
        return departmentService.getById(id);
    }

    @RequestMapping(value = "/custom", method = RequestMethod.GET)
//    @GetMapping
    public Iterable<DepartmentDTO> getAll() {
        return departmentService.getAll();
    }

    @PatchMapping
    public void update(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.update(departmentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete (@PathVariable int id) {
        departmentService.delete(id);
    }
}
