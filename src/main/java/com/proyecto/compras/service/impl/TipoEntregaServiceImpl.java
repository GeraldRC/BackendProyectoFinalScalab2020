package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.TipoEntrega;
import com.proyecto.compras.repo.IClienteRepo;
import com.proyecto.compras.repo.ITipoEntregaRepo;
import com.proyecto.compras.service.ITipoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEntregaServiceImpl implements ITipoEntregaService {

    private ITipoEntregaRepo repo;

    @Autowired
    public TipoEntregaServiceImpl(ITipoEntregaRepo repo){
        this.repo = repo;
    }

    @Override
    public List<TipoEntrega> listar() {
        return repo.findAll();
    }

    @Override
    public TipoEntrega buscarPorId(Integer id) {
        Optional<TipoEntrega> op = repo.findById(id);
        return op.isPresent() ? op.get() : new TipoEntrega();
    }

    @Override
    public TipoEntrega registrar(TipoEntrega obj) {
        return repo.save(obj);
    }

    @Override
    public TipoEntrega modificar(TipoEntrega obj) {
        return repo.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
