package com.pruebas.demo.services;

import com.pruebas.demo.exceptions.ResourceNotFoundException;
import com.pruebas.demo.persistence.entities.PatientEntity;
import com.pruebas.demo.persistence.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientEntity createPatient(PatientEntity patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        if(!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient id not found: "+ id);
        }
        patientRepository.deleteById(id);
    }

    public PatientEntity updatePatient(Long id, PatientEntity patient) {
        PatientEntity myPatient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found"+ id));

        myPatient.setName(patient.getName());
        myPatient.setGender(patient.getGender());
        myPatient.setNSS(patient.getNSS());
        myPatient.setAge(patient.getAge());

        return patientRepository.save(myPatient);

    }


}
