package com.pruebas.demo.services;

import com.pruebas.demo.controllers.PatientController;
import com.pruebas.demo.persistence.entities.PatientEntity;
import com.pruebas.demo.persistence.repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    PatientService patientService;
    @MockBean
    PatientRepository patientRepository;

    @BeforeEach
    void setUp(){
        PatientEntity patient= new PatientEntity().builder().
                age(12).
                NSS("12983sjd").
                name("jose").
                gender("female").build();
        Mockito.when(patientRepository.findByName("jose")).thenReturn(patient);
    }
    @Test
    public void getPatientById(){
        String name ="jose";
        PatientEntity myPatient= patientService.findByName(name);
        assertEquals(myPatient.getName(),name);
    }

}