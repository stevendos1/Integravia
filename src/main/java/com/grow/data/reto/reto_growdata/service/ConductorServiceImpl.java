package com.grow.data.reto.reto_growdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grow.data.reto.reto_growdata.entity.Conductor;
import com.grow.data.reto.reto_growdata.repository.ConductorRepository;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository repository;

    public List<Conductor> list() {

        List<Conductor> c = (List<Conductor>) repository.findAll();
        return c;
    }

    public Conductor create(Conductor c) {
        Conductor conductor = new Conductor();
        conductor.setCedula(c.getCedula());
        conductor.setNombre(c.getNombre());
        conductor.setCategoria(c.getCategoria());
        conductor.setFechaExpedicion(c.getFechaExpedicion());
        conductor.setFechaVencimiento(c.getFechaVencimiento());
        conductor.setHistorialMultas(c.getHistorialMultas());
        conductor.setGmail(c.getGmail());
        conductor.setNoLicencia(c.getNoLicencia());
        conductor.setPassword(c.getPassword());

        return repository.save(conductor);
    }

    @Override
    public Conductor buscar(String gmail, String password) {

        Conductor c = repository.buscarPorCorreo(gmail, password);

        if (c.getPassword().equals(password)) {
            return c;
        } else {
            return null;
        }

    }
}
