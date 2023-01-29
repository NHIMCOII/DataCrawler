package app.json.searchJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ComponentInputMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.thoiKy.ThoiKy;
import model.thoiKy.TrieuDai;
import util.NormalizeTool;
import util.SeperateTool;
import app.json.readJson.*;
import java.io.*;

public class searchThoiKy {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String thoiKy = "C:\\Users\\LENOVO\\eclipse-workspace\\DataCrawler\\src\\data\\ThoiKy.json";
		try {
			result = new String(Files.readAllBytes(Paths.get(thoiKy)));

			Map<String, Object> mapThoiKy = new Gson().fromJson(result, new TypeToken<LinkedHashMap<String, ThoiKy>>() {
			}.getType());

			System.out.println("nhap thoi ky can tim: ");
			Scanner sc = new Scanner(System.in);
			String key = sc.nextLine();
			String search = NormalizeTool.normalizeKey(key);
			
			if (mapThoiKy.containsKey(search)) {
				ThoiKy tk = (ThoiKy) mapThoiKy.get(search);
				tk.output();
			} else
				System.out.println("Khong co ket qua can tim");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
