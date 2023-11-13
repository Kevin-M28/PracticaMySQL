package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @Column(name = "idVenta")
    private int idVenta;

    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Column(name = "idCliente", nullable = false)
    private int idCliente;

    public Venta() {
        this.idVenta = 0;
        this.fecha = new Date();
        this.idCliente = 0;
    }

    public Venta(int idVenta, Date fecha, int cliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idCliente = cliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                ", cliente=" +  idCliente+
                '}';
    }

}
