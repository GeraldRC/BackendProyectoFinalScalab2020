package com.proyecto.compras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_pedidos")
@IdClass(DetallePedidoPK.class)
public class DetallePedido {

    @JsonIgnore
    @Id
    private Pedido pedido;

    @Id
    private Producto producto;

    @Column(name = "cantidad")
    @NotNull
    private Integer cantidad;

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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}