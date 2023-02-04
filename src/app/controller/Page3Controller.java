package app.controller;

import app.Main;
import app.search.SearchKey;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Page3Controller implements Initializable {
    public Button btnBack3;
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
    public static Map<String, String> map = new LinkedHashMap<>();
    public static String title = "";

    public void handleBtn(ActionEvent event) throws Exception {
        if (event.getSource() == btnBack3) {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Page2.fxml"));
            Stage window = (Stage) btnBack3.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }

    public void printItem(Object obj) throws IOException {
        if (obj instanceof DiTich) {
            if (((DiTich) obj).getLoai() != null) {
                name.setText(((DiTich) obj).getTen());
                text = new Text(((DiTich) obj).getDescriptionDiTich());
                basicInfo.getChildren().add(text);
                text = new Text("Lịch sử: " + ((DiTich) obj).getDescriptionDiaDiem());
                basicInfo.getChildren().add(text);
                list = ((DiTich) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((DiTich) obj).getSuKien();
                if (list != null) {
                    title = "Sự kiện";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((DiTich) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
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
                text = new Text(((Vua) obj).getMoTa());
                basicInfo.getChildren().add(text);
                basicInfo.getChildren().add((new Text("Tôn hiệu: " + ((Vua) obj).getTonHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getMieuHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getThuyHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getTriVi())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getNienHieu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getTienNhiem())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getKeNhiem())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getSinh())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getMat())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getTenKhac())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getQueQuan())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getNoiO())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getDanToc())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getChucVu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getHocvan())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getDangPhai())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getTonGiao())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getThanPhu())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getThanMau())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getNguyenNhanMat())));
                basicInfo.getChildren().add((new Text(((Vua) obj).getAnTang())));
                list = ((Vua) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((Vua) obj).getVo();
                if (list != null) {
                    title = "Vợ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((Vua) obj).getHauDue();
                if (list != null) {
                    title = "Hậu duệ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((Vua) obj).getNhanVatCungThoiKy();
                if (list != null) {
                    title = "Nhân vật cùng thời kỳ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list.clear();
                map = ((Vua) obj).getCuocDoi();
            } else {
                name.setText(((NhanVat) obj).getTen());
                text = new Text(((NhanVat) obj).getMoTa());
                basicInfo.getChildren().add(text);
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
                list.clear();
                map = ((NhanVat) obj).getCuocDoi();
                if (map != null) {
                    title = "Cuộc đời";
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
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getThoiGian())));
                text = new Text(((ChienTranh) obj).getDienBien());
                basicInfo.getChildren().add(text);
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getThoiKy())));
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getDongMinh())));
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getDoiPhuong())));
                basicInfo.getChildren().add((new Text(((ChienTranh) obj).getKetQua())));
                list = ((ChienTranh) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((ChienTranh) obj).getDiaDiem();
                if (list != null) {
                    title = "Địa điểm";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
                list = ((ChienTranh) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                }
            } else {
                name.setText(((SuKien) obj).getTen());
                basicInfo.getChildren().add((new Text(((SuKien) obj).getThoiGian())));
                text = new Text(((SuKien) obj).getDienBien());
                basicInfo.getChildren().add(text);
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
