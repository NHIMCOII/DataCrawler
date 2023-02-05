package app.controller;

import app.Main;
import app.search.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Page2Controller implements Initializable {

    public static String result = "";
    public static Object output = new Object();
    public static ArrayList<Object> searchResults = new ArrayList<>();
    public Text number;
    public Node[] nodes = new Node[searchResults.size()];
    @FXML
    private Button btnDiaDiem;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnLeHoi;
    @FXML
    private Button btnThoiKy;
    @FXML
    private TextField searchBar;
    @FXML
    private Button btnSuKien;
    @FXML
    private Button btnNhanVat;
    @FXML
    private VBox items = new VBox();
    @FXML
    private VBox description = new VBox();

    public void handleBtn(ActionEvent event) throws Exception {
//        if (event.getSource() == btnSearch) {
//            SearchKey.result.clear();
//            SearchKey.search(searchBar.getText().toString());
//            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
//            Stage window = (Stage) btnSearch.getScene().getWindow();
//            window.setScene(new Scene(root));
//
//        }
        if (event.getSource() == btnDiaDiem) {
            if (SearchMap.DIA_DIEM == null) {
                SearchMap.DIA_DIEM = SearchMap.searchMap(Main.mapDiaDiem);
            }
            searchResults = SearchMap.DIA_DIEM;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnDiaDiem.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnLeHoi) {
            if (SearchMap.LE_HOI == null) {
                SearchMap.LE_HOI = SearchMap.searchMap(Main.mapLeHoi);
            }
            searchResults = SearchMap.LE_HOI;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnLeHoi.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnNhanVat) {
            if (SearchMap.NHAN_VAT == null) {
                SearchMap.NHAN_VAT = SearchMap.searchMap(Main.mapNhanVat);
            }
            searchResults = SearchMap.NHAN_VAT;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnNhanVat.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnSuKien) {
            if (SearchMap.SU_KIEN == null) {
                SearchMap.SU_KIEN = SearchMap.searchMap(Main.mapSuKien);
            }
            searchResults = SearchMap.SU_KIEN;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSuKien.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnThoiKy) {
            if (SearchMap.THOI_KY == null) {
                SearchMap.THOI_KY = SearchMap.searchMap(Main.mapThoiKy);
            }
            searchResults = SearchMap.THOI_KY;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnThoiKy.getScene().getWindow();
            window.setScene(new Scene(root));

        }
//        if (event.getSource() == btnBack) {
//            Parent root = FXMLLoader.load(getClass().getResource("../view/Page1.fxml"));
//            Stage window = (Stage) btnBack.getScene().getWindow();
//            window.setScene(new Scene(root));
////            SearchKey.result.clear();
//        }
    }

    public void search(ArrayList<Object> results) {
        for (int i = 0; i < nodes.length; i++) {
            try {
                output = results.get(i);
                nodes[i] = FXMLLoader.load(getClass().getResource("../view/Item.fxml"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            items.getChildren().add(nodes[i]);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        number.setText(String.valueOf(searchResults.size()));
        search(searchResults);
    }
}
