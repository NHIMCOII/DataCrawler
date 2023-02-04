package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
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
import model.dia_diem.DiTich;
import model.dia_diem.DiaDiem;
import model.le_hoi.LeHoi;
import model.nhan_vat.NhanVat;
import model.nhan_vat.Vua;
import model.su_kien.ChienTranh;
import model.su_kien.SuKien;
import model.thoi_ky.ThoiKy;

public class ItemController implements Initializable {

    @FXML
    private VBox description = new VBox();
    @FXML
    private Button btn;
    public Object listResult = new Object();
    Text text = new Text();

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
            if (((DiTich) listResult).getLoai() != null) {
                description.getChildren().add(new Text(((DiTich) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiTich) listResult).getTypeModel() + "\n\nDescription: "));
                text = new Text(((DiTich) listResult).getDescriptionDiTich());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((DiaDiem) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiaDiem) listResult).getTypeModel() + "\n\nDescription: "));
                text = new Text(((DiaDiem) listResult).getDescriptionDiaDiem());
                description.getChildren().add(text);
            }
        } else if (listResult instanceof Vua) {
            if (((Vua) listResult).getTriVi() != null) {
                description.getChildren().add(new Text(((Vua) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((Vua) listResult).getTypeModel() + "\n\nDescription: "));
                text = new Text(((Vua) listResult).getDescriptionVua());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((NhanVat) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((NhanVat) listResult).getTypeModel() + "\n\nDescription: "));
                text = new Text(((NhanVat) listResult).getDescriptionNhanvat());
                description.getChildren().add(text);
            }
        } else if (listResult instanceof LeHoi) {
            description.getChildren().add(new Text(((LeHoi) listResult).getTen()));
            description.getChildren().add(new Text("Type: " + ((LeHoi) listResult).getTypeModel() + "\n\nDescription: "));
            text = new Text(((LeHoi) listResult).getDescriptionLeHoi());
            description.getChildren().add(text);
        } else if (listResult instanceof ChienTranh) {
            if (((ChienTranh) listResult).getKetQua() != null || ((ChienTranh) listResult).getDongMinh() != null) {
                description.getChildren().add(new Text(((ChienTranh) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((ChienTranh) listResult).getTypeModel() + "\n\nDescription: "));
                text = new Text(((ChienTranh) listResult).getDescriptionChienTranh());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((SuKien) listResult).getTen()));
                description.getChildren().add(new Text("Type: " + ((SuKien) listResult).getTypeModel() + "\n\nDescription: "));
                text = new Text(((SuKien) listResult).getDescriptionSuKien());
                description.getChildren().add(text);
            }
        } else if (listResult instanceof ThoiKy) {
            description.getChildren().add(new Text(((ThoiKy) listResult).getTen()));
            description.getChildren().add(new Text("Type: " + ((ThoiKy) listResult).getTypeModel() + "\n\nDescription: "));
            text = new Text(((ThoiKy) listResult).getDescriptionThoiKy());
            description.getChildren().add(text);
        }
        text.setWrappingWidth(1400);
        text.setStyle("-fx-font-size: 10pt");
        description.setStyle("-fx-padding: 30; -fx-font-size: 14pt");
    }
}
