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
    public static Object details;
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
                    list.add("Vị trí: " + ((DiTich) obj).getViTri());
                if (((DiTich) obj).getLoai() != null)
                    list.add("Loại: " + ((DiTich) obj).getLoai());
                if (((DiTich) obj).getNamCongNhan() != null)
                    list.add("Năm công nhận: " + ((DiTich) obj).getNamCongNhan());
                if (((DiTich) obj).getKhuVuc() != null)
                    list.add("Khu vực: " + ((DiTich) obj).getKhuVuc());
                if (((DiTich) obj).getDienTich() != null)
                    list.add("Diện tích: " + ((DiTich) obj).getDienTich());
                if (((DiTich) obj).getNamThanhLap() != null)
                    list.add("Năm thành lập: " + ((DiTich) obj).getNamThanhLap());
                if (list != null) {
                    title = "Thông tin";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
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
                    list.add("Khu vực: " + ((DiaDiem) obj).getKhuVuc());
                if (((DiaDiem) obj).getDienTich() != null)
                    list.add("Diện tích: " + ((DiaDiem) obj).getDienTich());
                if (((DiaDiem) obj).getNamThanhLap() != null)
                    list.add("Năm thành lập: " + ((DiaDiem) obj).getNamThanhLap());
                if (list != null) {
                    title = "Thông tin";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
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
                    list.add("Tôn hiệu: " + ((Vua) obj).getTonHieu());
                if (((Vua) obj).getMieuHieu() != null)
                    list.add(((Vua) obj).getMieuHieu());
                if (((Vua) obj).getThuyHieu() != null)
                    list.add(((Vua) obj).getThuyHieu());
                if (((Vua) obj).getTriVi() != null) list.add(((Vua) obj).getTriVi());
                if (((Vua) obj).getNienHieu() != null)
                    list.add(((Vua) obj).getNienHieu());
                if (((Vua) obj).getTienNhiem() != null)
                    list.add(((Vua) obj).getTienNhiem());
                if (((Vua) obj).getKeNhiem() != null) list.add(((Vua) obj).getKeNhiem());
                if (((Vua) obj).getSinh() != null) list.add(((Vua) obj).getSinh());
                if (((Vua) obj).getMat() != null) list.add(((Vua) obj).getMat());
                if (((Vua) obj).getTenKhac() != null) list.add(((Vua) obj).getTenKhac());
                if (((Vua) obj).getQueQuan() != null) list.add(((Vua) obj).getQueQuan());
                if (((Vua) obj).getNoiO() != null) list.add(((Vua) obj).getNoiO());
                if (((Vua) obj).getDanToc() != null) list.add(((Vua) obj).getDanToc());
                if (((Vua) obj).getChucVu() != null) list.add(((Vua) obj).getChucVu());
                if (((Vua) obj).getHocvan() != null) list.add(((Vua) obj).getHocvan());
                if (((Vua) obj).getDangPhai() != null)
                    list.add(((Vua) obj).getDangPhai());
                if (((Vua) obj).getTonGiao() != null) list.add(((Vua) obj).getTonGiao());
                if (((Vua) obj).getThanPhu() != null) list.add(((Vua) obj).getThanPhu());
                if (((Vua) obj).getThanMau() != null) list.add(((Vua) obj).getThanMau());
                if (((Vua) obj).getNguyenNhanMat() != null)
                    list.add(((Vua) obj).getNguyenNhanMat());
                if (((Vua) obj).getAnTang() != null) list.add(((Vua) obj).getAnTang());
                if (list != null) {
                    title = "Thông tin";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
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
                if (((NhanVat) obj).getSinh() != null) list.add(((NhanVat) obj).getSinh());
                if (((NhanVat) obj).getMat() != null) list.add(((NhanVat) obj).getMat());
                if (((NhanVat) obj).getTenKhac() != null) list.add(((NhanVat) obj).getTenKhac());
                if (((NhanVat) obj).getQueQuan() != null) list.add(((NhanVat) obj).getQueQuan());
                if (((NhanVat) obj).getNoiO() != null) list.add(((NhanVat) obj).getNoiO());
                if (((NhanVat) obj).getDanToc() != null) list.add(((NhanVat) obj).getDanToc());
                if (((NhanVat) obj).getChucVu() != null) list.add(((NhanVat) obj).getChucVu());
                if (((NhanVat) obj).getHocvan() != null) list.add(((NhanVat) obj).getHocvan());
                if (((NhanVat) obj).getDangPhai() != null)
                    list.add(((NhanVat) obj).getDangPhai());
                if (((NhanVat) obj).getTonGiao() != null) list.add(((NhanVat) obj).getTonGiao());
                if (((NhanVat) obj).getThanPhu() != null) list.add(((NhanVat) obj).getThanPhu());
                if (((NhanVat) obj).getThanMau() != null) list.add(((NhanVat) obj).getThanMau());
                if (((NhanVat) obj).getNguyenNhanMat() != null)
                    list.add(((NhanVat) obj).getNguyenNhanMat());
                if (((Vua) obj).getAnTang() != null) list.add(((NhanVat) obj).getAnTang());
                if (list != null) {
                    title = "Thông tin";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
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
            if (((LeHoi) obj).getViTri() != null) list.add(((LeHoi) obj).getViTri());
            if (((LeHoi) obj).getNgayAmLich() != null)
                list.add(((LeHoi) obj).getNgayAmLich());
            if (((LeHoi) obj).getLanDauToChuc() != null)
                list.add(((LeHoi) obj).getLanDauToChuc());
            if (list != null) {
                title = "Thông tin";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
            list.add(((LeHoi) obj).getMoTa());
            if (list != null) {
                title = "Mô tả";
                information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                list.clear();
            }
            list = ((LeHoi) obj).getNhanVat();
            if (list != null) {
                title = "Nhân vật";
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
                    list.add(((ChienTranh) obj).getThoiGian());
                if (((ChienTranh) obj).getThoiKy() != null)
                    list.add(((ChienTranh) obj).getThoiKy());
                if (((ChienTranh) obj).getDongMinh() != null)
                    list.add(((ChienTranh) obj).getDongMinh());
                if (((ChienTranh) obj).getDoiPhuong() != null)
                    list.add(((ChienTranh) obj).getDoiPhuong());
                if (((ChienTranh) obj).getKetQua() != null)
                    list.add(((ChienTranh) obj).getKetQua());
                if (list != null) {
                    title = "Thông tin";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list.add(((ChienTranh) obj).getDienBien());
                if (list != null) {
                    title = "Diễn biến";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((ChienTranh) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((ChienTranh) obj).getDiaDiem();
                if (list != null) {
                    title = "Địa điểm";
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
                    list.add(((ChienTranh) obj).getThoiGian());
                if (list != null) {
                    title = "Thông tin";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list.add(((ChienTranh) obj).getDienBien());
                if (list != null) {
                    title = "Diễn biến";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((SuKien) obj).getNhanVat();
                if (list != null) {
                    title = "Nhân vật";
                    information.getChildren().add(FXMLLoader.load(getClass().getResource("../view/boxDetail.fxml")));
                    list.clear();
                }
                list = ((SuKien) obj).getDiaDiem();
                if (list != null) {
                    title = "Địa điểm";
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
            printItem(details);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        text.setWrappingWidth(1500);
    }
}
