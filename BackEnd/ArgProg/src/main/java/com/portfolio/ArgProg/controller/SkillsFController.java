package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.SkillsF;
import com.portfolio.ArgProg.services.SkillsFService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillsF")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsFController {

    private final SkillsFService skillsFService;

    public SkillsFController(SkillsFService skillsFService) {
        this.skillsFService = skillsFService;
    }

    @GetMapping
    public ResponseEntity<List<SkillsF>> getAllSkillF(){
        List<SkillsF> skillsFL = skillsFService.findAllSkillsF();
        return new ResponseEntity<>(skillsFL, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SkillsF>updateSkillF(@RequestBody SkillsF skillsF){
        SkillsF updateSkillsF = skillsFService.updateSkillF(skillsF);
        return new ResponseEntity<>(updateSkillsF, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillsF>addSkillF(@RequestBody SkillsF skillsF){
        SkillsF nuevaSkillsF = skillsFService.addSkillsF(skillsF);
        return new ResponseEntity<>(nuevaSkillsF, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteSkillF(@PathVariable("id") Long id){
        skillsFService.deleteSkillF(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
