package home;


import entity.EntityTabalaPago;
import entity.EntityTablaInforme;
import error.MessageError;
import gestor.*;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import net.sf.jasperreports.engine.JRException;
import reportes.Repor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class Controller implements Initializable {
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
    public TableColumn<EntityTablaInforme, String> codigoPorducto;
    @FXML
    public TableColumn<EntityTablaInforme, String> NombreProducto;
    @FXML
    public TableColumn<EntityTablaInforme, Double> precioUnitario;
    @FXML
    public TableColumn<EntityTablaInforme, Double> total;
    @FXML
    public TableColumn<EntityTablaInforme, String> cantidad;

    public GestorFactura gestorFactura;
    public Trabajador trabajadorGlobal = null;
    public Transaccion trasTransaccionGlobal = null;
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    double subTotal = 0;
    Producto producto = null;
    ArrayList<InformesProducto> informesProductos = new ArrayList<>();
    DecimalFormat formateador;
    ObservableList<EntityTabalaPago> tablaClientes = FXCollections.observableArrayList(

    );
    ObservableList<EntityTablaInforme> tablaProductos = FXCollections.observableArrayList(

    );
    ObservableList<EntityTablaInforme> tablaProductosFactura = FXCollections.observableArrayList(

    );
    ArrayList<InformesProducto> informesProductosFactura = new ArrayList<>();



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
    private Pane pnFactura;
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

    //Tabla informe Producto
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
    private StackPane deskotpPane;
    @FXML
    private AutocompletionlTextField buscarTrabajador;
    @FXML
    private TableView<EntityTablaInforme> tablaInfo;
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
    private AutocompletionlTextField buscarProducto;
    @FXML
    private Button btnGuardarProductoInfo;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TextField subTotalProductos;
    @FXML
    private Button btnOverview1;
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



    //Factura
    @FXML
    private AutocompletionlTextField buscarProducto1;
    @FXML
    private Button btnGuardarFactura;
    @FXML
    private Button btnEliminarFactura;
    @FXML
    private TextField nombreCliente;
    @FXML
    private  TextField direccionCliente;
    @FXML
    private  TextField telefonoCliente;
    @FXML
    private DatePicker fechaFactura;
    @FXML
    private  Label codigoFactura;

    @FXML
    private  TextField subTotalProductos1;



    @FXML
    public TableColumn<EntityTablaInforme, String> codigoPorducto1;
    @FXML
    public TableColumn<EntityTablaInforme, String> NombreProducto1;
    @FXML
    public TableColumn<EntityTablaInforme, Double> precioUnitario1;
    @FXML
    public TableColumn<EntityTablaInforme, Double> total1;
    @FXML
    public TableColumn<EntityTablaInforme, String> cantidad1;

    @FXML
    private TableView<EntityTablaInforme> tablaInfo1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        simbolo.setDecimalSeparator('.');
        formateador = new DecimalFormat("######.##", simbolo);
        loadDatos();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        buscarTrabajador.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(buscarTrabajador.getText());

                if (trabajadorUpdate != null) {
                    txtNacionalidad.setText(trabajadorUpdate.getNacionalidadTra());
                    txtNombre.setText(trabajadorUpdate.getNombreTra());
                    txtApelldio.setText(trabajadorUpdate.getApellidoTra());
                    txtCelular.setText(trabajadorUpdate.getCelularTrabajo());
                    txtDireccion.setText(trabajadorUpdate.getDireccionTra());
                    txtFechaNacimiento.setValue(null);
                    txtFechaEntrada.setValue(null);
                    txtMontoHora.setText(String.valueOf(trabajadorUpdate.getMontoHora()));
                    txtCodigo.setText(trabajadorUpdate.getCodgioTrabajador());

                }


            }
        });
        ingresoHoras.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(ingresoHoras.getText());

                if (trabajadorUpdate != null) {
                    nombreIngreso.setText(trabajadorUpdate.getNombreTra());
                    fechaIngreso.setText(dateFormat.format(Global.getFechaActual()));
                    apellidosIngreso.setText(trabajadorUpdate.getApellidoTra());
                    direccionIngreso.setText(trabajadorUpdate.getDireccionTra());
                    horaIngresoActual.setText(String.valueOf(Global.obtenerhoras(Global.getHoraActual())));
                    minutosIngresoActual.setText(String.valueOf(Global.obtenerMinutos(Global.getHoraActual())));
                    trasTransaccionGlobal = GestorTransaccion.getHoraEntradaOsalida(trabajadorUpdate.getCodigoTra());
                    if (trasTransaccionGlobal != null) {
                        btnSalidaTrabajador.setDisable(false);
                        btnEntradaTrabajador.setDisable(true);

                    } else {
                        btnSalidaTrabajador.setDisable(true);
                        btnEntradaTrabajador.setDisable(false);

                    }
                    trabajadorGlobal = trabajadorUpdate;

                } else {
                    MessageError.error355(root, rootPane, "Error No se encontro nigun trabajador con ese nombre  " + "EEE00527", "Usuario No existe");
                }


            }

        });
        horaPagar.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                int horasExtras = 0;
                int totalhoras = 0;
                Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(horaPagar.getText());
                tablaClientes.removeAll(tablaClientes);
                for (Transaccion recuper : GestorTransaccion.getNombresTrabajadores(trabajadorUpdate.getCodigoTra())) {
                    try {
                        tablaClientes.add(new EntityTabalaPago(dateFormat.format(recuper.getFehca()),
                                recuper.getTrabajador().getCodgioTrabajador()
                                , recuper.getTotalHoras() * recuper.getTrabajador().getMontoHora(), hourFormat.format(recuper.getHoraEntrada())
                                , hourFormat.format(recuper.getHoraSalida()), String.valueOf(recuper.getTotalHoras()),
                                String.valueOf(recuper.getTotalMinutos())));
                        horasExtras = horasExtras + recuper.getTotalMinutos();
                        totalhoras = totalhoras + recuper.getTotalHoras();
                    } catch (NullPointerException ex) {
                        MessageError.error355(root, rootPane, "El Usuario por el momento sigue trabajando  si desea obtner el pago mas el dia de hoy \n" +
                                "  asegurese que el trabajador marque su hora de salida, en caso contrario se acumulara este dia  a su siguente rol de pago  ", "El usuario esta trabajando");
                    }

                }

                totalhoras = totalhoras + (horasExtras / 60);


                MessageError.error355(root, rootPane, "Total de horas trabajadas es:  " + totalhoras, "Bienvenido");


                double respuesta = totalhoras * trabajadorUpdate.getMontoHora();

                totalApagar.setText(String.valueOf(respuesta));

            }
        });
        buscarProducto.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {

                if (GestorProducto.getProducto(buscarProducto.getText()) != null) {
                    producto = GestorProducto.getProducto(buscarProducto.getText());
                    nombreProduCar.setText(producto.getNombreProduc());
                    fechaIngresoCar.setText(dateFormat.format(Global.getFechaActual()));
                    costoUnitarioCar.setText(String.valueOf(producto.getPrecioUnita()));
                } else {
                    loadStage("/home/Productos.fxml");

                }
            }
            buscarProducto.getEntries().addAll(GestorProducto.getNombreProductos());
        });

        buscarProducto1.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {

                if (GestorProducto.getProducto(buscarProducto1.getText()) != null) {
                    Producto p = GestorProducto.getProducto(buscarProducto1.getText())    ;

                    InformesProducto informesProducto = new InformesProducto();
                        try {

                            double precioUni = p.getPrecioUnita();
                            informesProducto.setCodigoInfo(p.getCodigoTra());
                            informesProducto.setCantidadPro(1);
                            informesProducto.setPrecioUnita(precioUni);
                            informesProducto.setFechaInfo(Global.getFechaActual());
                            double total = precioUni * 1;
                            double respuestaTrasformada = Double.parseDouble(formateador.format(total));
                            informesProducto.setTotal(respuestaTrasformada);
                            subTotal = subTotal + respuestaTrasformada;
                            subTotalProductos1.setText(formateador.format(subTotal));
                            informesProducto.setProducto(p);
                            System.out.println("YA" +subTotalProductos+" AA");
                            buscarProducto1.setText("");
                            informesProducto.setNombreProduc(p.getNombreProduc());
                            informesProductosFactura.add(informesProducto);
                            tablaProductosFactura.add(new EntityTablaInforme(String.valueOf(p.getCodigoTra()), p.getNombreProduc(), p.getPrecioUnita(), String.valueOf(informesProducto.getCantidadPro()), respuestaTrasformada));
                            cantidadCar.setText("");

                        } catch (NumberFormatException ex) {
                            MessageError.error355(root, rootPane, "Ingrese numeros en la casilla cantidad   " + "EEE00529", "Formato numero cantidad ");
                        }


                } else {
                    loadStage("/home/Productos.fxml");

                }
            }
            buscarProducto1.getEntries().addAll(GestorProducto.getNombreProductos());
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
        }
        if (actionEvent.getSource() == btnOverview1) {

            pagarHoras();
        }
        if (actionEvent.getSource() == btnSignout) {
            System.exit(0);

        }
        if (actionEvent.getSource() == btnSettings) {
            pnFactura.toFront();
        }
    }


    private void pagarHoras() {

        Trabajador trabajadorUpdate = GestorTrabajador.getCodigo(horaPagar.getText());
        try {
            if (trabajadorUpdate != null) {
                List<Transaccion> trans = GestorTransaccion.getNombresTrabajadores(trabajadorUpdate.getCodigoTra());
                if (trans != null) {
                    for (Transaccion tras : trans) {
                        tras.setEstadoPago(true);
                        GestorGlobal.update(tras);

                    }
                    MessageError.error355(root, rootPane, "Se le a pagado Exitosamente ", "Pago exitoso almacenado en Base ");
                    tablaClientes.removeAll(tablaClientes);
                    horaPagar.setText("");
                } else {
                    MessageError.error355(root, rootPane, "Error no se a encontrado usuario  " + "EEE00531", "El usuari no tiene dinero pendiente ");

                }

            } else {
                MessageError.error355(root, rootPane, "Error no se a encontrado usuario  " + "EEE00532", "El usuari no tiene dinero pendiente ");

            }

        } catch (NullPointerException ex) {
            MessageError.error355(root, rootPane, "El usuario no tiene dinero por pagar  " + "EEE00532", "No encontramos  horas para ser pagadas :( ");

        }

    }

    public void llamada() {
        buscarTrabajador.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        ingresoHoras.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        horaPagar.getEntries().addAll(GestorTrabajador.getNombresTrabajadores());
        buscarProducto.getEntries().addAll(GestorProducto.getNombreProductos());
        buscarProducto1.getEntries().addAll(GestorProducto.getNombreProductos());
    }

    @FXML
    public void cliksTrabajadoresIngreso(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnGuardarTrabajadores) {
            guardarTrabajador();

        }
        if (actionEvent.getSource() == btnDarDeBajaTrabajador) {

        }


    }


    public void cliksTrabajadoresHoras(ActionEvent actionEven) {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        if (actionEven.getSource() == btnEntradaTrabajador) {
            if (trabajadorGlobal != null) {
                Transaccion t = new Transaccion();
                t.setEstadoPago(false);
                t.setFehca(Global.getFechaActual());
                String horaTem =  horaIngresoActual.getText()+":"+minutosIngresoActual.getText()+":00";
                System.out.println(horaTem);
                t.setHoraEntrada(Global.getMyHora(horaTem));
                t.setHoraSalida(null);
                t.setTotalHoras(0);
                t.setTotalMinutos(0);
                t.setTrabajador(trabajadorGlobal);

                System.out.println(t.getFehca() + " " + t.getHoraEntrada());
                GestorGlobal.save(t);
                limpiar();
                MessageError.error355(root, rootPane, "Bienvenido al trabajar   " + trabajadorGlobal.getNombreTra(), "Bienvenido");


            } else {
                MessageError.error355(root, rootPane, "Error No se encontro Usuario  " + "EEE00528", "Usuario en blanco");

            }


        }
        if (actionEven.getSource() == btnSalidaTrabajador) {
            try {
                String horaTem =   horaIngresoActual.getText()+":"+minutosIngresoActual.getText()+":00";
                trasTransaccionGlobal.setHoraSalida(Global.getMyHora(horaTem));

                int horaEntrada = Global.obtenerhoras(trasTransaccionGlobal.getHoraEntrada());
                int horaSalida = Integer.valueOf(horaIngresoActual.getText());
                int respuestaHoras = horaSalida - horaEntrada;

                int minutosEntrada = Global.obtenerMinutos(trasTransaccionGlobal.getHoraEntrada());
                int minutosSalida = Integer.valueOf(minutosIngresoActual.getText());
                int respuestaMinutos = 0;

                if (minutosEntrada > minutosSalida) {
                    respuestaMinutos = (Math.abs((minutosSalida + minutosEntrada) - 60));
                    respuestaHoras = respuestaHoras - 1;

                } else if (minutosSalida  > minutosEntrada){
                    respuestaMinutos = minutosSalida - minutosEntrada;

                }else if (minutosSalida  == minutosEntrada) {
                    respuestaMinutos=0;
                }

                if (respuestaHoras >= 0) {
                    trasTransaccionGlobal.setTotalHoras(respuestaHoras);
                    trasTransaccionGlobal.setTotalMinutos(respuestaMinutos);

                    GestorGlobal.update(trasTransaccionGlobal);

                    MessageError.error355(root, rootPane, "A terminado trabajando Horas:  " + trasTransaccionGlobal.getTotalHoras() + " Minutos: " + trasTransaccionGlobal.getTotalMinutos() + " ", "Bienvenido");
                    limpiar();

                } else {
                    MessageError.error355(root, rootPane, "Este trabajdor perdio sus horas por no marcar    " + trabajadorGlobal.getNombreTra(), "Trabajador no marco");

                }

            }catch (NumberFormatException ex ){
                MessageError.error355(root, rootPane, "Trabajador en nulo   "  , "Trabajador no existio");


            }catch (NullPointerException ex ){
                MessageError.error355(root, rootPane, "Trabajador en nulo   "  , "Trabajador no existio");


            }



        }

    }

    private void guardarTrabajador() {
        if (validarDatos()) {
            try {
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

                try {
                    MessageError.error355(root, rootPane, "Esta seguro que desea almacenar al trabajador \n"
                                    + trabajador.getNombreTra() + " " + trabajador.getApellidoTra() + "\n",
                            "Estas Seguro ?.");

                    GestorGlobal.save(trabajador);
                    limpiar();
                    llamada();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException ex) {
                MessageError.error355(root, rootPane, " Verifique si al ingresar codigo o monto por hora sean numericos "
                                + "EEE00526",
                        "Error valores no numericos");

            }
        } else {
            MessageError.error355(root, rootPane, "Error valores en blanco " + "EEE00525", "Valores nulos");
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
        nombreCliente.setText("");
        direccionCliente.setText("");
        telefonoCliente.setText("");
        fechaFactura.setValue(null);
        subTotalProductos1.setText("");



    }

    private boolean validarDatos() {

        if (!txtNombre.getText().isEmpty() && !txtApelldio.getText().isEmpty() && !txtDireccion.getText().isEmpty()
                && !txtMontoHora.getText().isEmpty() && !txtCelular.getText().isEmpty()
                && !txtNacionalidad.getText().isEmpty() && txtFechaEntrada.getValue() != null
                && txtFechaNacimiento.getValue() != null && !txtCodigo.getText().isEmpty()) {


            return true;
        } else {
            return false;
        }
    }

    private void loadDatos() {
        tablaPago.setEditable(true);
        tablaInfo.setEditable(true);
        tablaInfo1.setEditable(true);
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        horaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        totalHoras.setCellValueFactory(new PropertyValueFactory<>("totalHoras"));
        totalPago.setCellValueFactory(new PropertyValueFactory<>("totalPago"));
        totalMinutos.setCellValueFactory(new PropertyValueFactory<>("totalMinutos"));
        tablaPago.setItems(tablaClientes);

        gestorFactura= new GestorFactura();

        codigoFactura.setText(String.valueOf(gestorFactura.getFacturasCode()));


        fecha.setMinWidth(100);

        fecha.setCellFactory(TextFieldTableCell.forTableColumn());
        fecha.setOnEditCommit(t -> {
                     (  t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setFecha(t.getNewValue());

                     System.out.println(      (  t.getTableView().getItems().get(
                             t.getTablePosition().getRow())
                     ).getCodigo());


        }
        );

        //Tabla Informe Productos
        codigoPorducto.setCellValueFactory(new PropertyValueFactory<>("codigoPorducto"));
        NombreProducto.setCellValueFactory(new PropertyValueFactory<>("NombreProducto"));
        cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        precioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        tablaInfo.setItems(tablaProductos);




        nombreIngreso.setEditable(false);
        fechaIngreso.setEditable(false);
        apellidosIngreso.setEditable(false);
        direccionIngreso.setEditable(false);



        cantidad.setMinWidth(100);

        cantidad.setCellFactory(TextFieldTableCell.forTableColumn());
        cantidad.setOnEditCommit(t -> {
                    (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCantidad(t.getNewValue());

            subTotal = subTotal - (  t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getTotal();

            double total =  (  t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getPrecioUnitario() *  Integer.valueOf((  t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getCantidad());

            double respuestaTrasformada = Double.parseDouble(formateador.format(total));
            (  t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setTotal(respuestaTrasformada);

            subTotal = subTotal + (  t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getTotal();
            int aux=0;
            int i=0;
            for (InformesProducto info :informesProductos){
                if (info.getCodigoInfo() == Integer.valueOf((  t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).getCodigoPorducto())){
                i=aux;

                }
                aux++;
            }
                informesProductos.get(i).setCantidadPro(Integer.valueOf((  t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).getCantidad()));
                informesProductos.get(i).setTotal( (  t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).getTotal() );


            for (InformesProducto info :informesProductos){
                System.out.println(info.getCantidadPro()+" "+ info.getTotal()+" "+info.getNombreProduc() +" ");
            }

            subTotalProductos.setText(formateador.format(subTotal));


                }
        );



        codigoPorducto1.setCellValueFactory(new PropertyValueFactory<>("codigoPorducto"));
        NombreProducto1.setCellValueFactory(new PropertyValueFactory<>("NombreProducto"));
        cantidad1.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        precioUnitario1.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        total1.setCellValueFactory(new PropertyValueFactory<>("total"));
        tablaInfo1.setItems(tablaProductosFactura);




        cantidad1.setMinWidth(100);

        cantidad1.setCellFactory(TextFieldTableCell.forTableColumn());
        cantidad1.setOnEditCommit(t -> {
                    (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCantidad(t.getNewValue());

                    subTotal = subTotal - (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).getTotal();

                    double total =  (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).getPrecioUnitario() *  Integer.valueOf((  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).getCantidad());

                    double respuestaTrasformada = Double.parseDouble(formateador.format(total));
                    (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setTotal(respuestaTrasformada);

                    subTotal = subTotal + (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).getTotal();
                    int aux=0;
                    int i=0;
                    for (InformesProducto info :informesProductosFactura){
                        if (info.getCodigoInfo() == Integer.valueOf((  t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).getCodigoPorducto())){
                            i=aux;

                        }
                        aux++;
                    }
            informesProductosFactura.get(i).setCantidadPro(Integer.valueOf((  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).getCantidad()));
            informesProductosFactura.get(i).setTotal( (  t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).getTotal() );



                    subTotalProductos1.setText(formateador.format(subTotal));


                }
        );
        llamada();


    }


    public void loadStage(String fxml) {
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
    public void cliksIngresoProducCarga(ActionEvent actionEvent) {
        if (actionEvent.getSource() == almacenarVIstaProducto) {

            if (GestorProducto.getProducto(buscarProducto.getText()) != null) {
                InformesProducto informesProducto = new InformesProducto();

                //  System.out.println(df.format(number));

                if (!cantidadCar.getText().isEmpty()) {
                    try {
                        int cantida = Integer.parseInt(cantidadCar.getText());
                        double precioUni = producto.getPrecioUnita();
                        informesProducto.setCodigoInfo(producto.getCodigoTra());
                        informesProducto.setCantidadPro(cantida);
                        informesProducto.setPrecioUnita(precioUni);
                        informesProducto.setFechaInfo(Global.getFechaActual());
                        double total = precioUni * cantida;
                        double respuestaTrasformada = Double.parseDouble(formateador.format(total));
                        informesProducto.setTotal(respuestaTrasformada);

                        subTotal = subTotal + respuestaTrasformada;
                        subTotalProductos.setText(formateador.format(subTotal));
                        informesProducto.setProducto(producto);
                        informesProducto.setNombreProduc(producto.getNombreProduc());
                        informesProductos.add(informesProducto);

                        tablaProductos.add(new EntityTablaInforme(String.valueOf(producto.getCodigoTra()), producto.getNombreProduc(), producto.getPrecioUnita(), String.valueOf(informesProducto.getCantidadPro()), respuestaTrasformada));


                        cantidadCar.setText("");

                    } catch (NumberFormatException ex) {
                        MessageError.error355(root, rootPane, "Ingrese numeros en la casilla cantidad   " + "EEE00529", "Formato numero cantidad ");
                    }
                } else {
                    MessageError.error355(root, rootPane, "Error se encontro en blanco la casiilla cantidad   " + "EEE00530", "Cantidad en blanco");
                }

            } else {
                MessageError.error355(root, rootPane, "Error No se encontro nigun Producto Almacenado en Storage  " + "EEE00528", "Producto No existe");

            }
        }
        if (actionEvent.getSource() == btnEliminarProducto) {

            if (!informesProductos.isEmpty()) {
                InformesProducto info = informesProductos.get(informesProductos.size() - 1);
                subTotal = subTotal - info.getTotal();

                subTotalProductos.setText(formateador.format(subTotal));
                tablaProductos.remove(tablaProductos.size() - 1);
                informesProductos.remove(informesProductos.size() - 1);
                MessageError.error355(root, rootPane, "Eliminacion de productos con exito  ", "Producto eliminado  ");
            } else {
                MessageError.error355(root, rootPane, "NO existe producto almacenado en Storage   ", "Producto no encontrado  ");

            }

        }
        if (actionEvent.getSource() == btnGuardarProductoInfo) {
            for (InformesProducto ifo : informesProductos) {
                GestorGlobal.save(ifo);

            }

            tablaProductos.removeAll(tablaProductos);
            informesProductos.removeAll(informesProductos);
            subTotal = 0;
            subTotalProductos.setText("");
            MessageError.error355(root, rootPane, "Formulario almacenado correctamente  ", "Se almacenado el informe correctamente   ");

        }
        if(actionEvent.getSource() == btnGuardarFactura){

            if (!nombreCliente.getText().isEmpty() && !direccionCliente.getText().isEmpty() &&
                !telefonoCliente.getText().isEmpty()&& fechaFactura.getValue() != null && !subTotalProductos1.getText().isEmpty()){
                FacturaCabecera facturaCabecera = new FacturaCabecera();
                facturaCabecera.setDireccionCliente(direccionCliente.getText());
                facturaCabecera.setTelefonoCliente(telefonoCliente.getText());
                facturaCabecera.setNombreCliente(nombreCliente.getText());
                facturaCabecera.setSubTotal(Double.valueOf(subTotalProductos1.getText()));
                facturaCabecera.setFecha(Global.getFechaFormato(fechaFactura.getValue().toString()));
                facturaCabecera.setIdFactura(Integer.valueOf(codigoFactura.getText()));
                 GestorGlobal.save(facturaCabecera);



                 for (InformesProducto informesProducto : informesProductosFactura){
                     FacturaDetalle facturaDetalle = new FacturaDetalle();
                     facturaDetalle.setCantidad(informesProducto.getCantidadPro());
                     facturaDetalle.setTotal(informesProducto.getTotal());
                     facturaDetalle.setFacturaCabecera(facturaCabecera);
                     facturaDetalle.setProducto( GestorProducto.getProducto(informesProducto.getNombreProduc()));
                     GestorGlobal.save(facturaDetalle);
                 }

                MessageError.error355(root, rootPane, "Asegurese de no olvidarel codigo  ", "Formulario  Alacenado Correctamente ");
               limpiar();
                informesProductosFactura.removeAll(informesProductosFactura);
                tablaProductosFactura.removeAll(tablaProductosFactura);
                codigoFactura.setText(String.valueOf(gestorFactura.getFacturasCode()));
                Repor repor = new Repor();
                try {
                    repor.SimpleReportFacturas(facturaCabecera);
                } catch (JRException e) {
                    e.printStackTrace();
                }


            }else {
                MessageError.error355(root, rootPane, "Asegurese de llenar todos los campos   ", "Formulario  incorrecto   ");

            }


        }


    }
}
