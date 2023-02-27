package com.portfolio.ArgProg.services;

import com.portfolio.ArgProg.models.SkillsF;
import com.portfolio.ArgProg.repository.SkillsFRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsFService {

    public final SkillsFRepo skillsFRepo;

    @Autowired
    public SkillsFService(SkillsFRepo skillsFRepo) {
        this.skillsFRepo = skillsFRepo;
    }

    public SkillsF addSkillsF(SkillsF skillsF){
        return skillsFRepo.save(skillsF);
    }

    public List<SkillsF> findAllSkillsF(){
        return skillsFRepo.findAll();
    }

    public SkillsF updateSkillF(SkillsF skillsF){
        return skillsFRepo.save(skillsF);
    }

    public void deleteSkillF(Long id){
        skillsFRepo.deleteById(id);
    }
}
