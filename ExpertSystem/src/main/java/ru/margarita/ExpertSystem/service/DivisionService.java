package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.DivisionDTO;
import ru.margarita.ExpertSystem.DTO.MessageDTO;
import ru.margarita.ExpertSystem.domain.Division;
import ru.margarita.ExpertSystem.domain.Message;
import ru.margarita.ExpertSystem.mapper.DivisionMapper;
import ru.margarita.ExpertSystem.repository.DivisionRepo;

import java.util.List;


@Service
@AllArgsConstructor
public class DivisionService {
    private final DivisionRepo divisionRepo;
    private final DivisionMapper divisionMapper;

    public DivisionDTO create(DivisionDTO divisionDTO) {
        Division division = divisionMapper.toDivision(divisionDTO);
        division = divisionRepo.save(division);
        return divisionMapper.toDivisionDTO(division);
    }

    public Iterable<DivisionDTO> getAll(){
        Iterable<Division> divisions = divisionRepo.findAll();
        List<DivisionDTO> divisionDTOS = null;
        for (Division division: divisions) {
            divisionDTOS.add(divisionMapper.toDivisionDTO(division));
        }
        return divisionDTOS;
    }

    public DivisionDTO getById(int id) {
        Division division = divisionRepo.findById(id).orElseThrow();
        return divisionMapper.toDivisionDTO(division);
    }

    public void update (DivisionDTO divisionDTO) {
        Division division = divisionMapper.toDivision(divisionDTO);
        Division divisionToUpdate = divisionRepo.findById(division.getId())
                .orElseThrow(() ->new RuntimeException("Не найден раздел "+ division.getName()));
        divisionRepo.save(divisionToUpdate);
    }

    public void delete (int id) {
        Division divisionToDelete = divisionRepo.findById(id).orElseThrow();
        divisionRepo.delete(divisionToDelete);
    }

}
