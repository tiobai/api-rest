package com.gabriel.app.Repositories;

import com.gabriel.app.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
