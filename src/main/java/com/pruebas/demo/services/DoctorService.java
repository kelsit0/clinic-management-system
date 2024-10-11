package com.pruebas.demo.services;

import com.pruebas.demo.exceptions.ResourceNotFoundException;
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

    public DoctorEntity getDoctor(Long id){
        if(!doctorRepository.existsById(id)){
            throw new ResourceNotFoundException("Doctor no encontrado");
        }
        return doctorRepository.findById(id).get();
    }

    public void deleteDoctor(Long id){
        if(!doctorRepository.existsById(id)){
            throw new ResourceNotFoundException("Doctor not found +"+ id);
        }
        doctorRepository.deleteById(id);
    }

    public DoctorEntity updateDoctor(Long id, DoctorEntity doc){
        DoctorEntity doctor = doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found +"+ id));
        doctor.setName(doc.getName());
        doctor.setAge(doc.getAge());
        doctor.setCedule(doc.getCedule());

        return doctorRepository.save(doctor);

    }
}
