package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int codigoTra;
    @Column
    private String nombreTra;
    @Column
    private String apellidoTra;
    @Column
    private String direccionTra;
    @Column
    private Date fechaEntradaTra;
    @Column
    private String nacionalidadTra;
    @Column
    private String codgioTrabajador;
    @Column
    private double montoHora;
    @Column
    private String celularTrabajo;
    @Column
    private boolean estadoTrabajador;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaccion> transaccions;

    public Trabajador() {


    }

    public boolean isEstadoTrabajador() {
        return estadoTrabajador;
    }

    public void setEstadoTrabajador(boolean estadoTrabajador) {
        this.estadoTrabajador = estadoTrabajador;
    }

    public List<Transaccion> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(List<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }

    public int getCodigoTra() {
        return codigoTra;
    }

    public void setCodigoTra(int codigoTra) {
        this.codigoTra = codigoTra;
    }

    public String getNombreTra() {
        return nombreTra;
    }

    public void setNombreTra(String nombreTra) {
        this.nombreTra = nombreTra;
    }

    public String getApellidoTra() {
        return apellidoTra;
    }

    public void setApellidoTra(String apellidoTra) {
        this.apellidoTra = apellidoTra;
    }

    public String getDireccionTra() {
        return direccionTra;
    }

    public void setDireccionTra(String direccionTra) {
        this.direccionTra = direccionTra;
    }

    public Date getFechaEntradaTra() {
        return fechaEntradaTra;
    }

    public void setFechaEntradaTra(Date fechaEntradaTra) {
        this.fechaEntradaTra = fechaEntradaTra;
    }

    public String getNacionalidadTra() {
        return nacionalidadTra;
    }

    public void setNacionalidadTra(String nacionalidadTra) {
        this.nacionalidadTra = nacionalidadTra;
    }

    public String getCodgioTrabajador() {
        return codgioTrabajador;
    }

    public void setCodgioTrabajador(String codgioTrabajador) {
        this.codgioTrabajador = codgioTrabajador;
    }

    public double getMontoHora() {
        return montoHora;
    }

    public void setMontoHora(double montoHora) {
        this.montoHora = montoHora;
    }

    public String getCelularTrabajo() {
        return celularTrabajo;
    }

    public void setCelularTrabajo(String celularTrabajo) {
        this.celularTrabajo = celularTrabajo;
    }
}
