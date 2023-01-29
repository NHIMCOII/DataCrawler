package app.json.searchJson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.diadiem.DiaDiem;
import model.lehoi.LeHoi;
import model.thoiKy.ThoiKy;
import util.NormalizeTool;

public class searchLeHoi {
	public static void main(String[] args) {
		System.out.println("nhap le hoi muon tim: ");
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		String search = NormalizeTool.normalizeKey(key);
		System.out.println(search);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String leHoi = "C:\\Users\\LENOVO\\eclipse-workspace\\DataCrawler\\src\\data\\LeHoi.json";
		try {
			result = new String(Files.readAllBytes(Paths.get(leHoi)));

			Map<String, Object> mapLeHoi = new Gson().fromJson(result, new TypeToken<TreeMap<String, LeHoi>>() {
			}.getType());
			
			if (mapLeHoi.containsKey(search)) {
				LeHoi tk = (LeHoi) mapLeHoi.get(search);
				tk.output();
			} else
				System.out.println("Khong co ket qua can tim");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
