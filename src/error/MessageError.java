package error;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicBoolean;

public class MessageError {
    public static AtomicBoolean ESTADO = new AtomicBoolean(false);

    public static AtomicBoolean error355(AnchorPane root, StackPane rootPane, String mesaje, String titulo) {

        BoxBlur blur = new BoxBlur(3, 3, 3);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text(titulo));
        JFXButton button = new JFXButton("Aceptar");
        JFXButton buttonCancelar = new JFXButton("Cancelar");
        button.getStyleClass().add("button-cancelar");
        buttonCancelar.getStyleClass().add("button-cancelar");
        String style = " -fx-background-color : #05071F;-fx-text-fill : #e7e5e5; ";

        button.setStyle(style);

        JFXDialog dialog = new JFXDialog(rootPane, dialogLayout, JFXDialog.DialogTransition.TOP);

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouse) -> {
            ESTADO.set(true);
            root.setEffect(null);
            dialog.close();

        });
        buttonCancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouse) -> {
            ESTADO.set(false);
            root.setEffect(null);
            dialog.close();

        });


        dialogLayout.setBody(new Text(mesaje));
        dialogLayout.setActions(button, buttonCancelar);


        dialog.show();
        root.setEffect(blur);
        dialog.setOnDialogClosed(jfxDialogEvent -> {
            root.setEffect(null);

        });
        return ESTADO;
    }

}
