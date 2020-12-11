package com.proyecto.compras.controller;

import com.proyecto.compras.exception.ModelNotFoundException;
import com.proyecto.compras.model.FormaPago;
import com.proyecto.compras.service.IFormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/formaspagos")
public class FormaPagoController {

    @Autowired
    private  IFormaPagoService service;

    @PreAuthorize("hasAuthority('USER') or ('ADMIN') or ('DBA')")
    @GetMapping
    public ResponseEntity<List<FormaPago>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER') or ('ADMIN') or ('DBA')")
    @GetMapping("/{id}")
    public ResponseEntity<FormaPago> buscarPorId(@PathVariable("id") Integer id){
        FormaPago formaPago = service.buscarPorId(id);
        if (formaPago.getId() == null){
            throw  new ModelNotFoundException("ID '"+id+"' NO ENCONTRADO! ");
        }
        return new ResponseEntity<>(formaPago,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
    @PostMapping
    public ResponseEntity<FormaPago> registrar(@Valid @RequestBody FormaPago formaPago){
        FormaPago obj = service.registrar(formaPago);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
    @PutMapping
    public ResponseEntity<FormaPago> modificar(@Valid @RequestBody FormaPago formaPago){
        FormaPago obj = service.modificar(formaPago);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        FormaPago formaPago = service.buscarPorId(id);
        if (formaPago.getId() == null){
            throw new ModelNotFoundException("ID '"+id+"' NO ENCONTRADO! ");
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
