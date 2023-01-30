package app.json.searchJson;

import java.io.File;
import java.nio.file.Files;
import util.SeperateTool;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.diadiem.DiaDiem;
import model.nhanvat.NhanVat;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;

public class searchDiaDiem {

	public static void main(String[] args) {
		List<DiaDiem> output = new ArrayList<>();
		ArrayList<DiaDiem> view = new ArrayList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String diaDiem = new File("").getAbsolutePath();
		diaDiem = diaDiem.concat("\\data\\DiaDiem.json");		try {
			result = new String(Files.readAllBytes(Paths.get(diaDiem)));

			Map<String, DiaDiem> mapDiaDiem = new Gson().fromJson(result, new TypeToken<TreeMap<String, DiaDiem>>() {
			}.getType());

			// view all
			for (Entry<String, DiaDiem> diaDiemEntry : mapDiaDiem.entrySet()) {
				String keyEntry = diaDiemEntry.getKey();
				DiaDiem valueEntry = diaDiemEntry.getValue();
				view.add(valueEntry);

				System.out.println(valueEntry.getTen() + "\n");
			}

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

			// tìm kiếm toàn phần
			if (mapDiaDiem.containsKey(search)) {
				DiaDiem tk = (DiaDiem) mapDiaDiem.get(search);
				output.add(tk);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
