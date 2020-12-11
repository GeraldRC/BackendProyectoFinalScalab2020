package com.proyecto.compras.controller;

import com.proyecto.compras.exception.ModelNotFoundException;
import com.proyecto.compras.model.Cliente;
import com.proyecto.compras.model.Pedido;
import com.proyecto.compras.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private  IClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
       return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Integer id){
        Cliente cliente = service.buscarPorId(id);
        if (cliente.getIdCliente() == null){
            throw  new ModelNotFoundException("ID NO ENCONTRADO "+id);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Cliente>> listarPageable(Pageable pageable) {
        Page<Cliente> clientes = service.listarPageable(pageable);
        return new ResponseEntity<Page<Cliente>>(clientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente){
        Cliente obj = service.registrar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente){
        Cliente obj = service.modificar(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Cliente obj = service.buscarPorId(id);
        if (obj.getIdCliente() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO! " +id );
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
