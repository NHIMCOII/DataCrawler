package dataCrawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.links.Diadiem_Links;
import dataCrawler.links.Nhanvat_Links;
import dataCrawler.links.Sukien_Links;
import dataCrawler.links.ThoiKy_Links;
import model.diadiem.DiSan;
import model.diadiem.DiTich;
import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;
import model.nhanvat.ChuTichNuoc;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import model.sukien.ChienTranh;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class DataCrawler {
    public static void parseJSONDiaDiem () throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map m = DiaDiem.getInfo_TVLS(Diadiem_Links.getDiaDiem_TVLS());
        Map m1 = DiaDiem.getInfo_Wiki();
        Map m2 = DiTich.getInfo_Wiki();
        Map m3 = DiSan.getInfo_Wiki();

        m1.forEach((key, value) -> m.merge(key, value, (oldVal, newVal) -> {
            return DiaDiem.mergeRule(oldVal, newVal);
        }));

        m2.forEach((key, value) -> m.merge(key, value, (oldVal, newVal) -> {
            return DiTich.mergeRule(oldVal, newVal);
        }));

        m3.forEach((key, value) -> m.merge(key, value, (oldVal, newVal) -> {
            return DiSan.mergeRule(oldVal, newVal);
        }));

        Writer writer = Files.newBufferedWriter(Paths.get("DiaDiem.json"));
        gson.toJson(m, writer);
        writer.close();
    }

    public static void parseJSONNhanVat () throws IOException {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m1 = NhanVat.getInfoFromThuVienLichSu(Nhanvat_Links.getNhanVat_thuvienlichsu());
            Map m2 = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
            Map m3 = NhanVat.getInfoFromNguoiKeSu(Nhanvat_Links.getNhanVat_nguoikesu());
            Map m4 = ChuTichNuoc.getInfoFromWiki(Nhanvat_Links.getChuTichNuoc_wiki());
//            // m2 or newVal must e instance of m1
            m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return Vua.mergeRule(oldVal, newVal);
            }));

            m3.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return NhanVat.mergeRule(oldVal, newVal);
            }));

            m4.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return ChuTichNuoc.mergeRule(oldVal, newVal);
            }));

            Writer writer = Files.newBufferedWriter(Paths.get("NhanVat.json"));
            gson.toJson(m1, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseJSONSuKien () throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map m = SuKien.getInfo_TVLS(Sukien_Links.getSuKien_TVLS());
        Map m1 = ChienTranh.getInfo_Wiki();

        m1.forEach((key, value) -> m.merge(key, value, (oldVal, newVal) -> {
            return ChienTranh.mergeRule(oldVal, newVal);
        }));

        Writer writer = Files.newBufferedWriter(Paths.get("SuKien.json"));
        gson.toJson(m, writer);
        writer.close();
    }

    public static void parseJSONThoiKy () throws IOException {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m1 = ThoiKy.getInfoFromNguoiKeSu(ThoiKy_Links.getThoiKy_nguoikesu());
            Map m2 = ThoiKy.getInfoFromThuVienLichSu(ThoiKy_Links.getThoiKy_thuvienlichsu());

            m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return ThoiKy.mergeRule(oldVal, newVal);
            }));
            Writer writer = Files.newBufferedWriter(Paths.get("ThoiKy.json"));
            gson.toJson(m1, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseJSONLeHoi () throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Map m1 = LeHoi.getInfoFromWiki();
        Map m2 = LeHoi.getInfoFromBestPrice();
        Map m3 = LeHoi.getInfoFromGov();

        m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
            return LeHoi.mergeRule(oldVal, newVal);
        }));

        m3.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
            return LeHoi.mergeRule(oldVal, newVal);
        }));

        Writer writer = Files.newBufferedWriter(Paths.get("LeHoi.json"));
        gson.toJson(m1, writer);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        parseJSONDiaDiem();
        parseJSONLeHoi();
        parseJSONNhanVat();
        parseJSONSuKien();
        parseJSONThoiKy();
    }
}


