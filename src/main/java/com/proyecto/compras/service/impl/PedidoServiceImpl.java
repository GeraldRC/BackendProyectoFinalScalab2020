package com.proyecto.compras.service.impl;

import com.proyecto.compras.dto.PedidoListaProductoDTO;
import com.proyecto.compras.model.Pedido;
import com.proyecto.compras.service.IPedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements IPedidoService {



    @Override
    public Pedido registrarTransaccional(PedidoListaProductoDTO dto) {
        return null;
    }

    @Override
    public List<Pedido> listar() {
        return null;
    }

    @Override
    public Pedido buscarPorId(Integer id) {
        return null;
    }

    @Override
    public Pedido registrar(Pedido obj) {
        return null;
    }

    @Override
    public Pedido modificar(Pedido obj) {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }
}
