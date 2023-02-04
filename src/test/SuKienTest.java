package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data_crawler.links.Sukien_Links;
import model.su_kien.SuKien;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SuKienTest {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map m = SuKien.getInfo_TVLS(Sukien_Links.getSuKien_TVLS());
//        Map m1 = ChienTranh.getInfo_Wiki();
//
//        m1.forEach((key, value) -> m.merge(key, value, (oldVal, newVal) -> {
//            return ChienTranh.mergeRule(oldVal, newVal);
//        }));

        Writer writer = Files.newBufferedWriter(Paths.get("SuKien.json"));
        gson.toJson(m, writer);
        writer.close();
    }
}
