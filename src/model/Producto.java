package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private  int codigoTra;
    @Column
    private  String nombreProduc;
    @Column
    private  double precioUnita;
    @Column
    private  String fechaProdu;


    @OneToMany(fetch = FetchType.LAZY)
    private List<InformesProducto> informesProductos;

    public Producto() {
    }

    public int getCodigoTra() {
        return codigoTra;
    }

    public void setCodigoTra(int codigoTra) {
        this.codigoTra = codigoTra;
    }

    public String getNombreProduc() {
        return nombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        this.nombreProduc = nombreProduc;
    }

    public double getPrecioUnita() {
        return precioUnita;
    }

    public void setPrecioUnita(double precioUnita) {
        this.precioUnita = precioUnita;
    }

    public String getFechaProdu() {
        return fechaProdu;
    }

    public void setFechaProdu(String fechaProdu) {
        this.fechaProdu = fechaProdu;
    }

    public List<InformesProducto> getInformesProductos() {
        return informesProductos;
    }

    public void setInformesProductos(List<InformesProducto> informesProductos) {
        this.informesProductos = informesProductos;
    }
}
