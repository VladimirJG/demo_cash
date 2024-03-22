package ru.danilov.demo_cash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.danilov.demo_cash.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
