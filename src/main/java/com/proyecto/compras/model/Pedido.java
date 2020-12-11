package com.proyecto.compras.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_pedido_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_forma_pago", foreignKey = @ForeignKey(name = "FK_pedido_pago"))
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name = "id_entrega", foreignKey = @ForeignKey(name = "FK_pedido_entrega"))
    private TipoEntrega tipoEntrega;

    @Column(name = "direccion_opcional")
    @Size(max = 50)
    private String dirOpcional;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "pedido", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<DetallePedido> detallePedidos;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDirOpcional() {
        return dirOpcional;
    }

    public void setDirOpcional(String dirOpcional) {
        this.dirOpcional = dirOpcional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public TipoEntrega getEntrega() {
        return tipoEntrega;
    }

    public void setEntrega(TipoEntrega entrega) {
        this.tipoEntrega = entrega;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido);
    }
}