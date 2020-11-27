package com.proyecto.compras.service;

import com.proyecto.compras.model.PedidoProducto;

import java.util.List;

public interface IPedidoProductoService {

    List<PedidoProducto> listarProductosPorPedido(Integer idPedido);
}
