package com.portfolio.ArgProg.services;

import com.portfolio.ArgProg.exception.UserNotFoundException;
import com.portfolio.ArgProg.models.Persona;
import com.portfolio.ArgProg.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaService {

    public final PersonaRepo personaRepo;

    @Autowired
    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    public Persona addPersona(Persona persona){
        return personaRepo.save(persona);
    }

    public List<Persona> buscarPersona(){
        return personaRepo.findAll();
    }

    public Persona updatePersona(Persona persona){
        return personaRepo.save(persona);
    }

    public Persona findPersonaById(Long id){
        return personaRepo.findById(id).orElseThrow(()->new UserNotFoundException("Persona no encontrada"));
    }
}
