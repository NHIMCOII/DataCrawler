package app.controller;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.diadiem.DiTich;
import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import model.sukien.ChienTranh;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Page3Controller implements Initializable {
    @FXML
    private VBox information;
    public Object obj = new Object();

    public void printItem(Object obj) {
        if (obj instanceof DiTich) {
            if (((DiTich) obj).getLoai() == null) {
                information.getChildren().add(new Text(((DiTich) obj).getTen()));
            } else {
                information.getChildren().add(new Text(((DiaDiem) obj).getTen()));
            }
        } else if (obj instanceof Vua) {
            if (((Vua) obj).getTriVi() == null || ((Vua) obj).getNienHieu() == null) {
                information.getChildren().add(new Text(((Vua) obj).getTen()));
            } else {
                information.getChildren().add(new Text(((NhanVat) obj).getTen()));
            }
        } else if (obj instanceof LeHoi) {
            information.getChildren().add(new Text(((LeHoi) obj).getTen()));
        } else if (obj instanceof ChienTranh) {
            if (((ChienTranh) obj).getKetQua() == null || ((ChienTranh) obj).getDongMinh() == null) {
                information.getChildren().add(new Text(((ChienTranh) obj).getTen()));
            } else {
                information.getChildren().add(new Text(((SuKien) obj).getTen()));
            }
        } else if (obj instanceof ThoiKy) {
            information.getChildren().add(new Text(((ThoiKy) obj).getTen()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        printItem(Main.detail);
    }
}
