package model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int codigoTransaccion;
    @Column
    private Date fehca;
    @Column
    private Date horaEntrada;
    @Column
    private Date horaSalida;
    @Column
    private int totalHoras;
    @Column
    private int totalMinutos;
    @Column
    private boolean estadoPago;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "codigoTra")
    private Trabajador trabajador;

    public Transaccion() {
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public Date getFehca() {
        return fehca;
    }

    public void setFehca(Date fehca) {
        this.fehca = fehca;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public int getTotalMinutos() {
        return totalMinutos;
    }

    public void setTotalMinutos(int totalMinutos) {
        this.totalMinutos = totalMinutos;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "codigoTransaccion=" + codigoTransaccion +
                ", fehca=" + fehca +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", totalHoras=" + totalHoras +
                ", totalMinutos=" + totalMinutos +
                ", estadoPago=" + estadoPago +
                ", trabajador=" + trabajador +
                '}';
    }
}
