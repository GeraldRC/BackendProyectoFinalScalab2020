package com.proyecto.compras.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "rut",unique = true)
    @NotNull
    private String rutCliente;

    @Column(name = "nombres")
    @NotNull
    @Size(min = 2, max = 20)
    private String nombres;

    @Column(name = "apellidos")
    @NotNull
    @Size(min = 2, max = 30)
    private String apellidos;

    @Column(name = "correo")
    @NotNull
    @Email
    private String correoCliente;

    @Column(name = "telefono")
    @NotNull
    @Size(min = 8, max = 12)
    private String telefono;

    @Column(name = "ciudad")
    @NotNull
    @Size(max = 20)
    private String ciudad;

    @Column(name = "direccion")
    @NotNull
    @Size(max = 50)
    private String direccion;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombreCliente) {
        this.nombres = nombreCliente;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
