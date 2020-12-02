package com.proyecto.compras.controller;

import com.proyecto.compras.exception.ModelNotFoundException;
import com.proyecto.compras.model.Marca;
import com.proyecto.compras.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private  IMarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> listar(){
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable("id") Integer id){
        Marca marca = service.buscarPorId(id);
        if (marca.getIdMarca() == null){
            throw  new ModelNotFoundException("EL ID "+id+" HA SIDO ENCONTRAO!");
        }
        return new ResponseEntity<>(marca,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Marca> registrar(@Valid @RequestBody Marca marca){
        Marca obj = service.registrar(marca);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getIdMarca()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Marca> modidicar(@Valid @RequestBody Marca marca){
        Marca obj = service.modificar(marca);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Marca marca = service.buscarPorId(id);
        if (marca.getIdMarca() == null){
            throw new ModelNotFoundException("EL ID "+id+" NO HA SIDO ENCONTRADO!");
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
