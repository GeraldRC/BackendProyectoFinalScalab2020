package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.ResetToken;
import com.proyecto.compras.repo.IResetTokenRepo;
import com.proyecto.compras.service.IResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl  implements IResetTokenService {

    private final IResetTokenRepo repo;

    @Autowired
    public ResetTokenServiceImpl(IResetTokenRepo repo){
        this.repo = repo;
    }

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);
    }

    @Override
    public void eliminar(ResetToken token) {
        repo.save(token);
    }
}
