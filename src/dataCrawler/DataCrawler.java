package dataCrawler;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataCrawler.links.*;
import info.nhanvat.Vua;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataCrawler {

    public static void main(String[] args) throws IOException, FileNotFoundException, IllegalAccessException {
        final HistoricalCharater_Links hcs = new HistoricalCharater_Links();
        final King_Links kings = new King_Links();
        final President_Links presidents = new President_Links();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 5' to get all links 5*291 links
//		hcs.setLinks(
//				"https://nguoikesu.com/nhan-vat?start=0",
//				"https://nguoikesu.com"
//		);
//		hcs.printList(hcs.getLinks());
//		JSONArray json_hcs = new JSONArray();
//		for(String link : hcs.getLinks()){
//			Map m = new LinkedHashMap();
//			m.put("link",link);
//			json_hcs.add(m);
//		}

        kings.setLinks(
                "https://vi.wikipedia.org/wiki/Vua_Việt_Nam",
                "https://vi.wikipedia.org"
        );
        Map json_vua = Vua.getInfoFromWiki(kings.getLinks());
//		kings.printList(kings.getLinks());
//        JSONArray json_kings = new JSONArray();
//        for (String link : kings.getLinks()) {
//            Map m = new LinkedHashMap();
//            m.put("link", link);
//            json_kings.add(m);
//        }
//
//        presidents.setLinks(
//                "https://vi.wikipedia.org/wiki/Danh_sách_Chủ_tịch_nước_Việt_Nam",
//                "https://vi.wikipedia.org"
//        );
//		presidents.printList(presidents.getLinks());
//        JSONArray json_presidents = new JSONArray();
//        for (String link : presidents.getLinks()) {
//            Map m = new LinkedHashMap();
//            m.put("link", link);
//            json_presidents.add(m);
//        }
//		file.put("Presidents",json_presidents);
//        file.put("Vua", json_vua);
//		file.put("Historical Characters",json_hcs);
        Writer writer = Files.newBufferedWriter(Paths.get("Links.json"));

        // convert book object to JSON file
        gson.toJson(json_vua, writer);

        // close writer
        writer.close();
    }
}


