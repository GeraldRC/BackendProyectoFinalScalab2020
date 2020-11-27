package com.proyecto.compras.service;

import com.proyecto.compras.dto.PedidoListaProductoDTO;
import com.proyecto.compras.model.Pedido;

public interface IPedidoService extends ICRUD<Pedido>{

    Pedido registrarTransaccional(PedidoListaProductoDTO dto);
}
