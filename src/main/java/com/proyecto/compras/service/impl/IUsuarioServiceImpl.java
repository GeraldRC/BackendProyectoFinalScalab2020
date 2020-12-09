package com.proyecto.compras.service.impl;

import com.proyecto.compras.model.Usuario;
import com.proyecto.compras.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IUsuarioServiceImpl implements UserDetailsService {


    @Autowired
    private  IUsuarioRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepo.findOneByUsername(username);

        if (username == null){
            throw new UsernameNotFoundException("Usuario no existe");
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        return new User(usuario.getUsername(), usuario.getPassword(), roles);

    }
}
