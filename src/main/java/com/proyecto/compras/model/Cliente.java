package com.proyecto.compras.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Informacion de clientes")
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @ApiModelProperty(notes = "El rut debe ser unico")
    @Column(name = "rut",unique = true)
    @NotNull
    private String rutCliente;

    @ApiModelProperty(notes = "El nombre debe contener entre 2 y 20 caracteres")
    @Column(name = "nombres")
    @NotNull
    @Size(min = 2, max = 20)
    private String nombres;

    @ApiModelProperty(notes = "El nombre debe contener entre 2 y 30 caracteres")
    @Column(name = "apellidos")
    @NotNull
    @Size(min = 2, max = 30)
    private String apellidos;

    @ApiModelProperty(notes = "El correo debe ser un email valido")
    @Column(name = "correo")
    @NotNull
    @Email
    private String correoCliente;

    @ApiModelProperty(notes = "El telefono debe contener entre 8 y 12 caracteres")
    @Column(name = "telefono")
    @NotNull
    @Size(min = 8, max = 12)
    private String telefono;

    @ApiModelProperty(notes = "La ciudad debe contener entre 5 y 20 caracteres")
    @Column(name = "ciudad")
    @NotNull
    @Size(min = 5, max = 20)
    private String ciudad;

    @ApiModelProperty(notes = "La direccion debe contener entre 5 y 50 caracteres")
    @Column(name = "direccion")
    @NotNull
    @Size(min = 5, max = 50)
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
