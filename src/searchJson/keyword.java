package app.json.searchJson;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;
import model.nhanvat.NhanVat;
import model.sukien.SuKien;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;
import util.SeperateTool;

public class keyword {

	public static void main(String[] args) {
		ArrayList<Object> result = new ArrayList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String pathThoiKy, pathLeHoi, pathDiaDiem, pathSuKien, pathNhanVat;
		String thoiKy = new File("").getAbsolutePath();
		thoiKy = thoiKy.concat("\\data\\ThoiKy.json");
		String leHoi = new File("").getAbsolutePath();
		leHoi = leHoi.concat("\\data\\LeHoi.json");
		String diaDiem = new File("").getAbsolutePath();
		diaDiem = diaDiem.concat("\\data\\DiaDiem.json");	
		String suKien = new File("").getAbsolutePath();
		suKien = suKien.concat("\\data\\SuKien.json");
		String nhanVat = new File("").getAbsolutePath();
		nhanVat = nhanVat.concat("\\data\\NhanVat.json");
		try {
			pathThoiKy = new String(Files.readAllBytes(Paths.get(thoiKy)));
			Map<String, Object> mapThoiKy = new Gson().fromJson(pathThoiKy,
					new TypeToken<LinkedHashMap<String, ThoiKy>>() {
					}.getType());

			pathLeHoi = new String(Files.readAllBytes(Paths.get(leHoi)));
			Map<String, Object> mapLeHoi = new Gson().fromJson(pathLeHoi, new TypeToken<TreeMap<String, LeHoi>>() {
			}.getType());

			pathDiaDiem = new String(Files.readAllBytes(Paths.get(diaDiem)));
			Map<String, Object> mapDiaDiem = new Gson().fromJson(pathDiaDiem,
					new TypeToken<TreeMap<String, DiaDiem>>() {
					}.getType());

			pathSuKien = new String(Files.readAllBytes(Paths.get(suKien)));
			Map<String, Object> mapSuKien = new Gson().fromJson(pathSuKien, new TypeToken<TreeMap<String, SuKien>>() {
			}.getType());

			pathNhanVat = new String(Files.readAllBytes(Paths.get(nhanVat)));
			Map<String, Object> mapNhanVat = new Gson().fromJson(pathNhanVat,
					new TypeToken<TreeMap<String, NhanVat>>() {
					}.getType());

			String search;
			System.out.println("nhap key:");
			Scanner sc = new Scanner(System.in);
			String key = sc.nextLine();
			if (key.contains("(")) {
				String KeyWithoutQuotation = SeperateTool.separateKeyWithoutQuotation(key);
				search = NormalizeTool.normalizeKey(KeyWithoutQuotation);
			} else {
				search = NormalizeTool.normalizeKey(key);
			}

			// toàn phần
			ToanPhan(mapThoiKy, search, result);
			ToanPhan(mapNhanVat, search, result);
			ToanPhan(mapSuKien, search, result);
			ToanPhan(mapDiaDiem, search, result);
			ToanPhan(mapLeHoi, search, result);

			// 1 phan
			MotPhan(mapNhanVat, search, result);
			MotPhan(mapSuKien, search, result);
			MotPhan(mapDiaDiem, search, result);
			MotPhan(mapLeHoi, search, result);
			MotPhan(mapThoiKy, search, result);

			System.out.println(result.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ToanPhan(Map<String, Object> map, String search, ArrayList<Object> result) {
		for (Entry<String, Object> entry : map.entrySet()) {
			String keyEntry = entry.getKey();
			Object valueEntry = entry.getValue();
			if (map.containsKey(search)) {
				result.add(valueEntry);
			}
		}
	}

	public static void MotPhan(Map<String, Object> map, String search, ArrayList<Object> result) {
		for (Entry<String, Object> entry : map.entrySet()) {
			String keyEntry = entry.getKey();
			Object valueEntry = entry.getValue();
			if (keyEntry.contains(search)) {
				result.add(valueEntry);
			}
		}
	}
}
