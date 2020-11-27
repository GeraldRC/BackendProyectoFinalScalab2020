package com.proyecto.compras.repo;

import com.proyecto.compras.model.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IPedidoProductoRepo  extends JpaRepository<PedidoProducto,Integer> {

    @Transactional
    @Query(value = "INSERT INTO pedidos_productos(id_producto, id_pedido, cantidad) VALUES (:idProducto, :idPedido, :cantidad)", nativeQuery = true)
    Integer registrar(@Param("idPedido") Integer idPedido, @Param("idProducto") Integer idProducto,@Param("cantidad") Integer cantidad);

    @Query("from PedidoProducto ce where ce.pedido = :idPedido")
    List<PedidoProducto> listarProductosPorPedido(@Param("idPedido") Integer idPedido);
}
