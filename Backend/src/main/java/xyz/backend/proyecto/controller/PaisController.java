package xyz.backend.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.backend.proyecto.modelo.Pais;
import xyz.backend.proyecto.service.PaisService;

import java.util.List;

@RestController
@RequestMapping("/pais/")
public class PaisController {
    @Autowired
    private PaisService paisService ;

    @GetMapping
    private ResponseEntity<List<Pais>> getAllPais(){
        return ResponseEntity.ok(paisService.findAll());
    }
}
