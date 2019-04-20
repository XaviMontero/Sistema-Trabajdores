package entity;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class EntityTabalaPago {
    private SimpleStringProperty codigo;
    private SimpleStringProperty fecha;

    private SimpleStringProperty horaEntrada;
    private SimpleStringProperty horaSalida;
    private SimpleStringProperty totalHoras;

    private SimpleDoubleProperty totalPago;

    public EntityTabalaPago(String fecha, String trasaccion, double totalPago, String horaEntrada, String horaSalida, String totalHoras) {
        this.fecha = new SimpleStringProperty(fecha);
        this.codigo =new SimpleStringProperty(trasaccion) ;
        this.totalPago = new SimpleDoubleProperty(totalPago);
        this.horaEntrada=new SimpleStringProperty(horaEntrada);
        this.horaSalida=new SimpleStringProperty(horaSalida);
        this.totalHoras= new SimpleStringProperty(totalHoras);

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

    public SimpleStringProperty horaEntradaProperty() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada.set(horaEntrada);
    }

    public String getHoraSalida() {
        return horaSalida.get();
    }

    public SimpleStringProperty horaSalidaProperty() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida.set(horaSalida);
    }

    public String getTotalHoras() {
        return totalHoras.get();
    }

    public SimpleStringProperty totalHorasProperty() {
        return totalHoras;
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras.set(totalHoras);
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
