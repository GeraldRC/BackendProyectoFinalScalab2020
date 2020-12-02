package com.proyecto.compras;

import com.proyecto.compras.model.Usuario;
import com.proyecto.compras.repo.ILoginRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComprasApplicationTests {

    @Autowired
    private ILoginRepo repo;

    @Test
    void buscarUsuario() {
        Usuario usuario = repo.findByUsername("geraldRC");
        assertTrue(usuario.getUsername().equalsIgnoreCase("geraldRC"));
    }

}
