package app.json.searchJson;

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

public class searchLeHoi {
	public static void main(String[] args) {
		List<LeHoi> output = new ArrayList<>();
		ArrayList<LeHoi> view = new ArrayList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String leHoi = new File("").getAbsolutePath();
		leHoi = leHoi.concat("\\data\\LeHoi.json");
		try {
			result = new String(Files.readAllBytes(Paths.get(leHoi)));

			Map<String, LeHoi> mapLeHoi = new Gson().fromJson(result, new TypeToken<TreeMap<String, LeHoi>>() {
			}.getType());

			// view all
			for (Entry<String, LeHoi> leHoiEntry : mapLeHoi.entrySet()) {
				String keyEntry = leHoiEntry.getKey();
				LeHoi valueEntry = leHoiEntry.getValue();
				view.add(valueEntry);

				System.out.println(valueEntry.getTen() + "\n");
			}

			// nhap tu khoa
			String search;
			System.out.println("nhap key:");
			Scanner sc = new Scanner(System.in);
			String key = sc.nextLine();
			if (key.contains("(")) {
				String KeyWithoutQuotation = SeperateTool.separateKeyWithoutQuotation(key);
				search = NormalizeTool.normalizeKey(KeyWithoutQuotation);
			} else if (key.contains("-")) {
				String KeyWithoutHyphen = SeperateTool.separateKeyWithoutHyphen(key);
				search = NormalizeTool.normalizeKey(KeyWithoutHyphen);
			} else {
				search = NormalizeTool.normalizeKey(key);
			}

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
