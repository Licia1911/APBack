package com.portfolio.ArgProg.services;

import com.portfolio.ArgProg.models.SkillsB;
import com.portfolio.ArgProg.models.SkillsF;
import com.portfolio.ArgProg.repository.SkillsBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsBService {
    public final SkillsBRepo skillsBRepo;

    @Autowired
    public SkillsBService(SkillsBRepo skillsBRepo) {
        this.skillsBRepo = skillsBRepo;
    }
    public SkillsB addSkillsB(SkillsB skillsB){
        return skillsBRepo.save(skillsB);
    }

    public List<SkillsB> findAllSkillsB(){
        return skillsBRepo.findAll();
    }

    public SkillsB updateSkillB(SkillsB skillsB){
        return skillsBRepo.save(skillsB);
    }

    public void deleteSkillB(Long id){
        skillsBRepo.deleteById(id);
    }
}
