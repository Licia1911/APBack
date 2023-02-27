package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.Educacion;
import com.portfolio.ArgProg.services.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educacion")
public class EducacionController {

    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

    @GetMapping
    public ResponseEntity<List<Educacion>> getAllEducation(){
        List<Educacion> educaciones=educacionService.findAllEducation();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Educacion>updateEducation(@RequestBody Educacion educacion){
        Educacion updateEducacion= educacionService.updateEducation(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Educacion>addEducation(@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionService.addEducation(educacion);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteEducation(@PathVariable("id") Long id){
        educacionService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
