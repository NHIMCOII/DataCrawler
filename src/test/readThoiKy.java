package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.thoiKy.ThoiKy;
import model.thoiKy.TrieuDai;
public class readThoiKy {
	public static void main(String[] args) throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String result;
		String nhanvat = "C:\\Users\\LENOVO\\eclipse-workspace\\DataCrawler\\src\\data\\ThoiKy.json";
		try {
			result = new String(Files.readAllBytes(Paths.get(nhanvat)));

			Map<String, Object> map = new Gson().fromJson(result, new TypeToken<LinkedHashMap<String, ThoiKy>>() {
			}.getType());
			
			
			
		
			System.out.println("Nhap thoi ky can tim: ");
			Scanner sc = new Scanner(System.in);
		
			String thoiKy = sc.nextLine();

			if (map.containsKey(thoiKy)) {
				ThoiKy tk = (ThoiKy) map.get(thoiKy);
				System.out.println("Ten: " + tk.getTen());
				System.out.println("Mo ta: " + tk.getMoTa());
				
				
				ArrayList<TrieuDai> jsonA = (ArrayList<TrieuDai>) tk.getTrieuDai();
				System.out.println("Trieu Dai: ");
				int n = jsonA.size();
				
				for(int i=0;i<n;i++) {
					TrieuDai jsonO = (TrieuDai) jsonA.get(i);
					String ten = (String) jsonO.getTen();
					System.out.println("Ten: " + ten);
					String mota = (String) jsonO.getMoTa();
					System.out.println("Mo ta: " + mota);
					System.out.println("Links: " + jsonO.getLinks());
					
				}
				System.out.println("Su kien: " + tk.getSukien());
				System.out.println("links: " + tk.getLinks());
				
			}
			else System.out.println("Khong co ket qua can tim");
		} catch (Exception e) {
			e.printStackTrace();
		}}}
