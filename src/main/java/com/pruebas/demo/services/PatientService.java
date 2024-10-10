package com.pruebas.demo.services;

import com.pruebas.demo.persistence.entities.PatientEntity;
import com.pruebas.demo.persistence.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientEntity createPatient(PatientEntity patient){
        return patientRepository.save(patient);
    }

}
