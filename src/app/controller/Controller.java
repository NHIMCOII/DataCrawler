package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import app.Main;

public class Controller implements Initializable {

    @FXML
    Button btn1, btn2, btnBack;

    @FXML
    private Button btnDiaDiem;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnLeHoi;

    @FXML
    private Button btnThoiKy;

    @FXML
    private Button btnSuKien;

    @FXML
    private Button btnNhanVat;

    @FXML
    private VBox items = new VBox();

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    @FXML
    private VBox description = new VBox();

    public Node[] nodes = new Node[10];

    public void handleBtn(ActionEvent event) throws Exception{
        if(event.getSource() == btnSearch) {
            Main.searchDiaDiem(" ");
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage)btnSearch.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if(event.getSource() == btnBack) {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page1.fxml"));
            Stage window = (Stage)btnBack.getScene().getWindow();
            window.setScene(new Scene(root));

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < Main.output.size(); i++) {
            try {
                ControllerItem.result.add(Main.output.get(i));
                nodes[i] = FXMLLoader.load(getClass().getResource("../view/Item.fxml"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            items.getChildren().add(nodes[i]);
        }
    }
}