package app.controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import model.thoi_ky.TrieuDai;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Page3Controller implements Initializable {
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<TrieuDai> listTrieuDai = new ArrayList<>();
    public static Map<String, String> map = new LinkedHashMap<>();
    public static String title = "";
    public Button btnBack3;
    public Object obj = new Object();
    Text text = new Text();
    Node[] node = new Node[5];
    @FXML
    private VBox information;
    @FXML
    private VBox basicInfo;
    @FXML
    private Text name;

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
                if (((DiTich) obj).getViTri() != null)
                    basicInfo.getChildren().add((new Text("Vị trí: " + ((DiTich) obj).getViTri())));
                if (((DiTich) obj).getLoai() != null)
                    basicInfo.getChildren().add((new Text("Loại: " + ((DiTich) obj).getLoai())));
                if (((DiTich) obj).getNamCongNhan() != null)
                    basicInfo.getChildren().add((new Text("Năm công nhận: " + ((DiTich) obj).getNamCongNhan())));
                if (((DiTich) obj).getKhuVuc() != null)
                    basicInfo.getChildren().add((new Text("Khu vực: " + ((DiTich) obj).getKhuVuc())));
                if (((DiTich) obj).getDienTich() != null)
                    basicInfo.getChildren().add((new Text("Diện tích: " + ((DiTich) obj).getDienTich())));
                if (((DiTich) obj).getNamThanhLap() != null)
                    basicInfo.getChildren().add((new Text("Năm thành lập: " + ((DiTich) obj).getNamThanhLap())));
                list.add(((DiTich) obj).getLichSu());
                if (list != null) {
                    title = "Lịch sử";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((DiTich) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((DiTich) obj).getSuKien();
                if (list != null) {
                    title = "Sự kiện";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((DiTich) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
            } else {
                name.setText(((DiaDiem) obj).getTen());
                if (((DiaDiem) obj).getKhuVuc() != null)
                    basicInfo.getChildren().add((new Text("Khu vực: " + ((DiaDiem) obj).getKhuVuc())));
                if (((DiaDiem) obj).getDienTich() != null)
                    basicInfo.getChildren().add((new Text("Diện tích: " + ((DiaDiem) obj).getDienTich())));
                if (((DiaDiem) obj).getNamThanhLap() != null)
                    basicInfo.getChildren().add((new Text("Năm thành lập: " + ((DiaDiem) obj).getNamThanhLap())));
                list.add(((DiaDiem) obj).getLichSu());
                if (list != null) {
                    title = "Lịch sử";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((DiaDiem) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((DiaDiem) obj).getSuKien();
                if (list != null) {
                    title = "Sự kiện";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((DiaDiem) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
            }
        } else if (obj instanceof Vua) {
            if (((Vua) obj).getTriVi() != null) {
                name.setText(((Vua) obj).getTen());
                if (((Vua) obj).getTonHieu() != null)
                    basicInfo.getChildren().add((new Text("Tôn hiệu: " + ((Vua) obj).getTonHieu())));
                if (((Vua) obj).getMieuHieu() != null)
                    basicInfo.getChildren().add((new Text(((Vua) obj).getMieuHieu())));
                if (((Vua) obj).getThuyHieu() != null)
                    basicInfo.getChildren().add((new Text(((Vua) obj).getThuyHieu())));
                if (((Vua) obj).getTriVi() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getTriVi())));
                if (((Vua) obj).getNienHieu() != null)
                    basicInfo.getChildren().add((new Text(((Vua) obj).getNienHieu())));
                if (((Vua) obj).getTienNhiem() != null)
                    basicInfo.getChildren().add((new Text(((Vua) obj).getTienNhiem())));
                if (((Vua) obj).getKeNhiem() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getKeNhiem())));
                if (((Vua) obj).getSinh() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getSinh())));
                if (((Vua) obj).getMat() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getMat())));
                if (((Vua) obj).getTenKhac() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getTenKhac())));
                if (((Vua) obj).getQueQuan() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getQueQuan())));
                if (((Vua) obj).getNoiO() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getNoiO())));
                if (((Vua) obj).getDanToc() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getDanToc())));
                if (((Vua) obj).getChucVu() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getChucVu())));
                if (((Vua) obj).getHocvan() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getHocvan())));
                if (((Vua) obj).getDangPhai() != null)
                    basicInfo.getChildren().add((new Text(((Vua) obj).getDangPhai())));
                if (((Vua) obj).getTonGiao() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getTonGiao())));
                if (((Vua) obj).getThanPhu() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getThanPhu())));
                if (((Vua) obj).getThanMau() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getThanMau())));
                if (((Vua) obj).getNguyenNhanMat() != null)
                    basicInfo.getChildren().add((new Text(((Vua) obj).getNguyenNhanMat())));
                if (((Vua) obj).getAnTang() != null) basicInfo.getChildren().add((new Text(((Vua) obj).getAnTang())));
                list.add(((Vua) obj).getMoTa());
                if (list != null) {
                    title = "Mô tả";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((Vua) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((Vua) obj).getVo();
                if (list != null) {
                    title = "Vợ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((Vua) obj).getHauDue();
                if (list != null) {
                    title = "Hậu duệ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((Vua) obj).getNhanVatCungThoiKy();
                if (list != null) {
                    title = "Nhân vật cùng thời kỳ";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                map = ((Vua) obj).getCuocDoi();
                if (map != null) {
                    title = "Cuộc đời";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    map.clear();
                }
            } else {
                name.setText(((NhanVat) obj).getTen());
                if (((NhanVat) obj).getSinh() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getSinh())));
                if (((NhanVat) obj).getMat() != null) basicInfo.getChildren().add((new Text(((NhanVat) obj).getMat())));
                if (((NhanVat) obj).getTenKhac() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getTenKhac())));
                if (((NhanVat) obj).getQueQuan() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getQueQuan())));
                if (((NhanVat) obj).getNoiO() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getNoiO())));
                if (((NhanVat) obj).getDanToc() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getDanToc())));
                if (((NhanVat) obj).getChucVu() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getChucVu())));
                if (((NhanVat) obj).getHocvan() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getHocvan())));
                if (((NhanVat) obj).getDangPhai() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getDangPhai())));
                if (((NhanVat) obj).getTonGiao() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getTonGiao())));
                if (((NhanVat) obj).getThanPhu() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getThanPhu())));
                if (((NhanVat) obj).getThanMau() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getThanMau())));
                if (((NhanVat) obj).getNguyenNhanMat() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getNguyenNhanMat())));
                if (((NhanVat) obj).getAnTang() != null)
                    basicInfo.getChildren().add((new Text(((NhanVat) obj).getAnTang())));
                list.add(((NhanVat) obj).getMoTa());
                if (list != null) {
                    title = "Mô tả";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((NhanVat) obj).getVo();
                if (list != null) {
                    title = "Vợ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((NhanVat) obj).getHauDue();
                if (list != null) {
                    title = "Hậu duệ";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((NhanVat) obj).getNhanVatCungThoiKy();
                if (list != null) {
                    title = "Nhân vật cùng thời kỳ";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((NhanVat) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                map = ((NhanVat) obj).getCuocDoi();
                if (map != null) {
                    title = "Cuộc đời";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    map.clear();
                }
            }
        } else if (obj instanceof LeHoi) {
            name.setText(((LeHoi) obj).getTen());
            if (((LeHoi) obj).getViTri() != null) basicInfo.getChildren().add((new Text(((LeHoi) obj).getViTri())));
            if (((LeHoi) obj).getNgayAmLich() != null)
                basicInfo.getChildren().add((new Text(((LeHoi) obj).getNgayAmLich())));
            if (((LeHoi) obj).getLanDauToChuc() != null)
                basicInfo.getChildren().add((new Text(((LeHoi) obj).getLanDauToChuc())));
            list.add(((LeHoi) obj).getMoTa());
            if (list != null) {
                title = "Mô tả";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
            list = ((LeHoi) obj).getNhanVat();
            if (list != null) {
                title = "Nhân vật";
//                LinkController link = new LinkController();
//                link.linkTitle = title;
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
            list = ((LeHoi) obj).getLinks();
            if (list != null) {
                title = "Links";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
        } else if (obj instanceof ChienTranh) {
            if (((ChienTranh) obj).getKetQua() != null || ((ChienTranh) obj).getDongMinh() != null) {
                name.setText(((ChienTranh) obj).getTen());
                if (((ChienTranh) obj).getThoiGian() != null)
                    basicInfo.getChildren().add((new Text(((ChienTranh) obj).getThoiGian())));
                if (((ChienTranh) obj).getThoiKy() != null)
                    basicInfo.getChildren().add((new Text(((ChienTranh) obj).getThoiKy())));
                if (((ChienTranh) obj).getDongMinh() != null)
                    basicInfo.getChildren().add((new Text(((ChienTranh) obj).getDongMinh())));
                if (((ChienTranh) obj).getDoiPhuong() != null)
                    basicInfo.getChildren().add((new Text(((ChienTranh) obj).getDoiPhuong())));
                if (((ChienTranh) obj).getKetQua() != null)
                    basicInfo.getChildren().add((new Text(((ChienTranh) obj).getKetQua())));
                list.add(((ChienTranh) obj).getDienBien());
                if (list != null) {
                    title = "Diễn biến";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((ChienTranh) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((ChienTranh) obj).getDiaDiem();
                if (list != null) {
                    title = "Địa điểm";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((ChienTranh) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
            } else {
                name.setText(((SuKien) obj).getTen());
                if (((ChienTranh) obj).getThoiGian() != null)
                    basicInfo.getChildren().add((new Text(((ChienTranh) obj).getThoiGian())));
                list.add(((ChienTranh) obj).getDienBien());
                if (list != null) {
                    title = "Diễn biến";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((SuKien) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((SuKien) obj).getDiaDiem();
                if (list != null) {
                    title = "Địa điểm";
//                    LinkController link = new LinkController();
//                    link.linkTitle = title;
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((SuKien) obj).getLinks();
                if (list != null) {
                    title = "Links";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
            }
        } else if (obj instanceof ThoiKy) {
            name.setText(((ThoiKy) obj).getTen());
            list.add(((ThoiKy) obj).getMoTa());
            if (list != null) {
                title = "Mô tả";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
            listTrieuDai = ((ThoiKy) obj).getTrieuDai();
            if (listTrieuDai != null) {
                title = "Triều đại";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                listTrieuDai.clear();
            }
            list = ((ThoiKy) obj).getSukien();
            if (list != null) {
                title = "Sự kiện";
//                LinkController link = new LinkController();
//                link.linkTitle = title;
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
            list = ((ThoiKy) obj).getLinks();
            if (list != null) {
                title = "Links";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
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
