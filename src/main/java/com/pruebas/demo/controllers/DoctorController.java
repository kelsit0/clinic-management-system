package com.pruebas.demo.controllers;


import com.pruebas.demo.persistence.entities.DoctorEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("doctor")
public class DoctorController {

    @PostMapping("create")
    public DoctorEntity root(@RequestBody DoctorEntity doc){
        return doc;
    }

}
