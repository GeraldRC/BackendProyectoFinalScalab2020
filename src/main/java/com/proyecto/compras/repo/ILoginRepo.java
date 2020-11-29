package com.proyecto.compras.repo;

import com.proyecto.compras.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ILoginRepo extends JpaRepository<Usuario,Integer> {

    Usuario findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario us SET us.password = :clave where us.username = :username")
    void cambiarClave(@Param("clave") String clave, @Param("username") String username);

}
