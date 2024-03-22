package ru.danilov.demo_cash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilov.demo_cash.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
