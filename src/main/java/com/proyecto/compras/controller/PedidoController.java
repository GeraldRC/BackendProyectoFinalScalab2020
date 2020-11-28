package com.proyecto.compras.controller;

import com.proyecto.compras.dto.PedidoListaProductoDTO;
import com.proyecto.compras.exception.ModelNotFoundException;
import com.proyecto.compras.model.Pedido;
import com.proyecto.compras.service.IPedidoProductoService;
import com.proyecto.compras.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @Autowired
    private IPedidoProductoService servicePedidoProducto;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorid(@PathVariable("id") Integer id){
        Pedido pedido = service.buscarPorId(id);
        if (pedido.getIdPedido() == null){
            throw  new ModelNotFoundException("EL ID "+id+" NO HA SIDO ENCONTRADO");
        }
        return new ResponseEntity<>(pedido,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> registrar(@Valid @RequestBody PedidoListaProductoDTO dto){
        Pedido obj = service.registrarTransaccional(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPedido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping()
    public ResponseEntity<Pedido> modificar(@Valid @RequestBody Pedido pedido){
        Pedido obj = service.modificar(pedido);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Pedido pedido = service.buscarPorId(id);
        if (pedido.getIdPedido() == null){
            throw new ModelNotFoundException("EL ID "+id+" NO HA SIDO ENCONTRADO!");
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
