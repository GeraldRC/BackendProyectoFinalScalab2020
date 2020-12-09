package com.proyecto.compras;

import com.proyecto.compras.model.Usuario;
import com.proyecto.compras.repo.IUsuarioRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComprasApplicationTests {

    @Autowired
    private IUsuarioRepo repo;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Test
    void crearUser() {
        Usuario usuario = new Usuario();

        usuario.setId(1);
        usuario.setUsername("gerald.reyes@outlook.cl");
        usuario.setEnabled(true);
        usuario.setPassword(bcrypt.encode("123"));

        Usuario retorno = repo.save(usuario);
        assertTrue(retorno.getPassword().equalsIgnoreCase(usuario.getPassword()));
    }

}
