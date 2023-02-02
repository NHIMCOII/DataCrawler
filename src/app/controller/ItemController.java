package app.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.Main;
import app.search.SearchKey;
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
import model.diadiem.DiTich;
import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import model.sukien.ChienTranh;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;
import util.Tool;

public class ItemController implements Initializable {

    @FXML
    private VBox description = new VBox();
    @FXML
    private Button btn;
    public Object listResult = new Object();

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btn) {
            Main.detail = listResult;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
            Stage window = (Stage) btn.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        listResult = Page2Controller.output;
        if (listResult instanceof DiTich) {
            if (((DiTich) listResult).getLoai() == null) {
                description.getChildren().add(new Text(((DiTich) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiTich) listResult).getTypeModel() + "\n\nDescription: "));
                description.getChildren().add(new Text(((DiTich) listResult).getDescription()));
                btn.setId("DiTich");
            } else {
                description.getChildren().add(new Text(((DiaDiem) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiaDiem) listResult).getTypeModel() + "\n\nDescription: "));
                description.getChildren().add(new Text(((DiaDiem) listResult).getDescription()));
                btn.setId("DiaDiem");
            }
        } else if (listResult instanceof Vua) {
            if (((Vua) listResult).getTriVi() == null || ((Vua) listResult).getNienHieu() == null) {
                description.getChildren().add(new Text(((Vua) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((Vua) listResult).getTypeModel() + "\n\nDescription: "));
                description.getChildren().add(new Text(((Vua) listResult).getDescription()));
            } else {
                description.getChildren().add(new Text(((NhanVat) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((NhanVat) listResult).getTypeModel() + "\n\nDescription: "));
                description.getChildren().add(new Text(((NhanVat) listResult).getDescription()));
            }
        } else if (listResult instanceof LeHoi) {
            description.getChildren().add(new Text(((LeHoi) listResult).getTen()));
            description.getChildren().add(new Text("Type: " + ((LeHoi) listResult).getTypeModel() + "\n\nDescription: "));
            description.getChildren().add(new Text(((LeHoi) listResult).getDescription()));
        } else if (listResult instanceof ChienTranh) {
            if (((ChienTranh) listResult).getKetQua() == null || ((ChienTranh) listResult).getDongMinh() == null) {
                description.getChildren().add(new Text(((ChienTranh) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((ChienTranh) listResult).getTypeModel() + "\n\nDescription: "));
                description.getChildren().add(new Text(((ChienTranh) listResult).getDescription()));
            } else {
                description.getChildren().add(new Text(((SuKien) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((SuKien) listResult).getTypeModel() + "\n\nDescription: "));
                description.getChildren().add(new Text(((SuKien) listResult).getDescription()));
            }
        } else if (listResult instanceof ThoiKy) {
            description.getChildren().add(new Text(((ThoiKy) listResult).getTen()));
            description.getChildren().add(new Text("Type: " + ((ThoiKy) listResult).getTypeModel() + "\n\nDescription: "));
            description.getChildren().add(new Text(((ThoiKy) listResult).getDescription()));
        }
//        description.getChildren().
//
//                add(new Text(Page2Controller.result + "\n" + "Tag: " + listResult + "\n\n" + "Description:"));

//        if (list != null)
//            description.getChildren().
//
//                    add(new Text(list));
        description.setStyle("-fx-padding: 30; -fx-font-size: 14pt");
//        btn.setId(NormalizeTool.normalizeKey(Page2Controller.listResult.get(0)).replace(' ', '_'));
    }
}
