package ru.margarita.RestTestProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.margarita.RestTestProject.DTO.PersonDTO;
import ru.margarita.RestTestProject.service.SoapService;

@RequestMapping("/api/salary")
@RestController
@AllArgsConstructor
public class SalaryController {
    private final SoapService soapService;

    @GetMapping(value = "/{id}")
    public Integer calculateSalary (@PathVariable Integer id) {
        return soapService.calculateSalary(id);
    }
}
