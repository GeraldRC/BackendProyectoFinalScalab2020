package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.PedidoProducto;
import com.proyecto.compras.repo.IPedidoProductoRepo;
import com.proyecto.compras.service.IPedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoServiceImpl implements IPedidoProductoService {

    private final IPedidoProductoRepo repo;

    @Autowired
    public PedidoProductoServiceImpl(IPedidoProductoRepo repo){
        this.repo = repo;
    }

    @Override
    public List<PedidoProducto> listarProductosPorPedido(Integer idPedido) {
        return repo.listarProductosPorPedido(idPedido);
    }
}
