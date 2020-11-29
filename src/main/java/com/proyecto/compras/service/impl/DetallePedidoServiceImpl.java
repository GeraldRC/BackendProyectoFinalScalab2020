package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.DetallePedido;
import com.proyecto.compras.repo.IDetallePedidoRepo;
import com.proyecto.compras.service.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements IDetallePedidoService {

    private final IDetallePedidoRepo repo;

    @Autowired
    public DetallePedidoServiceImpl(IDetallePedidoRepo repo){
        this.repo = repo;
    }

    @Override
    public List<DetallePedido> listarProductosPorPedido(Integer idPedido) {
        return repo.listarProductosPorPedido(idPedido);
    }
}
