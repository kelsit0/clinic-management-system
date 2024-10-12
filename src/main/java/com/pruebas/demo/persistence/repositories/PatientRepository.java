package com.pruebas.demo.persistence.repositories;

import com.pruebas.demo.persistence.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long> {
    @Override
    List<PatientEntity> findAll();

    PatientEntity findByName(String name);
}
