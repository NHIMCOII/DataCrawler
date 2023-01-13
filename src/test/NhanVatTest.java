package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import dataCrawler.links.Nhanvat_Links;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class NhanVatTest {
    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m1 = NhanVat.getInfoFromNguoiKeSu(Nhanvat_Links.getNhanVat_nguoikesu());
            Map m2 = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
            Map m3 = NhanVat.getInfoFromThuVienLichSu(Nhanvat_Links.getNhanVat_thuvienlichsu());

            // m2 or newVal must e instance of m1
            m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return Vua.mergeRule(oldVal, newVal);
            }));

            m3.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
                return NhanVat.mergeRule(oldVal, newVal);
            }));

            Writer writer = Files.newBufferedWriter(Paths.get("NhanVat.json"));
            gson.toJson(m1, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
