package com.edutilos.controller;

import com.edutilos.model.Person;
import com.edutilos.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Nijat Aghayev on 02.05.19.
 */
@RestController
@RequestMapping("/people")
public class PersonControler {
    @Autowired
    private PersonRepository repo;

    @PostMapping
    public void save(@RequestBody Person person) {
        repo.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        repo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable(required = true) long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping
    public List<Person> findAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), true)
                .   collect(Collectors.toList());
    }

    @GetMapping("/name/{name}")
    public List<Person> findByName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @GetMapping("/age/{age}")
    public List<Person> findByAge(@PathVariable int age) {
        return repo.findByAge(age);
    }

    @GetMapping("/wage/{wage}")
    public List<Person> findByWage(@PathVariable double wage) {
        return repo.findByWage(wage);
    }

    @GetMapping("/active/{active}")
    public List<Person> findByActive(@PathVariable boolean active) {
        return repo.findByActive(active);
    }

    @GetMapping("/name-like/{name}")
    public List<Person> findByNameLike(@PathVariable("name") String name) {
        return repo.findByNameLike(name);
    }

    @GetMapping("/age-between/{min-age}/{max-age}")
    public List<Person> findByAgeBetween(@PathVariable("min-age") int minAge,
                                         @PathVariable("max-age") int maxAge) {
        return repo.findByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/wage-between/{min-wage}/{max-wage}")
    public List<Person> findByWageBetween(@PathVariable("min-wage") double minWage,
                                          @PathVariable("max-wage") double maxWage) {
        return repo.findByWageBetween(minWage, maxWage);
    }

    @GetMapping("/all-together/{name}/{min-age}/{max-age}/{min-wage}/{max-wage}/{active}")
    public List<Person> findByNameAndAgeBetweenAndWageBetweenAndActive(
            @PathVariable("name") String name,
            @PathVariable("min-age") int minAge, @PathVariable("max-age") int maxAge,
            @PathVariable("min-wage") double minWage, @PathVariable("max-wage") double maxWage,
            @PathVariable("active") boolean active
    ) {
        return repo.findByNameAndAgeBetweenAndWageBetweenAndActive(
                name, minAge, maxAge, minWage, maxWage, active
        );
    }

    @GetMapping("/all-together-or/{name}/{min-age}/{max-age}/{min-wage}/{max-wage}/{active}")
    public List<Person> findByNameOrAgeBetweenOrWageBetweenOrActive(
            @PathVariable("name") String name,
            @PathVariable("min-age") int minAge, @PathVariable("max-age") int maxAge,
            @PathVariable("min-wage") double minWage, @PathVariable("max-wage") double maxWage,
            @PathVariable("active") boolean active
    ) {
        return repo.findByNameOrAgeBetweenOrWageBetweenOrActive(
                name, minAge, maxAge, minWage, maxWage, active
        );
    }
}
