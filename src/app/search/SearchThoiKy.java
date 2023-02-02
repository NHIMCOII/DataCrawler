package app.search;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.swing.ComponentInputMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.nhanvat.NhanVat;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;
import model.thoiKy.TrieuDai;
import util.NormalizeTool;
import util.SeperateTool;
import java.io.*;

public class SearchThoiKy {
    public static List<ThoiKy> output = new ArrayList<>();
    public static ArrayList<ThoiKy> view = new ArrayList<>();
    public static void search(String key) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result;
        String thoiKy = new File("").getAbsolutePath();
        thoiKy = thoiKy.concat("\\src\\data\\ThoiKy.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(thoiKy)));

            Map<String, ThoiKy> mapThoiKy = new Gson().fromJson(result, new TypeToken<LinkedHashMap<String, ThoiKy>>() {
            }.getType());

            // view all
            for (Entry<String, ThoiKy> thoiKyEntry : mapThoiKy.entrySet()) {
                String keyEntry = thoiKyEntry.getKey();
                ThoiKy valueEntry = thoiKyEntry.getValue();
                SearchKey.result.add(valueEntry);
            }

            // nhap khoa
            String search;
            search = NormalizeTool.normalizeKey(key);
            // toan phan
            if (mapThoiKy.containsKey(search)) {
                ThoiKy tk = (ThoiKy) mapThoiKy.get(search);
                output.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
