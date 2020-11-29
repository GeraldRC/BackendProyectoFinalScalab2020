package com.proyecto.compras.service.impl;

import com.proyecto.compras.dto.PedidoListaProductoDTO;
import com.proyecto.compras.model.Pedido;
import com.proyecto.compras.repo.IDetallePedidoRepo;
import com.proyecto.compras.repo.IPedidoRepo;
import com.proyecto.compras.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {


    private final  IPedidoRepo repo;
    private final IDetallePedidoRepo repoPedidoProducto;

    @Autowired
    public PedidoServiceImpl(IPedidoRepo repo, IDetallePedidoRepo repoPedidoProducto){
        this.repo = repo;
        this.repoPedidoProducto = repoPedidoProducto;
    }

    @Transactional
    @Override
    public Pedido registrarTransaccional(PedidoListaProductoDTO dto) {
        dto.getPedido().getDetallePedidos().forEach(detalle -> detalle.setPedido(dto.getPedido()));
        repo.save(dto.getPedido());

        dto.getProductos().forEach(productos -> repoPedidoProducto.registrar(dto.getPedido().getIdPedido(),productos.getId(), productos.getCantidad()));

        return dto.getPedido();
    }

    @Override
    public List<Pedido> listar() {
        return repo.findAll();
    }

    @Override
    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> op = repo.findById(id);
        return op.orElseGet(Pedido::new);
    }

    @Override
    public Pedido registrar(Pedido obj) {
        obj.getDetallePedidos().forEach(pro ->
                pro.setPedido(obj));
        return repo.save(obj);
    }

    @Override
    public Pedido modificar(Pedido obj) {
        return repo.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
