package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.diadiem.DiSan;
import dataCrawler.info.diadiem.DiTich;
import dataCrawler.info.diadiem.DiaDiem;
import dataCrawler.links.Diadiem_Links;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class DiaDiemTest {
    public static void main(String[] args) throws IOException {
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
}
