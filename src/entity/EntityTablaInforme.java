package entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EntityTablaInforme {
    private SimpleStringProperty codigoPorducto;
    private SimpleStringProperty NombreProducto;
    private SimpleDoubleProperty precioUnitario;
    private SimpleStringProperty cantidad;
    private SimpleDoubleProperty total;

    public EntityTablaInforme(String codigoPorducto, String nombreProducto, double precioUnitario, String cantidad, double total) {
        String str;
        this.codigoPorducto =  new SimpleStringProperty(codigoPorducto);
        NombreProducto = new SimpleStringProperty(nombreProducto);
        this.precioUnitario = new SimpleDoubleProperty(precioUnitario);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.total = new SimpleDoubleProperty(total);
    }


    public String getCodigoPorducto() {
        return codigoPorducto.get();
    }

    public SimpleStringProperty codigoPorductoProperty() {
        return codigoPorducto;
    }

    public void setCodigoPorducto(String codigoPorducto) {
        this.codigoPorducto.set(codigoPorducto);
    }

    public String getNombreProducto() {
        return NombreProducto.get();
    }

    public SimpleStringProperty nombreProductoProperty() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.NombreProducto.set(nombreProducto);
    }

    public double getPrecioUnitario() {
        return precioUnitario.get();
    }

    public SimpleDoubleProperty precioUnitarioProperty() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario.set(precioUnitario);
    }

    public String getCantidad() {
        return cantidad.get();
    }

    public SimpleStringProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad.set(cantidad);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }
}
