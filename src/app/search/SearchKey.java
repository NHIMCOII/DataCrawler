package app.search;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import app.Main;

import util.NormalizeTool;

public class SearchKey {
    private static ArrayList<Object> RESULTS;

    public static ArrayList<Object> search(String key) {
        RESULTS = new ArrayList<>();
        String search;
        search = NormalizeTool.normalizeKey(key);

        // toàn phần
        toanPhan(Main.mapThoiKy, search);
        toanPhan(Main.mapNhanVat, search);
        toanPhan(Main.mapSuKien, search);
        toanPhan(Main.mapDiaDiem, search);
        toanPhan(Main.mapLeHoi, search);

        // 1 phan
        motPhan(Main.mapNhanVat, search);
        motPhan(Main.mapSuKien, search);
        motPhan(Main.mapDiaDiem, search);
        motPhan(Main.mapLeHoi, search);
        motPhan(Main.mapThoiKy, search);
        return RESULTS;
    }

    public static Object toanPhan(Map<String, Object> map, String search) {
        if (map.containsKey(search)) {
            RESULTS.add(map.get(search));
            return map.get(search);
        }
        return null;
    }

    public static void motPhan(Map<String, Object> map, String search) {
        for (Entry<String, Object> entry : map.entrySet()) {
            String keyEntry = entry.getKey();
            Object valueEntry = entry.getValue();
            if (keyEntry.contains(search) && !RESULTS.contains(valueEntry)) {
                RESULTS.add(valueEntry);
            }
        }
    }
}