package com.proyecto.compras.repo;

import com.proyecto.compras.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends JpaRepository<Producto,Integer> {
}
