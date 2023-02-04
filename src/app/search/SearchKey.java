package app.search;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import app.Main;

import util.NormalizeTool;

public class SearchKey {
    public static ArrayList<Object> result = new ArrayList<>();
    public static Object object = new Object();

    public static void search(String key) {

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
        System.out.println(result.size());

    }


    public static Object searchForValue(Map<String, Object> map, String search) {
        return map.get(search);
    }

    public static void toanPhan(Map<String, Object> map, String search) {
        if (map.containsKey(search)) {
            result.add(map.get(search));
            object = map.get(search);
        }
    }

    public static void motPhan(Map<String, Object> map, String search) {
        for (Entry<String, Object> entry : map.entrySet()) {
            String keyEntry = entry.getKey();
            Object valueEntry = entry.getValue();
            if (keyEntry.contains(search) && !result.contains(valueEntry)) {
                result.add(valueEntry);
            }
        }
    }
}