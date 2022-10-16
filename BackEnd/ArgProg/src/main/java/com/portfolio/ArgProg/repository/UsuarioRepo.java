package com.portfolio.ArgProg.repository;

import com.portfolio.ArgProg.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
}
