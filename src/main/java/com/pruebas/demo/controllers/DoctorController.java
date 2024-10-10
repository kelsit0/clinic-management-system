package com.pruebas.demo.controllers;


import com.pruebas.demo.persistence.entities.DoctorEntity;
import com.pruebas.demo.persistence.repositories.DoctorRepository;
import com.pruebas.demo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorEntity> getDoctors(){
        return doctorService.getAll();
    }


    @PostMapping("/create")
    public DoctorEntity root(@RequestBody DoctorEntity d){
        return doctorService.createDoctor(d);
    }

}
