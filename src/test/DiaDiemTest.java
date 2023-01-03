package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.diadiem.DiaDiem;
import dataCrawler.links.Diadiem_Links;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class DiaDiemTest {
    public static void main(String[] args) throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Map m = DiaDiem.getInfo_TVLS(Diadiem_Links.getDiaDiem_TVLS());
//
//        Writer writer = Files.newBufferedWriter(Paths.get("DiaDiem.json"));
//        gson.toJson(m, writer);
//        writer.close();

        Map m = DiaDiem.getInfo_Wiki();
        System.out.println(m);
    }
}
