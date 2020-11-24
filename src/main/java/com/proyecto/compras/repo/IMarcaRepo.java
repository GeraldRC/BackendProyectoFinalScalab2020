package com.proyecto.compras.repo;

import com.proyecto.compras.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepo extends JpaRepository<Marca,Integer> {
}
