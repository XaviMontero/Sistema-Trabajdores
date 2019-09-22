package model;

import javax.persistence.*;

@Entity
@Table
public class FacturaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idFacturaDetall;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "codigoTra")
    private Producto producto;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idFactura")
    private FacturaCabecera facturaCabecera;

    @Column
    private int cantidad;

    @Column
    private double total;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Producto producto, FacturaCabecera facturaCabecera, int cantidad, double total) {
        this.producto = producto;
        this.facturaCabecera = facturaCabecera;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getIdFacturaDetall() {
        return idFacturaDetall;
    }

    public void setIdFacturaDetall(int idFacturaDetall) {
        this.idFacturaDetall = idFacturaDetall;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaCabecera getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
