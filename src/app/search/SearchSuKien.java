package app.search;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.diadiem.DiaDiem;
import model.nhanvat.NhanVat;
import model.sukien.ChienTranh;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;
import util.SeperateTool;

public class SearchSuKien {
    public static List<SuKien> output = new ArrayList<>();
    public static ArrayList<SuKien> view = new ArrayList<>();

    public static void search(String key) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result;
        String suKien = new File("").getAbsolutePath();
        suKien = suKien.concat("\\src\\data\\SuKien.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(suKien)));

            Map<String, SuKien> mapSuKien = new Gson().fromJson(result, new TypeToken<TreeMap<String, ChienTranh>>() {
            }.getType());

            // view all
            for (Entry<String, SuKien> suKienEntry : mapSuKien.entrySet()) {
                String keyEntry = suKienEntry.getKey();
                SuKien valueEntry = suKienEntry.getValue();
                SearchKey.result.add(valueEntry);
            }

            // input
            String search;
            search = NormalizeTool.normalizeKey(key);

            // toan phan
            if (mapSuKien.containsKey(search)) {
                SuKien tk = (SuKien) mapSuKien.get(search);
                output.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
