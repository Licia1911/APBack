package com.portfolio.ArgProg.services;

import com.portfolio.ArgProg.models.Proyectos;
import com.portfolio.ArgProg.repository.ProyectosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProyectosService {

    public final ProyectosRepo proyectosRepo;

    @Autowired
    public ProyectosService(ProyectosRepo proyectosRepo) {
        this.proyectosRepo = proyectosRepo;
    }

    public Proyectos addProject(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }

    public List<Proyectos> findAllProjects(){
        return proyectosRepo.findAll();
    }

    public Proyectos updateProject(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }

    public void deleteProject(Long id){
        proyectosRepo.deleteById(id);
    }
}
