package com.proyecto.compras.repo;

import com.proyecto.compras.model.DetallePedido;
import com.proyecto.compras.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IDetallePedidoRepo extends JpaRepository<DetallePedido,Integer> {

    @Transactional
    @Query(value = "INSERT INTO detalle_pedidos(id_producto, id_pedido, cantidad) VALUES (:idProducto, :idPedido, :cantidad)", nativeQuery = true)
    Integer registrar(@Param("idPedido") Integer idPedido, @Param("idProducto") Integer idProducto,@Param("cantidad") Integer cantidad);


    @Query("from DetallePedido de where de.pedido.idPedido = :idPedido")
    List<DetallePedido> listarProductosPorPedido(@Param("idPedido") Integer idPedido);
}
