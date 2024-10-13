package com.pruebas.demo.services;

import com.pruebas.demo.persistence.entities.PatientEntity;
import com.pruebas.demo.persistence.repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    public void updatePatient(){

        Long patientId = 1L; // Id del paciente que queremos actualizar
        PatientEntity existingPatient = new PatientEntity().builder()
                .id(patientId)
                .age(45)
                .NSS("previousNSS")
                .name("Old Name")
                .gender("male")
                .build();

        PatientEntity updatedPatient = new PatientEntity().builder()
                .id(patientId)
                .age(50)
                .NSS("newNSS")
                .name("New Name")
                .gender("female")
                .build();
        // Mock para que cuando se llame a findById(), devuelva el paciente existente
        Mockito.when(patientRepository.findById(patientId)).thenReturn(Optional.of(existingPatient));

        // Mock para cuando se llame a save(), devuelva el paciente actualizado
        Mockito.when(patientRepository.save(existingPatient)).thenReturn(updatedPatient);

        // Ejecutamos el método del servicio
        PatientEntity result = patientService.updatePatient(patientId, updatedPatient);

        // Verificamos que el resultado es el paciente actualizado
        assertEquals(result.getName(), "New Name");
        assertEquals(result.getNSS(), "newNSS");
        assertEquals(result.getAge(), 50);

        // Verificamos que el método save() fue llamado con el paciente correcto
        Mockito.verify(patientRepository).save(existingPatient);


    }


}