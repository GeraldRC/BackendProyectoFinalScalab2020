package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.Producto;
import com.proyecto.compras.repo.IProductoRepo;
import com.proyecto.compras.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    private IProductoRepo repo;

    @Autowired
    public ProductoServiceImpl(IProductoRepo repo){
        this.repo = repo;
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto buscarPorId(Integer id) {
        Optional<Producto> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Producto();
    }

    @Override
    public Producto registrar(Producto obj) {
        return repo.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return repo.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
