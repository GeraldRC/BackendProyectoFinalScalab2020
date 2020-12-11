package com.proyecto.compras.service;

import com.proyecto.compras.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductoService extends ICRUD<Producto>{

    Page<Producto> listarPageable(Pageable pageable);
}
