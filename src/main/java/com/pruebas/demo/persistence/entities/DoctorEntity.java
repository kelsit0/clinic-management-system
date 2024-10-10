package com.pruebas.demo.persistence.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="doctors")
public class DoctorEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    private int age;

    @Min(5)
    @Max(20)
    private String cedule;

    //relacion con pacientes
    @ManyToMany
    @JoinTable(
            name="doctor_patient", //nombre de la tabla intermedia
            joinColumns = @JoinColumn(name="doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<PatientEntity> patients = new ArrayList<>();

}
