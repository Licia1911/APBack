package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.Proyectos;
import com.portfolio.ArgProg.services.ProyectosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {

    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> obtenerProyecto(){
        List<Proyectos> proyectos=proyectosService.buscarProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Proyectos>editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos= proyectosService.editarProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Proyectos>crearProyectos(@RequestBody Proyectos proyectos){
        Proyectos nuevoProyecto=proyectosService.addProyectos(proyectos);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>borrarProyecto(@PathVariable("id") Long id){
        proyectosService.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
