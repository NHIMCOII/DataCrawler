package dataCrawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.info.nhanvat.Vua;
import dataCrawler.links.Nhanvat_Links;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class DataCrawler {

    public static void main(String[] args) {
        try {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            Map m1 = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
//            Nhanvat_Links.getNhanVat_thuvienlichsu();
//            Vua vua1 = new Vua("dUy anh", "Vua", null, "2100", "?", "?", null, null, null);
//            Vua vua2 = new Vua("Duy ANh", "Vua", "2002", "2100", "Vuong", "Nhimcoii", null, null, null);
//            Vua vua3 = new Vua("Nhimcoii", "Vua", "2002", "2100", "Vuong", "Nhimcoii", null, null, null);
//            Map m1 = new TreeMap();
//            Map m2 = new TreeMap();
//
//            m1.put(vua1.getTen().trim().toLowerCase(), vua1);
//            m1.put(vua3.getTen().trim().toLowerCase(), vua3);
//            m2.put(vua2.getTen().trim().toLowerCase(), vua2);
//
//            m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
//                return Vua.mergeRule(oldVal, newVal);
//            }));
//            Writer writer = Files.newBufferedWriter(Paths.get("NhanVat.json"));
//            gson.toJson(m1, writer);
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


