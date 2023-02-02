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
import model.lehoi.LeHoi;
import model.nhanvat.NhanVat;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;
import util.SeperateTool;

public class SearchLeHoi {
    public static List<LeHoi> output = new ArrayList<>();
    public static ArrayList<LeHoi> view = new ArrayList<>();
    public static void search(String key) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result;
        String leHoi = new File("").getAbsolutePath();
        leHoi = leHoi.concat("\\src\\data\\LeHoi.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(leHoi)));

            Map<String, LeHoi> mapLeHoi = new Gson().fromJson(result, new TypeToken<TreeMap<String, LeHoi>>() {
            }.getType());

            // view all
            for (Entry<String, LeHoi> leHoiEntry : mapLeHoi.entrySet()) {
                String keyEntry = leHoiEntry.getKey();
                LeHoi valueEntry = leHoiEntry.getValue();
                SearchKey.result.add(valueEntry);
            }

            // nhap tu khoa
            String search;
            search = NormalizeTool.normalizeKey(key);

            // toan phan
            if (mapLeHoi.containsKey(search)) {
                LeHoi tk = (LeHoi) mapLeHoi.get(search);
                output.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
