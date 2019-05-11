package controller;

import error.MessageError;
import gestor.GestorGlobal;
import global.Global;
import home.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.Producto;


import java.net.URL;
import java.util.ResourceBundle;

public class ControllerProducto implements Initializable {
    @FXML
    private TextField busquedaProducto;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtprecio;
    @FXML
    private TextField txtFecha;
    @FXML
    private Button btnGuardarProduc;
    @FXML
    private Button btnDarDeBajaProduc;
    @FXML
    private AnchorPane root;
    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void cliksProductos(ActionEvent actionEvent){
        if(actionEvent.getSource()==btnGuardarProduc){

        if(!txtNombre.getText().isEmpty()&&!txtprecio.getText().isEmpty()&& !txtFecha.getText().isEmpty()){
            try{
                Producto p = new Producto();
                double precioUni =Double.parseDouble(txtprecio.getText());
                p.setPrecioUnita(precioUni);
                p.setNombreProduc(txtNombre.getText());
                p.setFechaProdu(txtFecha.getText());

                GestorGlobal.save(p);
                MessageError.error355(root,rootPane,"Producto Guardado Con exito   "  ,"Producto Alacenado");
                limpiar();
              //  Controller.llamada();


            }catch (NumberFormatException ex){

                MessageError.error355(root,rootPane,"Error asegurece que el precio sea numeros   "  ,"Error Numerico ");

            }

        }else {
            MessageError.error355(root,rootPane,"Cajas de texto estan en blanco   "  ,"Error Blanco  ");

        }

        }else if (actionEvent.getSource()==btnDarDeBajaProduc){

        }

    }

    private void limpiar() {
        txtNombre.setText("");
        txtprecio.setText("");
        txtFecha.setText("");
    }
}
