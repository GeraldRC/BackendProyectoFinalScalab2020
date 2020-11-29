package com.proyecto.compras.controller;

import com.proyecto.compras.model.DetallePedido;
import com.proyecto.compras.service.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidoproductos")
public class DetallePedidoController {

    private final IDetallePedidoService service;

    @Autowired
    public DetallePedidoController(IDetallePedidoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<DetallePedido>> listar(@PathVariable("id") Integer idPedido){
        return new ResponseEntity<>(service.listarProductosPorPedido(idPedido), HttpStatus.OK);
    }

}
