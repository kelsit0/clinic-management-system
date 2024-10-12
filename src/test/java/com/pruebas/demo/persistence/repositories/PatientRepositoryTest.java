package com.pruebas.demo.persistence.repositories;

import com.pruebas.demo.persistence.entities.PatientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.cglib.core.Local;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        PatientEntity patient =
                PatientEntity.builder().
                        age(12).
                        NSS("shjd12h23d")
                        .name("jose casablancas")
                        .gender("male").build();

    entityManager.persist(patient);
    }
    @Test
    public void testFindByName() {
        PatientEntity myPatient = patientRepository.findByName("jose casablancas");
        assertEquals("jose casablancas", myPatient.getName());
    }

    @Test
    public void testNotFindByName() {
        PatientEntity myPatient = patientRepository.findByName("john newman");
        assertNull(myPatient);
    }

}