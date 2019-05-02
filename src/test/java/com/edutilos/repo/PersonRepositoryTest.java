package com.edutilos.repo;

import com.edutilos.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Nijat Aghayev on 02.05.19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {
    @Resource
    private PersonRepository repo;



    @Test
    public void testFindByNameOrAgeBetweenOrWageBetweenOrActive() {
        List<Person> some = repo.findByNameOrAgeBetweenOrWageBetweenOrActive(
                "foo", 10, 20, 100.0, 200.0, true);
        assertNotNull(some);
        assertThat(some.size() > 1, is(true));
    }

    @Test
    public void testFindByNameAndAgeBetweenAndWageBetweenAndActive() {
        List<Person> some = repo.findByNameAndAgeBetweenAndWageBetweenAndActive(
                "foo", 10, 20, 100.0, 200.0, true);
        assertNotNull(some);
        assertThat(some.size() == 1, is(true));
    }


    @Test
    public void testFindByWageBetween() {
        List<Person> some = repo.findByWageBetween(200.0, 300.0);
        assertNotNull(some);
        assertThat(some.isEmpty(), is(false));
    }

    @Test
    public void testFindByAgeBetween() {
        List<Person> some = repo.findByAgeBetween(10, 20);
        assertNotNull(some);
        assertThat(some.isEmpty(), is(false));
    }

    @Test
    public void testFindByActive() {
        List<Person> some = repo.findByActive(true);
        assertNotNull(some);
        assertThat(some.isEmpty(), is(false));
    }

    @Test
    public void testFindByWage() {
        List<Person> some = repo.findByWage(100.0);
        assertNotNull(some);
        assertThat(some.isEmpty(), is(false));
        assertThat(some.size() == 1, is(true));
    }

    @Test
    public void testFindByAge() throws Exception {
        List<Person> some = repo.findByAge(10);
        assertNotNull(some);
        assertThat(some.isEmpty(), is(false));
        assertThat(some.size() == 1, is(true));
    }


    @Test
    public void testFindByName() throws Exception {
        List<Person> some = repo.findByName("foo");
        assertNotNull(some);
        assertThat(some.isEmpty(), is(false));
        assertThat(some.size() == 1, is(true));
    }

    @Test
    public void testFindAll() {
        List<Person> all = StreamSupport.stream(repo.findAll().spliterator(), true)
                .collect(Collectors.toList());
        assertNotNull(all);
        assertThat(all.isEmpty(), is(false));
    }
}
