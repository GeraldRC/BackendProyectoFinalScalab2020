package com.proyecto.compras.service;

import com.proyecto.compras.model.ResetToken;

public interface IResetTokenService {

    ResetToken findByToken(String token);
    void guardar(ResetToken token);
    void eliminar(ResetToken token);
}
