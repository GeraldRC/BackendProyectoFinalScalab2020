package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.Marca;
import com.proyecto.compras.repo.IMarcaRepo;
import com.proyecto.compras.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements IMarcaService {

    private IMarcaRepo repo;

    @Autowired
    public MarcaServiceImpl(IMarcaRepo repo){
        this.repo = repo;
    }

    @Override
    public List<Marca> listar() {
        return repo.findAll();
    }

    @Override
    public Marca buscarPorId(Integer id) {
        Optional<Marca> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Marca();
    }

    @Override
    public Marca registrar(Marca obj) {
        return repo.save(obj);
    }

    @Override
    public Marca modificar(Marca obj) {
        return repo.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
