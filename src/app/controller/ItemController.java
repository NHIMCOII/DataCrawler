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

    public static Object ITEM;
    public Object item;
    Text text = new Text();
    @FXML
    private VBox description = new VBox();
    @FXML
    private Button btn;

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btn) {
            Page3Controller.details = item;
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page3.fxml"));
            Stage window = (Stage) btn.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        item = ITEM;
        if (ITEM instanceof DiTich) {
            if (((DiTich) ITEM).getLoai() != null) {
                description.getChildren().add(new Text(((DiTich) ITEM).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiTich) ITEM).getTypeModel() + "\n\nDescription: "));
                text = new Text(((DiTich) ITEM).getDescriptionDiTich());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((DiaDiem) ITEM).getTen()));
                description.getChildren().add(new Text("Type: " + ((DiaDiem) ITEM).getTypeModel() + "\n\nDescription: "));
                text = new Text(((DiaDiem) ITEM).getDescriptionDiaDiem());
                description.getChildren().add(text);
            }
        } else if (ITEM instanceof Vua) {
            if (((Vua) ITEM).getTriVi() != null) {
                description.getChildren().add(new Text(((Vua) ITEM).getTen()));
                description.getChildren().add(new Text("Type: " + ((Vua) ITEM).getTypeModel() + "\n\nDescription: "));
                text = new Text(((Vua) ITEM).getDescriptionVua());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((NhanVat) ITEM).getTen()));
                description.getChildren().add(new Text("Type: " + ((NhanVat) ITEM).getTypeModel() + "\n\nDescription: "));
                text = new Text(((NhanVat) ITEM).getDescriptionNhanvat());
                description.getChildren().add(text);
            }
        } else if (ITEM instanceof LeHoi) {
            description.getChildren().add(new Text(((LeHoi) ITEM).getTen()));
            description.getChildren().add(new Text("Type: " + ((LeHoi) ITEM).getTypeModel() + "\n\nDescription: "));
            text = new Text(((LeHoi) ITEM).getDescriptionLeHoi());
            description.getChildren().add(text);
        } else if (ITEM instanceof ChienTranh) {
            if (((ChienTranh) ITEM).getKetQua() != null || ((ChienTranh) ITEM).getDongMinh() != null) {
                description.getChildren().add(new Text(((ChienTranh) ITEM).getTen()));
                description.getChildren().add(new Text("Type: " + ((ChienTranh) ITEM).getTypeModel() + "\n\nDescription: "));
                text = new Text(((ChienTranh) ITEM).getDescriptionChienTranh());
                description.getChildren().add(text);
            } else {
                description.getChildren().add(new Text(((SuKien) ITEM).getTen()));
                description.getChildren().add(new Text("Type: " + ((SuKien) ITEM).getTypeModel() + "\n\nDescription: "));
                text = new Text(((SuKien) ITEM).getDescriptionSuKien());
                description.getChildren().add(text);
            }
        } else if (ITEM instanceof ThoiKy) {
            description.getChildren().add(new Text(((ThoiKy) ITEM).getTen()));
            description.getChildren().add(new Text("Type: " + ((ThoiKy) ITEM).getTypeModel() + "\n\nDescription: "));
            text = new Text(((ThoiKy) ITEM).getDescriptionThoiKy());
            description.getChildren().add(text);
        }
        text.setWrappingWidth(1400);
        text.setStyle("-fx-font-size: 10pt");
        description.setStyle("-fx-padding: 30; -fx-font-size: 14pt");
    }
}
