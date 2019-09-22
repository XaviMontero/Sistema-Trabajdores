package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class InformesProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int codigoInfo;
    @Column
    private String nombreProduc;
    @Column
    private int cantidadPro;

    @Column
    private double precioUnita;
    @Column
    private double total;

    @Column
    private Date fechaInfo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "codigoTra")
    private Producto producto;

    public int getCodigoInfo() {
        return codigoInfo;
    }

    public void setCodigoInfo(int codigoInfo) {
        this.codigoInfo = codigoInfo;
    }

    public String getNombreProduc() {
        return nombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        this.nombreProduc = nombreProduc;
    }

    public int getCantidadPro() {
        return cantidadPro;
    }

    public void setCantidadPro(int cantidadPro) {
        this.cantidadPro = cantidadPro;
    }

    public double getPrecioUnita() {
        return precioUnita;
    }

    public void setPrecioUnita(double precioUnita) {
        this.precioUnita = precioUnita;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaInfo() {
        return fechaInfo;
    }

    public void setFechaInfo(Date fechaInfo) {
        this.fechaInfo = fechaInfo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
