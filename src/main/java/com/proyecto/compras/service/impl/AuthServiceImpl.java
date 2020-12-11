package com.proyecto.compras.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    public boolean tieneAccesso(String path){
        boolean res = false;

        String metodoRol = "";

        switch (path){
            case "listar":
                metodoRol = "ADMIN";
                break;
            case "buscarPorId":
                metodoRol = "ADMIN, USER, DBA";
                break;
            case "registrar":
                metodoRol = "ADMIN, DBA";
                break;
            case "modificar":
                metodoRol = "ADMIN, DBA";
                break;
            case "eliminar":
                metodoRol = "ADMIN, DBA";
                break;
        }

        String metodoRoles[] = metodoRol.split(",");

        Authentication usuarioLogeado = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(usuarioLogeado.getName());

        for(GrantedAuthority auth : usuarioLogeado.getAuthorities()){
            String rolUser = auth.getAuthority();

            System.out.println(rolUser);

            for (String rolMet : metodoRoles){
                if (rolUser.equalsIgnoreCase(rolMet)){
                    res = true;
                }
            }
        }
        return res;
    }
}
