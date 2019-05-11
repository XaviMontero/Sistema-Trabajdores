package home;


import entity.EntityTabalaPago;
import entity.EntityTablaInforme;
import error.MessageError;
import gestor.GestorGlobal;
import gestor.GestorProducto;
import gestor.GestorTrabajador;
import gestor.GestorTransaccion;
import global.AutocompletionlTextField;
import global.Global;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.InformesProducto;
import model.Producto;
import model.Trabajador;
import model.Transaccion;

import javax.persistence.Entity;
import java.io.IOException;
import java.net.URL;
import java.text.*;
import java.util.*;


public class Controller implements Initializable {
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();


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
    private  AutocompletionlTextField buscarTrabajador;

    //Tabla informe Producto


    @FXML
    private TableView<EntityTablaInforme> tablaInfo;
    @FXML
    public TableColumn<EntityTablaInforme, String> codigoPorducto;
    @FXML
    public TableColumn<EntityTablaInforme, String> NombreProducto;
    @FXML
    public TableColumn<EntityTablaInforme, Double> precioUnitario;
    @FXML
    public TableColumn<EntityTablaInforme, Double> total;
    @FXML
    public TableColumn<EntityTablaInforme, String> cantidad;
    @FXML
    private Button almacenarVIstaProducto;
    @FXML
    private TextField nombreProduCar;
    @FXML
    private TextField costoUnitarioCar;
    @FXML
    private TextField fechaIngresoCar;
    @FXML
    private TextField cantidadCar;
    @FXML
    private  AutocompletionlTextField buscarProducto;
    @FXML
    private Button btnGuardarProductoInfo;
    @FXML
    private Button btnEliminarProducto;

    double subTotal=0;
    @FXML
    private TextField subTotalProductos;
    @FXML
    private Button btnOverview1;


    //Ingreso de horas
    @FXML
    private  AutocompletionlTextField ingresoHoras;
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




    Producto producto = null;
    ArrayList <InformesProducto> informesProductos = new ArrayList<>();
    DecimalFormat formateador;
    //Hora de pagar
    @FXML
    private  AutocompletionlTextField horaPagar;

    public Trabajador trabajadorGlobal=null;
    public  Transaccion trasTransaccionGlobal =null;


