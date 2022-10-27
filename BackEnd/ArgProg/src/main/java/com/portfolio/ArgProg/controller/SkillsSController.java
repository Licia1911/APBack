package com.portfolio.ArgProg.controller;

import com.portfolio.ArgProg.models.SkillsS;
import com.portfolio.ArgProg.services.SkillsSService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillsS")
public class SkillsSController {

    private final SkillsSService skillsSService;

    public SkillsSController(SkillsSService skillsSService) {
        this.skillsSService = skillsSService;
    }

    @GetMapping
    public ResponseEntity<List<SkillsS>> getAllSkillS(){
        List<SkillsS> skillsSL = skillsSService.findAllSkillsS();
        return new ResponseEntity<>(skillsSL, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SkillsS>updateSkillS(@RequestBody SkillsS skillsS){
        SkillsS updateSkillsS = skillsSService.updateSkillS(skillsS);
        return new ResponseEntity<>(updateSkillsS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillsS>addSkillS(@RequestBody SkillsS skillsS){
        SkillsS nuevaSkillsS = skillsSService.addSkillsS(skillsS);
        return new ResponseEntity<>(nuevaSkillsS, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteSkillS(@PathVariable("id") Long id){
        skillsSService.deleteSkillS(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
