package com.pruebas.demo.persistence.repositories;

import com.pruebas.demo.persistence.entities.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity,Long> {

    @Override
    List<DoctorEntity> findAll();

}
