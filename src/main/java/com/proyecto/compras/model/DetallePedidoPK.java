package com.proyecto.compras.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetallePedidoPK implements Serializable {


	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	private  Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_producto",nullable = false)
	private Producto producto;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DetallePedidoPK that = (DetallePedidoPK) o;
		return Objects.equals(pedido, that.pedido) && Objects.equals(producto, that.producto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, producto);
	}
}