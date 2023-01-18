package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.diadiem.DiTich;
import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class LeHoiTest {
    public static void main(String[] args) throws IOException {
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
}
