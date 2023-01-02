package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.nhanvat.NhanVat;
import dataCrawler.info.nhanvat.Vua;
import dataCrawler.links.Nhanvat_Links;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class NhanVatTest {
    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m1 = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
            Map m2 = NhanVat.getInfoFromNguoiKeSu(Nhanvat_Links.getNhanVat_nguoikesu());

            // m1 or newVal must e instance of m2
            m1.forEach((key, value) -> m2.merge(key, value, (oldVal, newVal) -> {
                return Vua.mergeRule(oldVal, newVal);
            }));
            Writer writer = Files.newBufferedWriter(Paths.get("NhanVat.json"));
            gson.toJson(m2, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
