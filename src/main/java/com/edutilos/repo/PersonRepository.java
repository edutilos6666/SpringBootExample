package com.edutilos.repo;

import com.edutilos.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nijat Aghayev on 02.05.19.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findByAge(Integer age);
    List<Person> findByWage(Double wage);
    List<Person> findByActive(Boolean active);
    List<Person> findByNameLike(String name);
    List<Person> findByAgeBetween(Integer minAge, Integer maxAge);
    List<Person> findByWageBetween(Double minWage, Double maxWage);
    List<Person> findByNameAndAgeBetweenAndWageBetweenAndActive(
            String name, Integer minAge, Integer maxAge, Double minWage, Double maxWage, Boolean active
    );
    List<Person> findByNameOrAgeBetweenOrWageBetweenOrActive(
            String name, Integer minAge, Integer maxAge, Double minWage, Double maxWage, Boolean active
    );
}
