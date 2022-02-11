package ru.margarita.ExpertSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
    Role findByName (String name);
}
