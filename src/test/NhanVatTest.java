package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.nhan_vat.ChuTichNuoc;
import model.nhan_vat.NhanVat;
import model.nhan_vat.Vua;
import data_crawler.links.Nhanvat_Links;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class NhanVatTest {
    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m1 = NhanVat.getInfoFromThuVienLichSu(Nhanvat_Links.getNhanVat_thuvienlichsu());
            Map m2 = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
            Map m3 = NhanVat.getInfoFromNguoiKeSu(Nhanvat_Links.getNhanVat_nguoikesu());
            Map m4 = ChuTichNuoc.getInfoFromWiki(Nhanvat_Links.getChuTichNuoc_wiki());
            // m2 or newVal must e instance of m1
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
}
