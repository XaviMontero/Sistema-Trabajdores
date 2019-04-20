package home;

import entity.EntityTabalaPago;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
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
    private StackPane deskotpPane;

    ObservableList<EntityTabalaPago> tablaClientes = FXCollections.observableArrayList(

    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadDatos();
     tablaClientes.add(new EntityTabalaPago( "13-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "14-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "15-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "16-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "17-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "18-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "19-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "20-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "21-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "22-12-2019", "01",20.2,"07:00","15:00","8"));
        tablaClientes.add(new EntityTabalaPago( "23-12-2019", "01",20.2,"07:00","15:00","8"));
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

    private void loadDatos() {


        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        horaEntrada.setCellValueFactory(new PropertyValueFactory<>("horaEntrada"));
        horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        totalHoras.setCellValueFactory(new PropertyValueFactory<>("totalHoras"));
        totalPago.setCellValueFactory(new PropertyValueFactory<>("totalPago"));
        tablaPago.setItems(tablaClientes);
    }
}
