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

    public Proyectos addProyectos(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }

    public List<Proyectos> buscarProyectos(){
        return proyectosRepo.findAll();
    }

    public Proyectos editarProyectos(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }

    public void borrarProyectos(Long id){
        proyectosRepo.deleteById(id);
    }
}
