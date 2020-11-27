package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.Cliente;
import com.proyecto.compras.repo.IClienteRepo;
import com.proyecto.compras.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl  implements IClienteService {

    private IClienteRepo repo;

    @Autowired
    public ClienteServiceImpl(IClienteRepo repo){
        this.repo = repo;

    }

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Cliente();
    }

    @Override
    public Cliente registrar(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public Cliente modificar(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
