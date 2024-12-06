package com.grow.data.reto.reto_growdata.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${key}")
    private String key;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseEntity<?> getRoute(double originLat, double originLon, double destinationLat,
            double destinationLon) {
        // URL de la API de GraphHopper
        String url = "https://graphhopper.com/api/1/route?point="
                + originLat + "," + originLon
                + "&point=" + destinationLat + "," + destinationLon
                + "&type=json&locale=es&vehicle=car&weighting=fastest"
                + "&instructions=false&points_encoded=true&simplifyResponse=true&key=" + key;

        // Realizar la solicitud GET a la API
        String response = restTemplate.getForObject(url, String.class);

        // Verificar si la respuesta es nula o vacía
        if (response == null || response.isEmpty()) {
            return ResponseEntity.status(500).body("Respuesta vacía de la API.");
        }

        // Crear la estructura de la respuesta según el formato deseado
        ObjectNode simplifiedResponse = objectMapper.createObjectNode();

        try {
            // Convertir la respuesta JSON a un JsonNode
            JsonNode rootNode = objectMapper.readTree(response);

            // Extraer los datos relevantes (distancia, tiempo, instrucciones, etc.)
            JsonNode path = rootNode.path("paths").get(0);
            double distance = path.path("distance").asDouble(); // Distancia en metros
            long time = path.path("time").asLong(); // Tiempo en milisegundos
            JsonNode bbox = path.path("bbox"); // Bounding box (coordenadas del área)
            JsonNode points = path.path("points"); // Coordenadas de la ruta (puntos codificados)

            // Decodificar los puntos de la ruta (polyline)
            List<List<Double>> decodedCoordinates = decodePolyline(points.asText());

            // Convertir el tiempo a minutos

            // Agregar datos de hints
            ObjectNode hints = objectMapper.createObjectNode();
            hints.put("visited_nodes.sum", 110); // Aquí puedes agregar la lógica dinámica si es necesario
            hints.put("visited_nodes.average", 110);
            simplifiedResponse.set("hints", hints);

            // Agregar información adicional
            ObjectNode info = objectMapper.createObjectNode();
            info.putArray("copyrights").add("GraphHopper").add("OpenStreetMap contributors");
            info.put("took", 3);
            info.put("road_data_timestamp", "2024-11-29T17:00:00Z");
            simplifiedResponse.set("info", info);

            // Agregar los paths
            ObjectNode pathsNode = objectMapper.createObjectNode();
            pathsNode.put("distance", distance);
            pathsNode.put("weight", 589.634084); // Si este valor también debe ser dinámico, extráelo de la respuesta de
                                                 // la API
            pathsNode.put("time", time);
            pathsNode.put("transfers", 0);
            pathsNode.put("points_encoded", false);

            // Agregar bbox dinámico
            pathsNode.set("bbox", bbox);

            // Agregar coordenadas decodificadas de la ruta
            pathsNode.set("decoded_points", objectMapper.valueToTree(decodedCoordinates));

            // Agregar instrucciones si las tienes
            JsonNode instructionsNode = path.path("instructions"); // Si las instrucciones están en la respuesta
            if (instructionsNode.isArray()) {
                pathsNode.set("instructions", instructionsNode);
            }

            // Añadir paths al JSON principal
            simplifiedResponse.set("paths", objectMapper.createArrayNode().add(pathsNode));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al procesar la respuesta JSON.");
        }

        // Retornar la respuesta como JSON
        return ResponseEntity.ok(simplifiedResponse.toString());
    }

    // Método para decodificar polyline
    public List<List<Double>> decodePolyline(String encodedPolyline) {
        List<List<Double>> coordinates = new ArrayList<>();
        int index = 0;
        int lat = 0;
        int lon = 0;

        while (index < encodedPolyline.length()) {
            // Decodificar latitud
            int shift = 0;
            int result = 0;
            while (true) {
                int b = encodedPolyline.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
                if (b < 0x20) {
                    break;
                }
            }
            lat += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

            // Decodificar longitud
            shift = 0;
            result = 0;
            while (true) {
                int b = encodedPolyline.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
                if (b < 0x20) {
                    break;
                }
            }
            lon += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

            // Añadir coordenadas decodificadas (latitud y longitud) a la lista
            List<Double> point = new ArrayList<>();
            point.add(lat / 1E5); // Convertir a grados (la precisión está en 1e5)
            point.add(lon / 1E5); // Convertir a grados (la precisión está en 1e5)
            coordinates.add(point);
        }

        return coordinates;
    }
}
