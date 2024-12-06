package com.grow.data.reto.reto_growdata.service;

import org.springframework.http.ResponseEntity;

public interface RouteService {

    ResponseEntity<?> getRoute(double originLat, double originLon, double destinationLat, double destinationLon);

}
