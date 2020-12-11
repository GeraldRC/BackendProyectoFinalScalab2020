package com.proyecto.compras.controller;

import com.proyecto.compras.exception.ModelNotFoundException;
import com.proyecto.compras.model.TipoEntrega;
import com.proyecto.compras.service.ITipoEntregaService;
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
@RequestMapping("/tipoentregas")
public class TipoEntregaController {

    @Autowired
    private  ITipoEntregaService service;

    @GetMapping
    public ResponseEntity<List<TipoEntrega>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoEntrega> buscarPorId(@PathVariable("id") Integer id){
        TipoEntrega tipoEntrega = service.buscarPorId(id);
        if (tipoEntrega.getIdEntrega() == null){
            throw  new ModelNotFoundException("EL ID "+id+" HA SIDO ENCONTRAO!");
        }
        return new ResponseEntity<>(tipoEntrega,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoEntrega> registrar(@Valid @RequestBody TipoEntrega tipoEntrega){
        TipoEntrega obj = service.registrar(tipoEntrega);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getIdEntrega()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<TipoEntrega> modidicar(@Valid @RequestBody TipoEntrega tipoEntrega){
        TipoEntrega obj = service.modificar(tipoEntrega);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        TipoEntrega tipoEntrega = service.buscarPorId(id);
        if (tipoEntrega.getIdEntrega() == null){
            throw new ModelNotFoundException("EL ID "+id+" NO HA SIDO ENCONTRADO!");
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
