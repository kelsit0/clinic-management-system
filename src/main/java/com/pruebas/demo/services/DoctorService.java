package com.pruebas.demo.services;

import com.pruebas.demo.persistence.entities.DoctorEntity;
import com.pruebas.demo.persistence.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorEntity> getAll(){
        return doctorRepository.findAll();
    }

    public DoctorEntity createDoctor(DoctorEntity doc){
        return doctorRepository.save(doc);
    }

}
