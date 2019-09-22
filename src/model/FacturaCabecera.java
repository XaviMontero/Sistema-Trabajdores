package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class FacturaCabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idFactura;
    @Column
    private  String nombreCliente;
    @Column
    private  String direccionCliente;
    @Column
    private  String telefonoCliente;
    @Column
    private Date fecha;
    @Column
    private double subTotal;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FacturaCabecera() {
    }

    public FacturaCabecera(String nombreCliente, String direccionCliente, String telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
