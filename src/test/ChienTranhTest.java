package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.sukien.ChienTranh;
import dataCrawler.info.sukien.SuKien;
import dataCrawler.links.Sukien_Links;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ChienTranhTest {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map m = ChienTranh.getInfo_Wiki();

        Writer writer = Files.newBufferedWriter(Paths.get("ChienTranh.json"));
        gson.toJson(m, writer);
        writer.close();
    }
}
