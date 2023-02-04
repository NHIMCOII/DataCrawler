package app;

import app.search.SearchKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.diadiem.DiSan;
import model.diadiem.DiaDiem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result;
        String diaDiem = new File("").getAbsolutePath();
        diaDiem = diaDiem.concat("\\src\\data\\DiaDiem.json");
        result = new String(Files.readAllBytes(Paths.get(diaDiem)));
        Map<String, Object> mapDiaDiem = new Gson().fromJson(result, new TypeToken<TreeMap<String, DiaDiem>>() {
        }.getType());
        Map<String, Object> mapDiSan = new Gson().fromJson(result, new TypeToken<TreeMap<String, DiSan>>() {
        }.getType());
        if (SearchKey.searchForValue(mapDiaDiem, "vinh ha long") instanceof DiSan) {
            DiSan diSan = (DiSan) SearchKey.searchForValue(mapDiaDiem, "vinh ha long");
        }
    }
}
