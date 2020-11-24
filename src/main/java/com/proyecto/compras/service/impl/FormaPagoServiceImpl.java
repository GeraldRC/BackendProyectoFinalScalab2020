package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.FormaPago;
import com.proyecto.compras.repo.IFormaPagoRepo;
import com.proyecto.compras.service.IFormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoServiceImpl implements IFormaPagoService {

    private IFormaPagoRepo repo;

    @Autowired
    public FormaPagoServiceImpl(IFormaPagoRepo repo){
        this.repo = repo;
    }

    @Override
    public List<FormaPago> listar() {
        return repo.findAll();
    }

    @Override
    public FormaPago buscarPorId(Integer id) {
        Optional<FormaPago> op = repo.findById(id);
        return op.isPresent() ? op.get() : new FormaPago();
    }

    @Override
    public FormaPago registrar(FormaPago obj) {
        return repo.save(obj);
    }

    @Override
    public FormaPago modificar(FormaPago obj) {
        return repo.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
