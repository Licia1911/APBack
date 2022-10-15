package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.Persona;
import com.portfolio.ArgProg.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona>getPersonaById(@PathVariable("id") Long id){
        Persona persona=personaService.findPersonaById(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Persona>updatePersona(@RequestBody Persona persona){
        Persona updatePersona= personaService.updatePersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }
}
