package app.search;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.diadiem.DiTich;
import model.diadiem.DiaDiem;
import util.NormalizeTool;

public class SearchDiaDiem {

    public static List<DiaDiem> output = new ArrayList<>();
    public static ArrayList<Object> view = new ArrayList<>();
    public static void search(String key) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result;
        String diaDiem = new File("").getAbsolutePath();
        diaDiem = diaDiem.concat("\\src\\data\\DiaDiem.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(diaDiem)));
            Map<String, DiTich> mapDiaDiem = new Gson().fromJson(result, new TypeToken<TreeMap<String, DiTich>>() {
            }.getType());

            // view all
            for (Entry<String, DiTich> diaDiemEntry : mapDiaDiem.entrySet()) {
                String keyEntry = diaDiemEntry.getKey();
                DiaDiem valueEntry = diaDiemEntry.getValue();
                SearchKey.result.add(valueEntry);
            }

            String search;
            search = NormalizeTool.normalizeKey(key);

            // tìm kiếm toàn phần
            if (mapDiaDiem.containsKey(search)) {
                DiaDiem tk = (DiaDiem) mapDiaDiem.get(search);
                output.add(tk);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
