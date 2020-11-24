package com.proyecto.compras.repo;

import com.proyecto.compras.model.TipoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEntregaRepo extends JpaRepository<TipoEntrega,Integer> {
}
