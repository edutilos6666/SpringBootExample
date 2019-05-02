package com.edutilos.config;

import com.edutilos.model.Person;
import com.edutilos.repo.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Nijat Aghayev on 02.05.19.
 */

@Component
public class CustomConfig {
    @Bean
    public CommandLineRunner createSomePeople(PersonRepository repo) {
        return (args)-> {
            repo.deleteAll();
            repo.save(new Person("foo", 10, 100.0, true));
            repo.save(new Person("bar", 20, 200.0, false));
            repo.save(new Person("bim", 30, 300.0, true));
            repo.save(new Person("pako", 40, 400.0, false));
        };
    }
}
