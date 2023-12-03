package xyz.backend.proyecto.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.backend.proyecto.modelo.Ciudad;
import xyz.backend.proyecto.service.CiudadService;

import java.util.List;

@RestController
@RequestMapping("/ciudad/")
public class CiudadREST {
    @Autowired
    private CiudadService ciudadService;
    @GetMapping("{id}")
    private ResponseEntity<List<Ciudad>> getAllCiudadesByPais(@PathVariable("id") int idPais){
        return ResponseEntity.ok(ciudadService.findAllByPais((long) idPais));
    }
}
