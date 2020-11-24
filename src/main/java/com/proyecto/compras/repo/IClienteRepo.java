package com.proyecto.compras.repo;

import com.proyecto.compras.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente,Integer> {
}
