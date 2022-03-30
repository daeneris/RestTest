package ru.margarita.RestTestProject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.margarita.RestTestProject.DTO.PersonDTO;
import ru.margarita.RestTestProject.Kafka.KafkaProducer;
import ru.margarita.RestTestProject.entity.Person;
import ru.margarita.RestTestProject.mapper.PersonMapper;
import ru.margarita.RestTestProject.repository.PersonRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;
    private final PersonMapper personMapper;
    private final KafkaProducer kafkaProducer;

    @Value("${kafka.createdPerson}")
    private String kafkaCreatedPerson;

    @Value("${kafka.updatedPerson}")
    private String kafkaUpdatedPerson;

    @Value("${kafka.deletePerson}")
    private String kafkaPersonToDelete;

    @Transactional
    public PersonDTO create(PersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        person = personRepo.save(person);

        PersonDTO newPersonDTO = personMapper.toPersonDTO(person);

        kafkaProducer.sendKafka(kafkaCreatedPerson, newPersonDTO);

        return newPersonDTO;
    }

    public PersonDTO getById(int id) {
        Person person = personRepo.findById(id).orElseThrow();
        return personMapper.toPersonDTO(person);

    }

    public Iterable<PersonDTO> getAll(String surname, Date startDate, Date endDate, int departmentId) {

        Iterable<Person> personList = null;

        if (surname != null) {
            if (startDate != null) {
                if (departmentId != 0) {
                    personList = personRepo.findDistinctBySurnameAndBirthDateBetweenAndDepartment_Id(surname, startDate, endDate, departmentId);
                } else {
                    personList = personRepo.findDistinctBySurnameAndBirthDateBetween(surname, startDate, endDate);
                }
            } else {
                if (departmentId != 0) {
                    personList = personRepo.findDistinctBySurnameAndDepartment_Id(surname, departmentId);
                } else {
                    personList = personRepo.findDistinctBySurname(surname);
                }
            }
        } else {
            if (startDate != null) {
                if (departmentId != 0) {
                    personList = personRepo.findDistinctByBirthDateBetweenAndDepartment_Id(startDate, endDate, departmentId);
                } else {
                    personList = personRepo.findDistinctByBirthDateBetween(startDate, endDate);
                }
            } else {
                if (departmentId != 0) {
                    personList = personRepo.findDistinctByDepartment_Id(departmentId);
                } else {
                    personList = personRepo.findAll();
                }
            }
        }

        List<PersonDTO> allPersonDTO = null;
        for (Person person : personList) {
            allPersonDTO.add(personMapper.toPersonDTO(person));
        }
        return allPersonDTO;
    }

    public void update (PersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        Person personToUpdate = personRepo.findById(person.getId()).orElseThrow();

  //      kafkaProducer.sendKafka(kafkaUpdatedPerson, person);

        personRepo.save(personToUpdate);
    }

    public void delete (int id) {
        Person personToDelete = personRepo.findById(id).orElseThrow();

   //     kafkaProducer.sendKafka(kafkaPersonToDelete, personToDelete);

        personRepo.delete(personToDelete);
    }

}
