package com.pruebas.demo.controllers;

import com.pruebas.demo.persistence.entities.PatientEntity;
import com.pruebas.demo.persistence.repositories.PatientRepository;
import com.pruebas.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping( "patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public List<PatientEntity> getPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping("create")
    public PatientEntity createPatient(@RequestBody PatientEntity patient){
        return patientService.createPatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public PatientEntity updatePatient(@PathVariable Long id,@RequestBody PatientEntity p){
        return  patientService.updatePatient(id,p);
    }
}
