package app.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.Main;
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
import model.dia_diem.DiaDiem;

public class Page1Controller implements Initializable {
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

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btnSearch) {
            Page2Controller.searchResults = SearchKey.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSearch.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
        if (event.getSource() == btnDiaDiem) {
            Page2Controller.searchResults = SearchMap.searchMap(Main.mapDiaDiem);
            SearchMap.DIA_DIEM = Page2Controller.searchResults;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnDiaDiem.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
        if (event.getSource() == btnLeHoi) {
            Page2Controller.searchResults = SearchMap.searchMap(Main.mapLeHoi);
            SearchMap.NHAN_VAT = Page2Controller.searchResults;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnLeHoi.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
        if (event.getSource() == btnNhanVat) {
            Page2Controller.searchResults = SearchMap.searchMap(Main.mapNhanVat);
            SearchMap.NHAN_VAT = Page2Controller.searchResults;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnNhanVat.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
        if (event.getSource() == btnSuKien) {
            Page2Controller.searchResults = SearchMap.searchMap(Main.mapSuKien);
            SearchMap.SU_KIEN = Page2Controller.searchResults;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSuKien.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
        if (event.getSource() == btnThoiKy) {
            Page2Controller.searchResults = SearchMap.searchMap(Main.mapThoiKy);
            SearchMap.THOI_KY = Page2Controller.searchResults;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnThoiKy.getScene().getWindow();
            window.setScene(new Scene(root, 1800, 850));
            window.setMaximized(true);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}