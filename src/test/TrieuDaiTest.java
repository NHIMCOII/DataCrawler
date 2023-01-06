package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.trieuDai.ThoiKy;
import dataCrawler.links.TrieuDai_Links;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class TrieuDaiTest {
    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map m = ThoiKy.getInfoFromNguoiKeSu(TrieuDai_Links.getThoiKy_nguoikesu());
            
            Writer writer = Files.newBufferedWriter(Paths.get("TrieuDai.json"));
            gson.toJson(m, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
