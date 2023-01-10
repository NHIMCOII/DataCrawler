package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.model.nhanvat.Vua;
import dataCrawler.model.thoiKy.ThoiKy;
import dataCrawler.links.ThoiKy_Links;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ThoiKyTest {
    public static void main(String[] args) {
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
}
