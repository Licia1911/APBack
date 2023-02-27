package com.portfolio.ArgProg.services;

import com.portfolio.ArgProg.models.SkillsB;
import com.portfolio.ArgProg.models.SkillsS;
import com.portfolio.ArgProg.repository.SkillsSRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsSService {
    public final SkillsSRepo skillsSRepo;

    public SkillsSService(SkillsSRepo skillsSRepo) {
        this.skillsSRepo = skillsSRepo;
    }

    public SkillsS addSkillsS(SkillsS skillsS){
        return skillsSRepo.save(skillsS);
    }

    public List<SkillsS> findAllSkillsS(){
        return skillsSRepo.findAll();
    }

    public SkillsS updateSkillS(SkillsS skillsS){
        return skillsSRepo.save(skillsS);
    }

    public void deleteSkillS(Long id){
        skillsSRepo.deleteById(id);
    }
}
