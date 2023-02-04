package app.controller;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class Page3Controller implements Initializable {
    @FXML
    private VBox information;
    @FXML
    private VBox basicInfo;
    @FXML
    private Text name;
    public Object obj = new Object();
    Text text = new Text();
    Node[] node = new Node[5];
    public static ArrayList<String> list = new ArrayList<>();
    public static String title = "";

    public void printItem(Object obj) throws IOException {
        if (obj instanceof DiTich) {
            if (((DiTich) obj).getLoai() != null) {
                name.setText(((DiTich) obj).getTen());
                text = new Text(((DiTich) obj).getDescriptionDiTich());
                basicInfo.getChildren().add((text));
            } else {
                name.setText(((DiaDiem) obj).getTen());
                text = new Text("Lịch sử: " + ((DiaDiem) obj).getDescriptionDiaDiem());
                basicInfo.getChildren().add(text);
                list = ((DiaDiem) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((DiaDiem) obj).getSuKien();
                if (list != null) {
                    title = "Sự kiện";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((DiaDiem) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
            }
        } else if (obj instanceof Vua) {
            if (((Vua) obj).getTriVi() != null) {
                name.setText(((Vua) obj).getTen());
                basicInfo.getChildren().add((new Text("Tôn hiệu: " + ((Vua) obj).getTonHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getMieuHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getThuyHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getTriVi())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getNienHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getTienNhiem())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getKeNhiem())));
                list = ((Vua) obj).getTuocHieu();
                if (list != null) {
                    title = "Tước hiệu";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
            } else {
                name.setText(((NhanVat) obj).getTen());
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getSinh())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getMat())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getTenKhac())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getQueQuan())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getNoiO())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getDanToc())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getChucVu())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getHocvan())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getDangPhai())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getTonGiao())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getThanPhu())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getThanMau())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getNguyenNhanMat())));
                basicInfo.getChildren().add((new Text(((NhanVat) obj).getAnTang())));
                list = ((NhanVat) obj).getVo();
                if (list != null) {
                    title = "Vợ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((NhanVat) obj).getHauDue();
                if (list != null) {
                    title = "Hậu duệ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((NhanVat) obj).getNhanVatCungThoiKy();
                if (list != null) {
                    title = "Nhân vật cùng thời kỳ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((NhanVat) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
            }
        } else if (obj instanceof LeHoi) {
            name.setText(((LeHoi) obj).getTen());
            basicInfo.getChildren().add((new Text(((LeHoi) obj).getViTri())));
            basicInfo.getChildren().add((new Text(((LeHoi) obj).getNgayAmLich())));
            basicInfo.getChildren().add((new Text(((LeHoi) obj).getLanDauToChuc())));
            list = ((LeHoi) obj).getNhanVat();
            if (list != null) {
                title = "Nhân vật";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
            }
            list = ((LeHoi) obj).getLinks();
            if (list != null) {
                title = "Links";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
            }
        } else if (obj instanceof ChienTranh) {
            if (((ChienTranh) obj).getKetQua() != null || ((ChienTranh) obj).getDongMinh() != null) {
                name.setText(((ChienTranh) obj).getTen());
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getThoiKy())));
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getDongMinh())));
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getDoiPhuong())));
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getKetQua())));
            } else {
                name.setText(((SuKien) obj).getTen());
                basicInfo.getChildren().add((new Text(((SuKien) obj).getThoiGian())));
                basicInfo.getChildren().add((new Text(((SuKien) obj).getDienBien())));
                list = ((SuKien) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((SuKien) obj).getDiaDiem();
                if (list != null) {
                    title = "Địa điểm";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((SuKien) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
            }
        } else if (obj instanceof ThoiKy) {
            name.setText(((ThoiKy) obj).getTen());
            text = new Text(((ThoiKy) obj).getMoTa());
            basicInfo.getChildren().add(text);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setStyle("-fx-padding: 50; -fx-font-size: 25pt");
        try {
            printItem(Main.detail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        text.setWrappingWidth(1500);
    }
}
