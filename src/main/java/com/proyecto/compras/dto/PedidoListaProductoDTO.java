package com.proyecto.compras.dto;

import com.proyecto.compras.model.Pedido;
import com.proyecto.compras.model.Producto;

import java.util.List;

public class PedidoListaProductoDTO {

    private Pedido pedido;

    private List<Producto> productos;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
