package app.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerItem implements Initializable{

    @FXML
    private VBox description = new VBox();
    public static ArrayList<Object> result = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//		description.getChildren().add( new Text(result.get(0).toString()));
        description.getChildren().add( new Text(result.get(1).toString()));
        description.setStyle("-fx-padding: 30; -fx-font-size: 14pt");
    }
}
