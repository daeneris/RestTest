package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.domain.Role;
import ru.margarita.ExpertSystem.mapper.PersonMapper;
import ru.margarita.ExpertSystem.repository.PersonRepo;
import ru.margarita.ExpertSystem.repository.RoleRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;
    private final PersonMapper personMapper;

//    @Autowired
    private final RoleRepo roleRepo;

    private PasswordEncoder passwordEncoder;

    public Person findByLogin (Integer login) {
        return personRepo.findByLogin(login);
    }

    public Person findByLoginAndPassword (Integer login, String password) {
        Person person = findByLogin(login);
        if (person !=null) {
            if(passwordEncoder.matches(password,person.getPassword())) {
                return person;
            }
        }
        return null;
    }

    public PersonDTO create (PersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);

        Role role = roleRepo.findByName("ROLE_USER");
        person.setRole(role);
        person.setPassword(passwordEncoder.encode(person.getPassword()));

        person = personRepo.save(person);
        return personMapper.toPersonDTO(person);
    }

    public PersonDTO getByLogin(String login) {
        Integer phoneNumber = Integer.parseInt(login);
        Person person = personRepo.findByLogin(phoneNumber);
        return personMapper.toPersonDTO(person);
    }

    public PersonDTO getById(int id) {
        Person person = personRepo.findById(id).orElseThrow();
        return personMapper.toPersonDTO(person);
    }

    public Iterable<PersonDTO> getAll() {
        Iterable<Person> allPerson = personRepo.findAll();
        List<PersonDTO> allPersonDTO = null;
        for (Person person: allPerson) {
            allPersonDTO.add(personMapper.toPersonDTO(person));
        }
        return allPersonDTO;
    }

    public void update (PersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        Person personToUpdate = personRepo.findById(person.getId()).orElseThrow();
        personRepo.save(personToUpdate);
    }

    public void delete (int id) {
        Person personToDelete = personRepo.findById(id).orElseThrow();
        personRepo.delete(personToDelete);
    }


}
