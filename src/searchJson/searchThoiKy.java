package app.json.searchJson;

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
import app.json.readJson.*;
import java.io.*;

public class searchThoiKy {
	public static void main(String[] args) {
		List<ThoiKy> output = new ArrayList<>();
		ArrayList<ThoiKy> view = new ArrayList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String thoiKy = new File("").getAbsolutePath();
		thoiKy = thoiKy.concat("\\data\\ThoiKy.json");		try {
			result = new String(Files.readAllBytes(Paths.get(thoiKy)));

			Map<String, ThoiKy> mapThoiKy = new Gson().fromJson(result, new TypeToken<LinkedHashMap<String, ThoiKy>>() {
			}.getType());

			// view all
			for (Entry<String, ThoiKy> thoiKyEntry : mapThoiKy.entrySet()) {
				String keyEntry = thoiKyEntry.getKey();
				ThoiKy valueEntry = thoiKyEntry.getValue();
				view.add(valueEntry);

				System.out.println(valueEntry.getTen() + "\n");
			}

			// nhap khoa
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
			if (mapThoiKy.containsKey(search)) {
				ThoiKy tk = (ThoiKy) mapThoiKy.get(search);
				tk.output();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
