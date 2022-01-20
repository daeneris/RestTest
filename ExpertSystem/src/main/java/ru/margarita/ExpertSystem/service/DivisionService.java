package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.domain.Division;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.repository.DivisionRepo;


@Service
@AllArgsConstructor
public class DivisionService {
    private final DivisionRepo divisionRepo;

    public Division create(Division division) {
        return divisionRepo.save(division);
    }

    public Iterable<Division> getAll(){
        return divisionRepo.findAll();
    }

    public Division getById(int id) {
        return divisionRepo.findById((long)id).get();
    }

    public void delete (Division division) {
        divisionRepo.delete(division);
    }

}
