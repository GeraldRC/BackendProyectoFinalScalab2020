package com.proyecto.compras.service;

import com.proyecto.compras.dto.PedidoListaProductoDTO;
import com.proyecto.compras.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPedidoService extends ICRUD<Pedido>{

    Pedido registrarTransaccional(PedidoListaProductoDTO dto);
    Page<Pedido> listarPageable(Pageable pageable);
}
