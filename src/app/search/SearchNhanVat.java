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
import model.nhanvat.Vua;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;
import util.SeperateTool;

public class SearchNhanVat {
    public static List<NhanVat> output = new ArrayList<>();
    public static ArrayList<NhanVat> view = new ArrayList<>();

    public static void search(String key) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result;
        String nhanVat = new File("").getAbsolutePath();
        nhanVat = nhanVat.concat("\\src\\data\\NhanVat.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(nhanVat)));

            Map<String, NhanVat> mapNhanVat = new Gson().fromJson(result, new TypeToken<TreeMap<String, Vua>>() {
            }.getType());

            // view all
            for (Entry<String, NhanVat> nhanVatEntry : mapNhanVat.entrySet()) {
                String keyEntry = nhanVatEntry.getKey();
                NhanVat valueEntry = nhanVatEntry.getValue();
                SearchKey.result.add(valueEntry);
            }

            // nhap tu khoa
            String search;
            search = NormalizeTool.normalizeKey(key);

            // toan phan
            if (mapNhanVat.containsKey(search)) {
                NhanVat tk = (NhanVat) mapNhanVat.get(search);
                output.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
