package com.proyecto.compras.service;

import com.proyecto.compras.model.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {

    List<DetallePedido> listarProductosPorPedido(Integer idPedido);
}
