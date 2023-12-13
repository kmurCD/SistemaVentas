package xyz.backend.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.backend.proyecto.modelo.Persona;
import xyz.backend.proyecto.service.PersonaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona/")
public class PersonaController {
    @Autowired
    private PersonaService personaService; // inyeccion de la clase PersonaService
    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersona(){
        return ResponseEntity.ok(personaService.findAll());
    }
    @PostMapping
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){ //RequestBody hace que lo que se esta enviando desde el frond lo convierta a un objeto tipo persona
        try {
            Persona nuevapersona= personaService.save(persona);
            return new ResponseEntity<>(nuevapersona, HttpStatus.CREATED); // crea una instancia dentro de responseEntity, representado la ubicacion de la persona y el body que es el contenido de este
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //Esto indica que solicitud no pudo ser completada ya que hay un error de sintasix ,y build construye y finaliza la respuesta sin establecer un body(contenido)
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Persona> obtenerProducto(@PathVariable("id") Long id) {
        Optional<Persona> personaOptional = personaService.getById(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            return ResponseEntity.ok().body(persona);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("{id}")
    private ResponseEntity<Boolean> eliminarPersona(@PathVariable("id") Long id) {
        personaService.deleteById(id);
        boolean eliminado = personaService.getById(id).isEmpty();
        if (eliminado) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }





}
