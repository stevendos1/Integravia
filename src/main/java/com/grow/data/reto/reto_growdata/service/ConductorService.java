
package com.grow.data.reto.reto_growdata.service;

import java.util.List;

import com.grow.data.reto.reto_growdata.entity.Conductor;

public interface ConductorService {
    List<Conductor> list();

    Conductor create(Conductor c);

    Conductor buscar(String gmail, String password);

}
