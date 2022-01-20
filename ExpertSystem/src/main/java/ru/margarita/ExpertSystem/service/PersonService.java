package ru.margarita.ExpertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.domain.Topic;
import ru.margarita.ExpertSystem.repository.PersonRepo;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;

    public Person create (Person person) {
        return personRepo.save(person);
    }

    public Person getById(int id) {
        return personRepo.findById((long)id).get();
    }

    public Iterable<Person> getAll() {
        return personRepo.findAll();
    }

    public void update (Person person) {
        Person personToUpdate = personRepo.findById((long)person.getId()).get();
        personRepo.save(personToUpdate);
    }

    public void delete (Person person) {
        personRepo.delete(person);
    }
}
