package app.json.readJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.lehoi.LeHoi;
import model.nhanvat.ChuTichNuoc;
import model.nhanvat.NhanVat;
import model.nhanvat.Vua;
import model.thoiKy.ThoiKy;
import model.thoiKy.TrieuDai;
import dataCrawler.links.Nhanvat_Links;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.text.Keymap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gson.reflect.TypeToken;

public class readLeHoi {
	public static void main(String[] args) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String leHoi = "C:\\Users\\LENOVO\\eclipse-workspace\\DataCrawler\\src\\data\\LeHoi.json";
		try {
			result = new String(Files.readAllBytes(Paths.get(leHoi)));

			Map<String, Object> mapLeHoi = new Gson().fromJson(result, new TypeToken<TreeMap<String, LeHoi>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
