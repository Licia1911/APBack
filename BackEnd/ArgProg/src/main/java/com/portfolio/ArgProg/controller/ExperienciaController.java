package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.Experiencia;
import com.portfolio.ArgProg.services.ExperienciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    public final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping
    public ResponseEntity<List<Experiencia>> getAllExperience(){
        List<Experiencia> experiencias=experienciaService.findAllExperience();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Experiencia>updateExperience(@RequestBody Experiencia experiencia){
        Experiencia updateExperiencia= experienciaService.updateExperience(experiencia);
        return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Experiencia> addExperience(@RequestBody Experiencia experiencia){
        Experiencia newExperiencia=experienciaService.addExperience(experiencia);
        return new ResponseEntity<>(newExperiencia, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteExperience(@PathVariable("id") Long id){
        experienciaService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
