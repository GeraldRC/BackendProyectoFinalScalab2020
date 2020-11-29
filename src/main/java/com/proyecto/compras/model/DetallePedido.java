package com.proyecto.compras.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_pedidos")
@IdClass(DetallePedidoPK.class)
public class DetallePedido {

    @Id
    private Pedido pedido;

    @Id
    private Producto producto;

    @Column(name = "cantidad")
    @NotNull
    private Integer cantidad;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
