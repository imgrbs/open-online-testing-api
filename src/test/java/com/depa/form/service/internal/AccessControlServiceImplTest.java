/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.service.internal;

import com.depa.form.repository.FormRepository;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Test
 */
class AccessControlServiceImplTest {
    
    private Mockery mockery = new JUnit4Mockery();

    private FormServiceImpl underTest;
    private FormRepository mockFormRepository;

    @BeforeEach
    public void setUp() {
        underTest = new FormServiceImpl();
        mockFormRepository = mockery.mock(FormRepository.class);
        underTest.setFormRepository(mockFormRepository);
    }
    
}
