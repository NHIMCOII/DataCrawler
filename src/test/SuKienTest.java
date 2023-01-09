package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.sukien.SuKien;
import dataCrawler.links.Sukien_Links;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SuKienTest {
    public static void main(String[] args) throws IOException {
        Sukien_Links.printLinks(Sukien_Links.getSuKien_TVLS());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map m = SuKien.getInfo_TVLS(Sukien_Links.getSuKien_TVLS());

        Writer writer = Files.newBufferedWriter(Paths.get("SuKien.json"));
        gson.toJson(m, writer);
        writer.close();
    }
}
