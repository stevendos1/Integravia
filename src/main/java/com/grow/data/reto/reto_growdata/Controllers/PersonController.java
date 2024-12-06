package com.grow.data.reto.reto_growdata.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.grow.data.reto.reto_growdata.entity.Conductor;
import com.grow.data.reto.reto_growdata.service.ConductorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PersonController {

    @Autowired
    private ConductorService service;

    @CrossOrigin(origins = "*") // Habilita CORS solo para esta ruta
    @GetMapping("/list/b")
    public List<Conductor> list() {
        List<Conductor> b = service.list();
        return b;
    }

    @CrossOrigin(origins = "*") // Habilita CORS solo para esta ruta
    @PostMapping("/create")
    public Conductor create(@RequestBody Conductor conductor) {

        return service.create(conductor);
    }

    @CrossOrigin(origins = "*") // Habilita CORS solo para esta ruta
    @GetMapping("/logIn")
    public void logIn(@RequestParam String correo, @RequestParam String password) {

        service.buscar(correo, password);
    }

}
