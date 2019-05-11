package controller;

import gestor.GestorGlobal;
import gestor.GestorProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import net.sf.jasperreports.engine.JRException;
import reportes.Repor;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerReportes implements Initializable {
    @FXML
    private DatePicker iniHorario;
    @FXML
    private DatePicker finHorario;
    @FXML
    private DatePicker iniProInicio;
    @FXML
    private DatePicker finProfin;

    @FXML
    private Button btnReHorario;

    @FXML
    private Button btnReProforma;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void cliksReporte(ActionEvent actionEvent){
        if (actionEvent.getSource()== btnReProforma){

             try {
                Date inicio = dateFormat.parse(iniProInicio.getValue().toString());
                Date fin = dateFormat.parse(finProfin.getValue().toString());
                 System.out.println(iniProInicio.getValue()+" "+ finProfin.getValue().toString() );

                 double total = GestorProducto.getTotalProforma(iniProInicio.getValue().toString() ,finProfin.getValue().toString());

                System.out.println(total);
                 Repor.SimpleReport(inicio,fin,total);

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (JRException e) {
                 e.printStackTrace();
             }

        }     if (actionEvent.getSource()== btnReHorario){
            try {
                Date inicio = dateFormat.parse(iniHorario.getValue().toString());
                Date fin = dateFormat.parse(finHorario.getValue().toString());

                Repor.SimpleReportHoras(inicio,fin);

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (JRException e) {
                e.printStackTrace();
            }

        }

    }
}
