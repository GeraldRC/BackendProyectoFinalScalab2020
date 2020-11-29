package com.proyecto.compras.service;

import com.proyecto.compras.model.Usuario;

public interface ILoginService {

    Usuario verificarUsername(String username);
    int cambiarClave(String clave, String username);
}
