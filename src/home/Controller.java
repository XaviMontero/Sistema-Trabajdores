package home;


import entity.EntityTabalaPago;
import error.MessageError;
import gestor.GestorGlobal;
import gestor.GestorTrabajador;
import gestor.GestorTransaccion;
import global.AutocompletionlTextField;
import global.Global;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import model.Trabajador;
import model.Transaccion;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnRegistro;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Pane proFroma;
    @FXML
    private Pane pnIngresoTrabajador;
    @FXML
    private Label nombreTrabajador;
    @FXML
    private TextField txtNombre;
    @FXML
    private DatePicker txtFechaEntrada;
    @FXML
    private TextField txtApelldio;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNacionalidad;
    @FXML
    private DatePicker txtFechaNacimiento;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtCelular;
    @FXML
    private TextField txtMontoHora;
    @FXML
    private Button btnGuardarTrabajadores;
    @FXML
    private Button btnDarDeBajaTrabajador;
    @FXML
    private AnchorPane root;
    @FXML
    private StackPane rootPane;
    @FXML
    private TableView<EntityTabalaPago> tablaPago;
    @FXML
    public TableColumn<EntityTabalaPago, Double> totalPago;
    @FXML
    public TableColumn<EntityTabalaPago, String> totalHoras;
    @FXML
    public TableColumn<EntityTabalaPago, String> fecha;
    @FXML
    public TableColumn<EntityTabalaPago, String> horaEntrada;
    @FXML
    public TableColumn<EntityTabalaPago, String> horaSalida;
    @FXML
    public TableColumn<EntityTabalaPago, String> codigo;
    @FXML
    public TableColumn<EntityTabalaPago, String> totalMinutos;

    @FXML
    private StackPane deskotpPane;
    @FXML
    private AutocompletionlTextField buscarTrabajador;




    //Ingreso de horas
    @FXML
    private AutocompletionlTextField ingresoHoras;
    @FXML
    private TextField nombreIngreso;
    @FXML
    private TextField fechaIngreso;
    @FXML
    private TextField apellidosIngreso;
    @FXML
    private TextField direccionIngreso;
    @FXML
    private TextField horaIngresoActual;
    @FXML
    private TextField minutosIngresoActual;
    @FXML
    private Button btnEntradaTrabajador;
    @FXML
    private Button btnSalidaTrabajador;
    @FXML
    private TextField totalApagar;


    //Hora de pagar
    @FXML
    private AutocompletionlTextField horaPagar;

    public Trabajador trabajadorGlobal=null;
    public  Transaccion trasTransaccionGlobal =null;


    ObservableList<EntityTabalaPago> tablaClientes = FXCollections.observableArrayList(

    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDatos();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss",Locale.US);


        buscarTrabajador.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
               Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(buscarTrabajador.getText());

               if (trabajadorUpdate != null){
                   txtNacionalidad.setText(trabajadorUpdate.getNacionalidadTra());
                   txtNombre.setText(trabajadorUpdate.getNombreTra());
                   txtApelldio.setText(trabajadorUpdate.getApellidoTra());
                   txtCelular.setText(trabajadorUpdate.getCelularTrabajo());
                   txtDireccion.setText(trabajadorUpdate.getDireccionTra());
                   txtFechaNacimiento.setValue(null);
                   txtFechaEntrada.setValue(null);
                   txtMontoHora.setText(String.valueOf(trabajadorUpdate.getMontoHora() ));
                   txtCodigo.setText(trabajadorUpdate.getCodgioTrabajador());

               }



            }
        });


        ingresoHoras.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(ingresoHoras.getText());

                if (trabajadorUpdate != null){
                    nombreIngreso.setText(trabajadorUpdate.getNombreTra());
                    fechaIngreso.setText(dateFormat.format(Global.getFechaActual()));
                    apellidosIngreso.setText(trabajadorUpdate.getApellidoTra());
                    direccionIngreso.setText(trabajadorUpdate.getDireccionTra());
                    horaIngresoActual.setText(String.valueOf(Global.obtenerhoras(Global.getHoraActual())));
                    minutosIngresoActual.setText(String.valueOf(Global.obtenerMinutos(Global.getHoraActual())));
                    trasTransaccionGlobal= GestorTransaccion.getHoraEntradaOsalida(trabajadorUpdate.getCodigoTra());
                    if (trasTransaccionGlobal !=null){
                        btnSalidaTrabajador.setDisable(false);
                        btnEntradaTrabajador.setDisable(true);

                    }else {
                        btnSalidaTrabajador.setDisable(true);
                        btnEntradaTrabajador.setDisable(false);

                    }
                    trabajadorGlobal=trabajadorUpdate;

                }else{
                    MessageError.error355(root,rootPane,"Error No se encontro nigun trabajador con ese nombre  "+ "EEE00527" ,"Usuario No existe");
                }



            }

        });




        horaPagar.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                int horasExtras=0;
                int totalhoras=0;
                Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(horaPagar.getText());
                    for (Transaccion recuper : GestorTransaccion.getNombresTrabajadores(trabajadorUpdate.getCodigoTra())){
                        try {
                            tablaClientes.add(new EntityTabalaPago(  dateFormat.format(recuper.getFehca()),
                                    recuper.getTrabajador().getCodgioTrabajador()
                                    ,recuper.getTotalHoras()*recuper.getTrabajador().getMontoHora(),hourFormat.format(recuper.getHoraEntrada())
                                    ,hourFormat.format(recuper.getHoraSalida()), String.valueOf( recuper.getTotalHoras()),
                                    String.valueOf(recuper.getTotalMinutos())));
                            horasExtras = horasExtras+recuper.getTotalMinutos();
                            totalhoras=totalhoras+recuper.getTotalHoras();
                        }catch (NullPointerException ex){
                            MessageError.error355(root,rootPane,"El Usuario por el momento sigue trabajando  si desea obtner el pago mas el dia de hoy \n" +
                                    "  asegurese que el trabajador marque su hora de salida, en caso contrario se acumulara este dia  a su siguente rol de pago  ","El usuario esta trabajando");
                        }



                    }

                      totalhoras = totalhoras + (horasExtras/60);
                      double respuesta = totalhoras*trabajadorUpdate.getMontoHora();
                      totalApagar.setText(String.valueOf(respuesta));

            }
                });




    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.toFront();

        }

        if (actionEvent.getSource() == btnOrders) {
            pnRegistro.toFront();

        }

        if (actionEvent.getSource() == btnCustomers) {
            proFroma.toFront();

        }
        if (actionEvent.getSource() == btnMenus) {
            pnIngresoTrabajador.toFront();

        }

    }

    @FXML
    public void cliksTrabajadoresIngreso (ActionEvent actionEvent){
          if (actionEvent.getSource() == btnGuardarTrabajadores){
            guardarTrabajador();

        } if (actionEvent.getSource() == btnDarDeBajaTrabajador){

        }


    }
    public void cliksTrabajadoresHoras (ActionEvent actionEven){


        if (actionEven.getSource() == btnEntradaTrabajador){
            if(trabajadorGlobal != null){
                Transaccion t = new Transaccion();
                t.setEstadoPago(false);
                t.setFehca(Global.getFechaActual());
                t.setHoraEntrada(Global.getHoraActual());
                t.setHoraSalida(null);
                t.setTotalHoras(0);
                t.setTotalMinutos(0);
                t.setTrabajador(trabajadorGlobal);

                System.out.println(t.getFehca()+" "+t.getHoraEntrada());
                GestorGlobal.save(t);
                limpiar();
                MessageError.error355(root,rootPane,"Bienvenido al trabajar   "+ trabajadorGlobal.getNombreTra() ,"Bienvenido");


            }else{
                MessageError.error355(root,rootPane,"Error No se encontro Usuario  "+ "EEE00528" ,"Usuario en blanco");

            }


        } if (actionEven.getSource() == btnSalidaTrabajador){

            trasTransaccionGlobal.setHoraSalida(Global.getHoraActual());

            int horaEntrada = Global.obtenerhoras(trasTransaccionGlobal.getHoraEntrada());
            int horaSalida = Global.obtenerhoras(Global.getHoraActual());
            int respuestaHoras = horaSalida-horaEntrada;

            int minutosEntrada = Global.obtenerMinutos(trasTransaccionGlobal.getHoraEntrada());
            int minutosSalida = Global.obtenerMinutos(Global.getHoraActual());
            int respuestaMinutos = 0;

            if(minutosEntrada >= minutosSalida){
                respuestaMinutos = (Math.abs((minutosSalida+minutosEntrada)-60)) ;
                respuestaHoras =respuestaHoras-1;

            }else {
                respuestaMinutos = minutosSalida-minutosEntrada;

            }
            trasTransaccionGlobal.setTotalHoras(respuestaHoras);
            trasTransaccionGlobal.setTotalMinutos(respuestaMinutos);
            GestorGlobal.update(trasTransaccionGlobal);

            MessageError.error355(root,rootPane,"A terminado trabajando Horas:  "+ trasTransaccionGlobal.getTotalHoras()+" Minutos: " +trasTransaccionGlobal.getTotalMinutos() +" ","Bienvenido");
            limpiar();



        }

    }

    private void guardarTrabajador() {
        if (validarDatos()){
            try{
                double montoHora = Double.parseDouble(txtMontoHora.getText());

                Trabajador trabajador = new Trabajador();
                trabajador.setApellidoTra(txtApelldio.getText());
                trabajador.setNombreTra(txtNombre.getText());
                trabajador.setEstadoTrabajador(true);
                trabajador.setCodgioTrabajador(txtCodigo.getText());
                trabajador.setCelularTrabajo(txtCelular.getText());
                trabajador.setDireccionTra(txtDireccion.getText());
                trabajador.setFechaEntradaTra(Global.getFechaFormato(txtFechaEntrada.getValue().toString()));
                trabajador.setMontoHora(montoHora);
                trabajador.setNacionalidadTra(txtNacionalidad.getText());

                try
                {
                    MessageError.error355(root,rootPane,"Esta seguro que desea almacenar al trabajador \n"
                                    + trabajador.getNombreTra()+" "+ trabajador.getApellidoTra() +"\n",
                            "Estas Seguro ?.");

                        GestorGlobal.save(trabajador);
                        limpiar();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }catch (NumberFormatException ex){
                MessageError.error355(root,rootPane," Verifique si al ingresar codigo o monto por hora sean numericos "
                                + "EEE00526" ,
                            "Error valores no numericos");

            }
        }else {
            MessageError.error355(root,rootPane,"Error valores en blanco "+ "EEE00525" ,"Valores nulos");
        }


    }

    private void limpiar() {
              txtNacionalidad.setText("");
              txtNombre.setText("");
              txtApelldio.setText(" ");
              txtCelular.setText("");
              txtDireccion.setText("");
              txtFechaNacimiento.setValue(null);
              txtFechaEntrada.setValue(null);
              txtMontoHora.setText("");
              txtCodigo.setText("");
              nombreIngreso.setText("");
              fechaIngreso.setText("");
              apellidosIngreso.setText("");
              direccionIngreso.setText("");
              horaIngresoActual.setText("");
              minutosIngresoActual.setText("");
              ingresoHoras.setText("");

    }

    private boolean validarDatos() {

        if (!txtNombre.getText().isEmpty() && !txtApelldio.getText().isEmpty() && !txtDireccion.getText().isEmpty()
                && !txtMontoHora.getText().isEmpty()&& !txtCelular.getText().isEmpty() && !txtNombre.getText().isEmpty()
                && !txtNacionalidad.getText().isEmpty() && txtFechaEntrada.getValue() != null
                && txtFechaNacimiento.getValue()!=null && !txtCodigo.getText().isEmpty() ){


            return  true;
        }else {
            return false;
        }
    }

    private void loadDatos() {


        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        horaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        totalHoras.setCellValueFactory(new PropertyValueFactory<>("totalHoras"));
        totalPago.setCellValueFactory(new PropertyValueFactory<>("totalPago"));
        totalMinutos.setCellValueFactory(new PropertyValueFactory<>("totalMinutos"));
        tablaPago.setItems(tablaClientes);
        buscarTrabajador.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        ingresoHoras.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        horaPagar.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        nombreIngreso.setEditable(false);
        fechaIngreso.setEditable(false);
        apellidosIngreso.setEditable(false);
        direccionIngreso.setEditable(false);
        horaIngresoActual.setEditable(false);
        minutosIngresoActual.setEditable(false);




    }
}
