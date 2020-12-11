package com.proyecto.compras.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "Informacion de productos")
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @ApiModelProperty(notes = "El nombre del producto debe contener entre 2 y 50 caracteres")
    @Column(name = "nombre_producto")
    @NotEmpty
    @Size(min = 2, max = 50)
    private String nombreProducto;

    @ApiModelProperty(notes = "El stock se debe ser un dato obligatorio")
    @Column(name = "stock_producto")
    @NotNull
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_marca" , foreignKey = @ForeignKey(name = "FK_producto_marca"))
    private Marca marca;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setearStock(int cantidad){
        this.setStock(stock - cantidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(idProducto, producto.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }
}
