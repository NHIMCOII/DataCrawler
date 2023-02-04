package app.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.search.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Page1Controller implements Initializable {

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
    private TextField searchBar;

    protected static ArrayList<Object> kq = new ArrayList<>();

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btnSearch) {
            SearchKey.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSearch.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnDiaDiem) {
            SearchMap.searchDiaDiem();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnDiaDiem.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnLeHoi) {
            SearchMap.searchLeHoi();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnLeHoi.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnNhanVat) {
            SearchMap.searchNhanVat();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnNhanVat.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnSuKien) {
            SearchMap.searchSuKien();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSuKien.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnThoiKy) {
            SearchMap.searchThoiKy();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnThoiKy.getScene().getWindow();
            window.setScene(new Scene(root));

        }
    }

    public void initialize(URL location, ResourceBundle resources) {


    }
}