package dataCrawler;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.links.*;
import dataCrawler.info.nhanvat.Vua;

import java.io.FileNotFoundException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class DataCrawler {

    public static void main(String[] args) throws IOException, FileNotFoundException, IllegalAccessException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map m = Vua.getInfoFromWiki(Nhanvat_Links.getVua_wiki());
//        Vua vua1 = new Vua("Duy Anh", "Vua", null, "2100", "Vuong", "?", null, null, null);
//        Vua vua2 = new Vua("Duy Anh", "Vua", "2002", "2100", "Vuong", "Nhimcoii", null, null, null);
//        Vua vua3 = new Vua("Nhimcoii", "Vua", "2002", "2100", "Vuong", "Nhimcoii", null, null, null);
//        Map m1 = new LinkedHashMap();
//        Map m2 = new LinkedHashMap();
//
//        m1.put(vua1.getTen(), vua1);
//        m1.put(vua3.getTen(), vua3);
//        m2.put(vua2.getTen(), vua2);
//
//        m2.forEach((key, value) -> m1.merge(key, value, (oldVal, newVal) -> {
//            return Vua.mergeRule(oldVal, newVal);
//        }));
        Writer writer = Files.newBufferedWriter(Paths.get("NhanVat.json"));
        gson.toJson(m, writer);
        writer.close();
    }
}