    ObservableList<EntityTabalaPago> tablaClientes = FXCollections.observableArrayList(

    );
    ObservableList<EntityTablaInforme> tablaProductos = FXCollections.observableArrayList(

    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        simbolo.setDecimalSeparator('.');
         formateador = new DecimalFormat("######.##",simbolo);
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
                tablaClientes.removeAll(tablaClientes);
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

                        if(totalhoras > 40){
                            totalhoras=40;
                        }
                MessageError.error355(root,rootPane,"Total de horas trabajadas es:  " +totalhoras ,"Bienvenido");


                double respuesta = totalhoras*trabajadorUpdate.getMontoHora();

                      totalApagar.setText(String.valueOf(respuesta));

            }
                });
        buscarProducto.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){

                if(GestorProducto.getProducto(buscarProducto.getText())!=null){
                    producto = GestorProducto.getProducto(buscarProducto.getText());
                    nombreProduCar.setText(producto.getNombreProduc());
                    fechaIngresoCar.setText(dateFormat.format(Global.getFechaActual()));
                    costoUnitarioCar.setText(String.valueOf(producto.getPrecioUnita()));
                }else {
                    loadStage("/home/Productos.fxml");

                }
            }
            buscarProducto.getEntries().addAll(GestorProducto.getNombreProductos());
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
        if (actionEvent.getSource() == btnPackages) {
            loadStage("/home/Reportes.fxml");
        }if (actionEvent.getSource() == btnOverview1) {

            pagarHoras();
        }

    }

    private void pagarHoras() {

            Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(horaPagar.getText());
        try{
            if (trabajadorUpdate !=null){
              List <Transaccion> trans= GestorTransaccion.getNombresTrabajadores(trabajadorUpdate.getCodigoTra());
                    if(trans!=null){
                        for (Transaccion tras : trans){
                            tras.setEstadoPago(true);
                            GestorGlobal.update(tras);

                        }
                        MessageError.error355(root,rootPane,"Se le a pagado Exitosamente "  ,"Pago exitoso almacenado en Base ");
                        tablaClientes.removeAll(tablaClientes);
                        horaPagar.setText("");
                    }else {
                        MessageError.error355(root,rootPane,"Error no se a encontrado usuario  "+ "EEE00531" ,"El usuari no tiene dinero pendiente ");

                    }

                    }else {
                       MessageError.error355(root,rootPane,"Error no se a encontrado usuario  "+ "EEE00532" ,"El usuari no tiene dinero pendiente ");

            }

        }catch ( NullPointerException ex){
            MessageError.error355(root,rootPane,"El usuario no tiene dinero por pagar  "+ "EEE00532" ,"No encontramos  horas para ser pagadas :( ");

        }

    }

    public  void llamada(){
   buscarTrabajador.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        ingresoHoras.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        horaPagar.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        buscarProducto.getEntries().addAll(GestorProducto.getNombreProductos());
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
                    llamada();

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

        //Tabla Informe Productos
        codigoPorducto.setCellValueFactory(new PropertyValueFactory<>("codigoPorducto"));
        NombreProducto.setCellValueFactory(new PropertyValueFactory<>("NombreProducto"));
        cantidad.setCellValueFactory(new PropertyValueFactory<EntityTablaInforme,String>("cantidad"));
        precioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        tablaInfo.setItems(tablaProductos);

        nombreIngreso.setEditable(false);
        fechaIngreso.setEditable(false);
        apellidosIngreso.setEditable(false);
        direccionIngreso.setEditable(false);
        horaIngresoActual.setEditable(false);
        minutosIngresoActual.setEditable(false);

        llamada();



    }


    public  void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("/images/logo.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void cliksIngresoProducCarga (ActionEvent actionEvent){
        if (actionEvent.getSource() == almacenarVIstaProducto){

            if(GestorProducto.getProducto(buscarProducto.getText())!=null){
              InformesProducto informesProducto = new InformesProducto();

              //  System.out.println(df.format(number));

                  if (!cantidadCar.getText().isEmpty()){
                      try{
                   int cantida =    Integer.parseInt(cantidadCar.getText());
                    double precioUni =producto.getPrecioUnita();

                   informesProducto.setCantidadPro(cantida);
                   informesProducto.setPrecioUnita(precioUni );
                   informesProducto.setFechaInfo(Global.getFechaActual());
                   double total =  precioUni* cantida;
                   double respuestaTrasformada = Double.parseDouble(formateador.format(total));
                   informesProducto.setTotal(respuestaTrasformada);

                    subTotal = subTotal +respuestaTrasformada;
                    subTotalProductos.setText(formateador.format(subTotal));
                    informesProducto.setProducto(producto);
                    informesProducto.setNombreProduc(producto.getNombreProduc());
                   informesProductos.add(informesProducto);
                   tablaProductos.add(new EntityTablaInforme(String.valueOf(producto.getCodigoTra()),producto.getNombreProduc(),producto.getPrecioUnita(),String.valueOf(informesProducto.getCantidadPro()),respuestaTrasformada));
                          cantidadCar.setText("");

                      }catch (NumberFormatException ex){
                          MessageError.error355(root,rootPane,"Ingrese numeros en la casilla cantidad   "+ "EEE00529" ,"Formato numero cantidad ");
                      }
                  }else{
                      MessageError.error355(root,rootPane,"Error se encontro en blanco la casiilla cantidad   "+ "EEE00530" ,"Cantidad en blanco");
                  }

            }else {
                MessageError.error355(root,rootPane,"Error No se encontro nigun Producto Almacenado en Storage  "+ "EEE00528" ,"Producto No existe");

            }
        }if (actionEvent.getSource()==btnEliminarProducto ){

            if(!informesProductos.isEmpty()){
                InformesProducto info = informesProductos.get(informesProductos.size()-1);
                subTotal =subTotal-info.getTotal();

                subTotalProductos.setText(formateador.format(subTotal));
                tablaProductos.remove(tablaProductos.size()-1);
                informesProductos.remove(informesProductos.size()-1);
                MessageError.error355(root,rootPane,"Eliminacion de productos con exito  " ,"Producto eliminado  ");
            }else {
                MessageError.error355(root,rootPane,"NO existe producto almacenado en Storage   " ,"Producto no encontrado  ");

            }

        }if (actionEvent.getSource()== btnGuardarProductoInfo){
            for (InformesProducto ifo :informesProductos){
                GestorGlobal.save(ifo);

            }

            tablaProductos.removeAll(tablaProductos);
            informesProductos.removeAll(informesProductos);
            subTotal=0;
            subTotalProductos.setText("");
            MessageError.error355(root,rootPane,"Formulario almacenado correctamente  " ,"Se almacenado el informe correctamente   ");

        }
    }
}
