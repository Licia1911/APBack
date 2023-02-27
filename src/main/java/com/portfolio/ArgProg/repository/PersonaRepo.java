package com.portfolio.ArgProg.repository;

import com.portfolio.ArgProg.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo extends JpaRepository<Persona, Long> {

}
