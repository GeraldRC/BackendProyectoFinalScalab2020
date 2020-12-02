package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.Usuario;
import com.proyecto.compras.repo.ILoginRepo;
import com.proyecto.compras.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private  ILoginRepo repo;

    @Override
    public Usuario verificarUsername(String username) {
        Usuario us = null;

        try {
            us = repo.findByUsername(username);
        }catch (Exception e){
            us = new Usuario();
        }

        return us;
    }

    @Override
    public int cambiarClave(String clave, String username) {
        int res = 0;

        try{
            repo.cambiarClave(clave, username);
            res = 1;
        }catch (Exception e){
            res = 0;
        }

        return res;
    }
}
