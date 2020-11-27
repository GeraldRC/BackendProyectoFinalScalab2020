package com.proyecto.compras.controller;

import com.proyecto.compras.exception.ModelNotFoundException;
import com.proyecto.compras.model.Producto;
import com.proyecto.compras.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IProductoService service;

    @Autowired
    public ProductoController(IProductoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable("id") Integer id){
        Producto producto = service.buscarPorId(id);
        if (producto.getIdProducto() == null){
            throw  new ModelNotFoundException("EL ID "+id+" HA SIDO ENCONTRAO!");
        }
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto producto){
        Producto obj = service.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Producto> modidicar(@Valid @RequestBody Producto producto){
        Producto obj = service.modificar(producto);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Producto producto = service.buscarPorId(id);
        if (producto.getIdProducto() == null){
            throw new ModelNotFoundException("EL ID "+id+" NO HA SIDO ENCONTRADO!");
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
