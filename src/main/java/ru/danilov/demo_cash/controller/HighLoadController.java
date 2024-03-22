package ru.danilov.demo_cash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danilov.demo_cash.model.Person;
import ru.danilov.demo_cash.service.HighLoadService;

import java.util.logging.Logger;

@RestController
public class HighLoadController {
    private final HighLoadService highLoadService;
    private final Logger logger = Logger.getLogger(HighLoadController.class.getName());

    @Autowired
    public HighLoadController(HighLoadService highLoadService) {
        this.highLoadService = highLoadService;
    }

    @GetMapping("/{id}")
    public Person getOrCreate(@PathVariable("id") int personId) {
        logger.info("getOrCreatePerson" + personId);
        return highLoadService.getOrCreatePerson(personId);
    }

    @PutMapping("/{id}")
    public Person createOrUpdate(@PathVariable("id") int personId) {
        logger.info("createOrUpdate");
        return highLoadService.createOrUpdate(personId);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int personId) {
        logger.info("deletePerson");
        highLoadService.deletePerson(personId);
        return "Person " + personId + " deleted";
    }

}

