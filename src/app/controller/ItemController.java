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
    public Object item = new Object();
    Text text = new Text();

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btn) {
            Main.detail = item;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
            Stage window = (Stage) btn.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }

    public ItemController() {
        if (item instanceof DiTich) {
            if (((DiTich) item).getLoai() != null) {
                description.getChildren().add(new Text(((DiTich) item).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiTich) item).getTypeModel() + "\n\nDescription: "));
                text = new Text(((DiTich) item).getDescriptionDiTich());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((DiaDiem) item).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiaDiem) item).getTypeModel() + "\n\nDescription: "));
                text = new Text(((DiaDiem) item).getDescriptionDiaDiem());
                description.getChildren().add(text);
            }
        } else if (item instanceof Vua) {
            if (((Vua) item).getTriVi() != null) {
                description.getChildren().add(new Text(((Vua) item).getTen()));
                description.getChildren().add(new Text("Type: " + ((Vua) item).getTypeModel() + "\n\nDescription: "));
                text = new Text(((Vua) item).getDescriptionVua());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((NhanVat) item).getTen()));
                description.getChildren().add(new Text("Type: " + ((NhanVat) item).getTypeModel() + "\n\nDescription: "));
                text = new Text(((NhanVat) item).getDescriptionNhanvat());
                description.getChildren().add(text);
            }
        } else if (item instanceof LeHoi) {
            description.getChildren().add(new Text(((LeHoi) item).getTen()));
            description.getChildren().add(new Text("Type: " + ((LeHoi) item).getTypeModel() + "\n\nDescription: "));
            text = new Text(((LeHoi) item).getDescriptionLeHoi());
            description.getChildren().add(text);
        } else if (item instanceof ChienTranh) {
            if (((ChienTranh) item).getKetQua() != null || ((ChienTranh) item).getDongMinh() != null) {
                description.getChildren().add(new Text(((ChienTranh) item).getTen()));
                description.getChildren().add(new Text("Type: " + ((ChienTranh) item).getTypeModel() + "\n\nDescription: "));
                text = new Text(((ChienTranh) item).getDescriptionChienTranh());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((SuKien) item).getTen()));
                description.getChildren().add(new Text("Type: " + ((SuKien) item).getTypeModel() + "\n\nDescription: "));
                text = new Text(((SuKien) item).getDescriptionSuKien());
                description.getChildren().add(text);
            }
        } else if (item instanceof ThoiKy) {
            description.getChildren().add(new Text(((ThoiKy) item).getTen()));
            description.getChildren().add(new Text("Type: " + ((ThoiKy) item).getTypeModel() + "\n\nDescription: "));
            text = new Text(((ThoiKy) item).getDescriptionThoiKy());
            description.getChildren().add(text);
        }
        text.setWrappingWidth(1400);
        text.setStyle("-fx-font-size: 10pt");
        description.setStyle("-fx-padding: 30; -fx-font-size: 14pt");
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
