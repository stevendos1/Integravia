package com.grow.data.reto.reto_growdata.Controllers;

import com.grow.data.reto.reto_growdata.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class RouteController {
    @Autowired
    private RouteService service;

    @CrossOrigin(origins = "*") // Habilita CORS solo para esta ruta
    @GetMapping("/route")
    public ResponseEntity<?> getRoute(
            @RequestParam double originLat,
            @RequestParam double originLon,
            @RequestParam double destinationLat,
            @RequestParam double destinationLon) throws Exception {

        return service.getRoute(originLat, originLon, destinationLat, destinationLon);

    }
}
