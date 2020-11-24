package com.proyecto.compras.repo;

import com.proyecto.compras.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepo extends JpaRepository<Pedido,Integer> {
}
