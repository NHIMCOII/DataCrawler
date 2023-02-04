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
import javafx.stage.Stage;
import model.diadiem.DiSan;
import model.diadiem.DiTich;
import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import model.sukien.ChienTranh;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Page2Controller implements Initializable {

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
    public Node[] nodes = new Node[SearchKey.result.size()];
    public static String result = "";
    public static Object output = new Object();

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btnSearch) {
            SearchKey.result.clear();
            SearchKey.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSearch.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnDiaDiem) {
            SearchKey.result.clear();
            SearchMap.searchDiaDiem();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnDiaDiem.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnLeHoi) {
            SearchKey.result.clear();
            SearchMap.searchLeHoi();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnLeHoi.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnNhanVat) {
            SearchKey.result.clear();
            SearchMap.searchNhanVat();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnNhanVat.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnSuKien) {
            SearchKey.result.clear();
            SearchMap.searchSuKien();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSuKien.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnThoiKy) {
            SearchKey.result.clear();
            SearchMap.searchThoiKy();
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnThoiKy.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnBack) {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page1.fxml"));
            Stage window = (Stage) btnBack.getScene().getWindow();
            window.setScene(new Scene(root));
            SearchKey.result.clear();
        }
    }

    public void search() {
        for (int i = 0; i < nodes.length; i++) {
            try {
                output = SearchKey.result.get(i);
                nodes[i] = FXMLLoader.load(getClass().getResource("../view/Item.fxml"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            items.getChildren().add(nodes[i]);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        search();
    }
}
