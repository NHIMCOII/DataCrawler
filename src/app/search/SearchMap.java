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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SearchMap {
    public static ArrayList<Object> NHAN_VAT;
    public static ArrayList<Object> THOI_KY;
    public static ArrayList<Object> DIA_DIEM;
    public static ArrayList<Object> SU_KIEN;
    public static ArrayList<Object> LE_HOI;
    private static ArrayList<Object> RESULTS;

    public static ArrayList<Object> searchMap(Map<String, Object> m) {
        try {
            RESULTS = new ArrayList<>();
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                Object valueEntry = entry.getValue();
                RESULTS.add(valueEntry);
            }
            return RESULTS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
