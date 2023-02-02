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
            SearchDiaDiem.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnDiaDiem.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnLeHoi) {
            SearchKey.result.clear();
            SearchLeHoi.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnLeHoi.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnNhanVat) {
            SearchKey.result.clear();
            SearchNhanVat.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnNhanVat.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnSuKien) {
            SearchKey.result.clear();
            SearchSuKien.search(searchBar.getText().toString());
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnSuKien.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == btnThoiKy) {
            SearchKey.result.clear();
            SearchThoiKy.search(searchBar.getText().toString());
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
//                ItemController item = new ItemController();
//                item.listResult = output;
//                if(SearchKey.result.get(i) instanceof DiTich) {
//                    listResult.clear();
//                    DiaDiem output = (DiaDiem) SearchKey.result.get(i);
//                    ItemController item = new ItemController();
//                            item.listResult = output;
//                }
//                    if(((DiTich) output).getLoai() == null){
//                        listResult.add((DiaDiem) output);
//                        listResult.add(((DiaDiem) output).getDescription());
//                    } else {
//                        listResult.add(((DiTich) output).getTypeModel());
//                        listResult.add(((DiTich) output).getDescription());
//                    }
//                }else if(SearchKey.result.get(i) instanceof Vua) {
//                    listResult.clear();
//                    NhanVat output = (NhanVat) SearchKey.result.get(i);
//                    result = output.getTen();
//                    if(((Vua) output).getTriVi() == null || ((Vua) output).getNienHieu() == null){
//                        listResult.add(((NhanVat) output).getTypeModel());
//                        listResult.add(((NhanVat) output).getDescription());
//                    } else {
//                        listResult.add(((Vua) output).getTypeModel());
//                        listResult.add(((Vua) output).getDescription());
//                    }
//                } else if(SearchKey.result.get(i) instanceof LeHoi){
//                    listResult.clear();
//                    LeHoi output = (LeHoi) SearchKey.result.get(i);
//                    result = output.getTen();
//                    listResult.add(((LeHoi) output).getTypeModel());
//                    listResult.add(((LeHoi) output).getDescription());
//                } else if(SearchKey.result.get(i) instanceof ChienTranh){
//                    listResult.clear();
//                    SuKien output = (SuKien) SearchKey.result.get(i);
//                    result = output.getTen();
//                    if(((ChienTranh) output).getKetQua() == null || ((ChienTranh) output).getDongMinh() == null){
//                        listResult.add(((SuKien) output).getTypeModel());
//                        listResult.add(((SuKien) output).getDescription());
//                    } else {
//                        listResult.add(((ChienTranh) output).getTypeModel());
//                        listResult.add(((ChienTranh) output).getDescription());
//                    }
//                } else if(SearchKey.result.get(i) instanceof ThoiKy){
//                    listResult.clear();
//                    result = ((ThoiKy) SearchKey.result.get(i)).getTen();
//                    listResult.add(((ThoiKy) SearchKey.result.get(i)).getTypeModel());
//                    listResult.add(((ThoiKy) SearchKey.result.get(i)).getDescription());
//                }
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
