package ru.danilov.demo_cash.controller;

import org.springframework.web.bind.annotation.*;
import ru.danilov.demo_cash.model.Person;
import ru.danilov.demo_cash.service.HighLoadService;

@RestController
public class HighLoadController {
    private final HighLoadService highLoadService;

    public HighLoadController(HighLoadService highLoadService) {
        this.highLoadService = highLoadService;
    }

    @GetMapping("/{id}")
    public Person getOrCreate(@PathVariable("id") int personId) {
        return highLoadService.getOrCreatePerson(personId);
    }

    @PutMapping("/{id}")
    public Person createOrUpdate(@PathVariable("id") int personId) {
        return highLoadService.createOrUpdate(personId);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int personId) {
        highLoadService.deletePerson(personId);
        return "Person " + personId + " deleted";
    }

}

