package com.proyecto.compras.service;

import java.util.List;

public interface ICRUD<T> {

    List<T> listar();
    T buscarPorId(Integer id);
    T registrar(T obj);
    T modificar(T obj);
    boolean eliminar(Integer id);
}
