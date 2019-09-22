package entity;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class EntityTabalaPago {
    private SimpleStringProperty codigo;
    private SimpleStringProperty fecha;

    private SimpleStringProperty horaEntrada;
    private SimpleStringProperty horaSalida;
    private SimpleStringProperty totalHoras;
    private SimpleStringProperty totalMinutos;
    private SimpleDoubleProperty totalPago;

    public EntityTabalaPago(String fecha, String trasaccion, double totalPago, String horaEntrada, String horaSalida, String totalHoras, String totalMinutos) {
        this.fecha = new SimpleStringProperty(fecha);
        this.codigo = new SimpleStringProperty(trasaccion);
        this.totalPago = new SimpleDoubleProperty(totalPago);
        this.horaEntrada = new SimpleStringProperty(horaEntrada);
        this.horaSalida = new SimpleStringProperty(horaSalida);
        this.totalHoras = new SimpleStringProperty(totalHoras);
        this.totalMinutos = new SimpleStringProperty(totalMinutos);
    }

    public String getTotalMinutos() {
        return totalMinutos.get();
    }

    public void setTotalMinutos(String totalMinutos) {
        this.totalMinutos.set(totalMinutos);
    }

    public SimpleStringProperty totalMinutosProperty() {
        return totalMinutos;
    }

    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public String getHoraEntrada() {
        return horaEntrada.get();
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada.set(horaEntrada);
    }

    public SimpleStringProperty horaEntradaProperty() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida.get();
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida.set(horaSalida);
    }

    public SimpleStringProperty horaSalidaProperty() {
        return horaSalida;
    }

    public String getTotalHoras() {
        return totalHoras.get();
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras.set(totalHoras);
    }

    public SimpleStringProperty totalHorasProperty() {
        return totalHoras;
    }

    public SimpleDoubleProperty totalPagoProperty() {
        return totalPago;
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha = new SimpleStringProperty(fecha);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) {
        this.codigo = new SimpleStringProperty(codigo);
    }

    public double getTotalPago() {
        return totalPago.get();
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = new SimpleDoubleProperty(totalPago);
    }
}
