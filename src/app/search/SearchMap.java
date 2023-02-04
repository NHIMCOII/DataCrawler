package app.search;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.dia_diem.DiTich;
import model.dia_diem.DiaDiem;
import model.le_hoi.LeHoi;
import model.nhan_vat.NhanVat;
import model.nhan_vat.Vua;
import model.su_kien.ChienTranh;
import model.su_kien.SuKien;
import model.thoi_ky.ThoiKy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchMap {
    public static void searchDiaDiem() {
        String result;
        String diaDiem = new File("").getAbsolutePath();
        diaDiem = diaDiem.concat("\\src\\data\\DiaDiem.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(diaDiem)));
            Map<String, DiTich> mapDiaDiem = new Gson().fromJson(result, new TypeToken<TreeMap<String, DiTich>>() {
            }.getType());

            // view all
            for (Map.Entry<String, DiTich> diaDiemEntry : mapDiaDiem.entrySet()) {
                String keyEntry = diaDiemEntry.getKey();
                DiaDiem valueEntry = diaDiemEntry.getValue();
                SearchKey.result.add(valueEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchLeHoi() {
        String result;
        String leHoi = new File("").getAbsolutePath();
        leHoi = leHoi.concat("\\src\\data\\LeHoi.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(leHoi)));

            Map<String, LeHoi> mapLeHoi = new Gson().fromJson(result, new TypeToken<TreeMap<String, LeHoi>>() {
            }.getType());

            // view all
            for (Map.Entry<String, LeHoi> leHoiEntry : mapLeHoi.entrySet()) {
                String keyEntry = leHoiEntry.getKey();
                LeHoi valueEntry = leHoiEntry.getValue();
                SearchKey.result.add(valueEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchNhanVat() {
        String result;
        String nhanVat = new File("").getAbsolutePath();
        nhanVat = nhanVat.concat("\\src\\data\\NhanVat.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(nhanVat)));

            Map<String, NhanVat> mapNhanVat = new Gson().fromJson(result, new TypeToken<TreeMap<String, Vua>>() {
            }.getType());

            // view all
            for (Map.Entry<String, NhanVat> nhanVatEntry : mapNhanVat.entrySet()) {
                String keyEntry = nhanVatEntry.getKey();
                NhanVat valueEntry = nhanVatEntry.getValue();
                SearchKey.result.add(valueEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchSuKien() {
        String result;
        String suKien = new File("").getAbsolutePath();
        suKien = suKien.concat("\\src\\data\\SuKien.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(suKien)));

            Map<String, SuKien> mapSuKien = new Gson().fromJson(result, new TypeToken<TreeMap<String, ChienTranh>>() {
            }.getType());

            // view all
            for (Map.Entry<String, SuKien> suKienEntry : mapSuKien.entrySet()) {
                String keyEntry = suKienEntry.getKey();
                SuKien valueEntry = suKienEntry.getValue();
                SearchKey.result.add(valueEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchThoiKy() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result;
        String thoiKy = new File("").getAbsolutePath();
        thoiKy = thoiKy.concat("\\src\\data\\ThoiKy.json");
        try {
            result = new String(Files.readAllBytes(Paths.get(thoiKy)));

            Map<String, ThoiKy> mapThoiKy = new Gson().fromJson(result, new TypeToken<LinkedHashMap<String, ThoiKy>>() {
            }.getType());

            // view all
            for (Map.Entry<String, ThoiKy> thoiKyEntry : mapThoiKy.entrySet()) {
                String keyEntry = thoiKyEntry.getKey();
                ThoiKy valueEntry = thoiKyEntry.getValue();
                SearchKey.result.add(valueEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
