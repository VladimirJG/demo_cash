package ru.danilov.demo_cash.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.danilov.demo_cash.model.Person;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Service
public class HighLoadService {
    @Cacheable(cacheNames = {"personCache"}, key = "#personId")
    public Person getOrCreatePerson(int personId) {
        try {
            TimeUnit.SECONDS.sleep(3L);
            return new Person(personId, "Ivan", "Pass", LocalTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @CachePut(cacheNames = {"personCache"}, key = "#personId")
    public Person createOrUpdate(int personId){
        return new Person(personId, "Sokol", "Sokol", LocalTime.now());
    }
    @CacheEvict(cacheNames = {"personCache"}, key = "#personId")
    public void deletePerson(int personId){
        //удаление из базы...
    }
}
