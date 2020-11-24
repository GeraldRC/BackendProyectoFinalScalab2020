package com.proyecto.compras.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "formas_pagos")
public class FormaPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "forma_pago")
    @NotNull
    @Size(max = 30)
    private String formaPago;


    public Integer getId() {
        return id;
    }

    public void setId(Integer idFormaPago) {
        this.id = idFormaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
}
