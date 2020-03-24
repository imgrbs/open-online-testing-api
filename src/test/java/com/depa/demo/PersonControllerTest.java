package com.depa.demo;

import com.depa.demo.controllers.PersonController;
import com.depa.demo.models.LeaderImpl;
import com.depa.demo.models.Person;
import org.junit.jupiter.api.Test;

class PersonControllerTest {

    @Test
    void testPostPerson() {
        PersonController controller = new PersonController();
        controller.createPerson(new LeaderImpl());
    }

    @Test
    void testConvert() {
        Person leader = new LeaderImpl();
        System.out.println(((LeaderImpl) leader).getName());
    }
}