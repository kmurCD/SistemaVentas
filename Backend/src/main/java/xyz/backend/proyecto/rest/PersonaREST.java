package xyz.backend.proyecto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.backend.proyecto.modelo.Persona;
import xyz.backend.proyecto.service.PersonaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona/")
public class PersonaREST {
    @Autowired
    private PersonaService personaService; // inyeccion de la clase PersonaService
    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersona(){
        return ResponseEntity.ok(personaService.findAll());
    }
    @PostMapping
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){ //RequestBody hace que lo que se esta enviando desde el frond lo convierta a un objeto tipo persona

        try {
            Persona personaGuardada= personaService.save(persona);
            return  ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada); // crea una instancia dentro de responseEntity, representado la ubicacion de la persona y el body que es el contenido de este
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //Esto indica que solicitud no pudo ser completada ya que hay un error de sintasix ,y build construye y finaliza la respuesta sin establecer un body(contenido)

        }
    }

}
