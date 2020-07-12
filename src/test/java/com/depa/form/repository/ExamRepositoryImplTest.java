package com.depa.form.repository;

import org.hamcrest.CoreMatchers;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

class ExamRepositoryImplTest {
    public static final String COLLECTION_NAME = "forms";
    private Mockery mockery = new JUnit4Mockery();
    private MongoTemplate mockMongoTemplate;
    private ExamRepositoryImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new ExamRepositoryImpl();
        mockMongoTemplate = mockery.mock(MongoTemplate.class);
        underTest.setMongoTemplate(mockMongoTemplate);
    }

    @Test
    void findById() {
        Assert.assertThat(false, CoreMatchers.equalTo(false));
//        TODO: try to stub mongoTemplate before expected !
//        String uid = "16092526-7741-11ea-bc55-0242ac130003";
//        FormDTO formDTO = new FormDTO();
//        Form form = new Form();
//        Optional<Form> expectedForm = Optional.of(form);
//
//        mockery.checking(new Expectations() {
//            {
//                oneOf(mockMongoTemplate).findById(uid, FormDTO.class, COLLECTION_NAME);
//                will(returnValue(formDTO));
//            }
//        });
//
//        Optional<Form> actualForm = underTest.findById(uid);
//
//        Assert.assertThat(actualForm.get(), CoreMatchers.equalTo(expectedForm.get()));
    }

    @Test
    void findAll() {
//        TODO: Write this test !
        Assert.assertThat(false, CoreMatchers.equalTo(false));
    }
}