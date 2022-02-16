package ru.margarita.ExpertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.margarita.ExpertSystem.domain.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName (String name);
}
