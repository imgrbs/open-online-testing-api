package com.depa.demo.controllers;

import com.depa.demo.models.LeaderImpl;
import com.depa.demo.models.Person;
import com.depa.demo.models.PersonImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        System.out.println(person);

        if (person == null) {
            return null;
        }

        if (person instanceof LeaderImpl) {
            System.out.println(
                    ((LeaderImpl) person).getName()
            );
        }

        return person;
    }
}
