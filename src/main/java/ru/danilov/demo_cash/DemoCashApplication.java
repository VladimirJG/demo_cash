package ru.danilov.demo_cash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@EnableCaching
@SpringBootApplication
public class DemoCashApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCashApplication.class, args);
    }


}
