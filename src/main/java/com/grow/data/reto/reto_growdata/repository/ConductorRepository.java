package com.grow.data.reto.reto_growdata.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grow.data.reto.reto_growdata.entity.Conductor;

@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Long> {

    @Query("select c from Conductor c where c.gmail = ?1")
    Conductor buscarPorCorreo(String gmail, String password);

}
