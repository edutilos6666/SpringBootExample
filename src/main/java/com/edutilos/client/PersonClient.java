package com.edutilos.client;

import com.edutilos.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Nijat Aghayev on 02.05.19.
 */
@SpringBootApplication
public class PersonClient {
    public static void main(String[] args) {
        PersonClient runner = new PersonClient();
        runner.doRun();
    }

    private static final String BASE_URL = "http://localhost:8080/people";
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonClient.class.getName());
    private RestTemplate restTemplate = new RestTemplate();

    private void doRun() {
        LOGGER.info("<<findAll()>>");
        testFindAll();
        LOGGER.info("");
        LOGGER.info("<<findByName()>>");
        testFindByName();
        LOGGER.info("");
        LOGGER.info("<<findByAge()>>");
        testFindByAge();
        LOGGER.info("");
        LOGGER.info("<<findByWage()>>");
        testFindByWage();
        LOGGER.info("");
        LOGGER.info("<<findByActive()>>");
        testFindByActive();
        LOGGER.info("");
        // does not work
        LOGGER.info("<<findByNameLike()>>");
        testFindByNameLike();
        LOGGER.info("");
        LOGGER.info("<<findByAgeBetween()>>");
        testFindByAgeBetween();
        LOGGER.info("");
        LOGGER.info("<<findByWageBetween()>>");
        testFindByWageBetween();
        LOGGER.info("");
        LOGGER.info("<<findByNameAndAgeBetweenAndWageBetweenAndActive()>>");
        testFindByNameAndAgeBetweenAndWageBetweenAndActive();
        LOGGER.info("");
        LOGGER.info("<<findByNameOrAgeBetweenOrWageBetweenOrActive()>>");
        testFindByNameOrAgeBetweenOrWageBetweenOrActive();
        LOGGER.info("");
        LOGGER.info("<<save()>>");
        testSave();
        LOGGER.info("");
        LOGGER.info("<<delete()>>");
        testDelete();
        LOGGER.info("");
    }



    public void testDelete() {
        String url = String.format("%s/17", BASE_URL);
        restTemplate.delete(url);
        url = String.format("%s/18", BASE_URL);
        restTemplate.delete(url);
        printListOfPeople(BASE_URL);
    }

    public void testSave() {
        Person p = restTemplate.postForObject(BASE_URL, new Person("leo", 50, 500.0, true),Person.class);
        printListOfPeople(BASE_URL);
    }

    public void testFindByNameOrAgeBetweenOrWageBetweenOrActive() {
        String url = String.format("%s/all-together-or/foo/10/20/200.0/300.0/true", BASE_URL);
        printListOfPeople(url);
    }

    public void testFindByNameAndAgeBetweenAndWageBetweenAndActive() {
        String url = String.format("%s/all-together/foo/10/20/100.0/200.0/true", BASE_URL);
        printListOfPeople(url);
    }
    public void testFindByWageBetween() {
        String url = String.format("%s/wage-between/200.0/350.0", BASE_URL);
        printListOfPeople(url);
    }
    public void testFindByAgeBetween() {
        String url = String.format("%s/age-between/10/20", BASE_URL);
        printListOfPeople(url);
    }
    // does not work
    public void testFindByNameLike() {
        String url = String.format("%s/name-like/b", BASE_URL);
        printListOfPeople(url);
    }

    public void testFindByActive() {
        String url = String.format("%s/active/false", BASE_URL);
        printListOfPeople(url);
    }
    public void testFindByWage() {
        String url = String.format("%s/wage/100.0", BASE_URL);
        printListOfPeople(url);
    }

    public void testFindByAge() {
        String url = String.format("%s/age/10", BASE_URL);
        printListOfPeople(url);
    }

    public void testFindByName() {
        String url = String.format("%s/name/foo", BASE_URL);
        printListOfPeople(url);
    }

    public void testFindAll() {
        // did not work
//        PersonList personListWrapper = restTemplate.getForObject(BASE_URL, PersonList.class);
//        personListWrapper.getPersonList().forEach(one-> LOGGER.info(one.toString()));
        printListOfPeople(BASE_URL);
    }



    private void printListOfPeople(String url) {
        restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Person>>() {})
                .getBody()
                .forEach(one-> LOGGER.info(one.toString()));
    }

}
