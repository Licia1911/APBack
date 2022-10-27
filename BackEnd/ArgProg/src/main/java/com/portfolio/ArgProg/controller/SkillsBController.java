package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.SkillsB;
import com.portfolio.ArgProg.services.SkillsBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillsB")
public class SkillsBController {
    private final SkillsBService skillsBService;

    public SkillsBController(SkillsBService skillsBService) {
        this.skillsBService = skillsBService;
    }

    @GetMapping
    public ResponseEntity<List<SkillsB>> getAllSkillB(){
        List<SkillsB> skillsBL = skillsBService.findAllSkillsB();
        return new ResponseEntity<>(skillsBL, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SkillsB>updateSkillB(@RequestBody SkillsB skillsB){
        SkillsB updateSkillsB = skillsBService.updateSkillB(skillsB);
        return new ResponseEntity<>(updateSkillsB, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillsB>addSkillB(@RequestBody SkillsB skillsB){
        SkillsB nuevaSkillsB = skillsBService.addSkillsB(skillsB);
        return new ResponseEntity<>(nuevaSkillsB, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteSkillB(@PathVariable("id") Long id){
        skillsBService.deleteSkillB(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
