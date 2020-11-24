package com.proyecto.compras.repo;

import com.proyecto.compras.model.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormaPagoRepo extends JpaRepository<FormaPago,Integer> {
}
