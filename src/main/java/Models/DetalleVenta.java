package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Table(name = "detalleventas")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalle")
    private int idDetalle;

    @Column(name = "idVenta", nullable = false)
    private int idVenta;
@Column(name = "idProducto", nullable = false)
    private int idProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "descuento", nullable = false, precision = 18, scale = 2)
    private BigDecimal descuento;

    // Constructor, getters, and setters

    public DetalleVenta() {
        this.idVenta = 0;
        this.cantidad = 0;
        this.descuento = new BigDecimal(0);
        this.idProducto =0;
    }

    public DetalleVenta(int idVenta, int producto, int cantidad, BigDecimal descuento) {
        this.idVenta = idVenta;
        this.idProducto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalle=" + idDetalle +
                ", idVenta=" + idVenta +
                ", producto=" + idProducto +
                ", cantidad=" + cantidad +
                ", descuento=" + descuento +
                '}';
    }
}