package com.portfolio.ArgProg;

import com.portfolio.ArgProg.models.Usuario;
import com.portfolio.ArgProg.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {
    @Autowired
    UsuarioRepo usuarioRepo;

    @Test
    public void testCreateUsuario(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "123456";
        String encodePassword = passwordEncoder.encode(rawPassword);
        Usuario newUsuario = new Usuario("licia123@gmail.com", encodePassword);
        Usuario savedUsuario = usuarioRepo.save(newUsuario);
        assertThat(savedUsuario).isNotNull();
        assertThat(savedUsuario.getId()).isGreaterThan(0);
    }
}
