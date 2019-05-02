package com.edutilos.util;

import com.edutilos.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nijat Aghayev on 02.05.19.
 */
@AllArgsConstructor
@Getter
@Setter
public class PersonList {
    private List<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }
}
