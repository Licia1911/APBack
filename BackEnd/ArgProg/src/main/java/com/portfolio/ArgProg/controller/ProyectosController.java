package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.Proyectos;
import com.portfolio.ArgProg.services.ProyectosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {

    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }

    @GetMapping
    public ResponseEntity<List<Proyectos>> getAllProject(){
        List<Proyectos> proyectos=proyectosService.findAllProjects();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Proyectos>updateProject(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos= proyectosService.updateProject(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proyectos>addProject(@RequestBody Proyectos proyectos){
        Proyectos nuevoProyecto=proyectosService.addProject(proyectos);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteProject(@PathVariable("id") Long id){
        proyectosService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
