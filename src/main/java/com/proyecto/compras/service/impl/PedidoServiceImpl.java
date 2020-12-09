package com.proyecto.compras.service.impl;

import com.proyecto.compras.dto.PedidoListaProductoDTO;
import com.proyecto.compras.model.Pedido;
import com.proyecto.compras.model.Producto;
import com.proyecto.compras.repo.IDetallePedidoRepo;
import com.proyecto.compras.repo.IPedidoRepo;
import com.proyecto.compras.repo.IProductoRepo;
import com.proyecto.compras.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private   IPedidoRepo repo;

    @Autowired
    private  IDetallePedidoRepo repoPedidoProducto;

    @Autowired
    private IProductoRepo repoProducto;

    @Transactional
    @Override
    public Pedido registrarTransaccional(PedidoListaProductoDTO dto) {
        dto.getPedido().getDetallePedidos().forEach(detalle -> detalle.setPedido(dto.getPedido()));
        repo.save(dto.getPedido());

        dto.getProductos().forEach(producto -> {
            repoPedidoProducto.registrar(dto.getPedido().getIdPedido(),producto.getId(), producto.getCantidad());

            Optional<Producto> op = repoProducto.findById(producto.getId());
            op.get().setStock(producto.getCantidad());
            repoProducto.save(op.get());
        });

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
