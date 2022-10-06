package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.Skills;
import com.portfolio.ArgProg.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {

    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skills>> obtenerSkills(){
        List<Skills> skillsL=skillsService.buscarSkills();
        return new ResponseEntity<>(skillsL, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skills>editarSkills(@RequestBody Skills skills){
        Skills updateSkills= skillsService.editarSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skills>crearSkills(@RequestBody Skills skills){
        Skills nuevaSkills=skillsService.addSkills(skills);
        return new ResponseEntity<>(nuevaSkills, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>borrarSkills(@PathVariable("id") Long id){
        skillsService.borrarSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
