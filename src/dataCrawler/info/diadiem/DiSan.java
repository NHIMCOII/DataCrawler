package dataCrawler.info.diadiem;

import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class DiSan extends DiaDiem {
	protected String moTa;
	
	public DiSan() {
		// TODO Auto-generated constructor stub
	}	
	public DiSan(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich, String moTa) {
		super(ten, lichSu, khuVuc, namThanhLap, dienTich);
		this.moTa = moTa;
	}

	public String getMoTa() {
		return moTa;
	}

	public static Map getInfo_Wiki() throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		String url = "https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_di_s%E1%BA%A3n_" +
				"th%E1%BA%BF_gi%E1%BB%9Bi_t%E1%BA%A1i_Vi%E1%BB%87t_Nam";
		Document document = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(0)
				.get();
		Element table = document.selectFirst("table[class=wikitable sortable]");
		Elements infos = table.select("tr");
		for(int i = 1; i <= 8; i++) {
			DiSan diSan = new DiSan();
			Elements infoos = infos.get(i).select("td");
			if(diSan.ten == null && !infoos.get(1).selectFirst("a").text().equals("")) {
				diSan.ten = infoos.get(1).selectFirst("a").text();
			}
			if (diSan.khuVuc == null && !infoos.get(3).selectFirst("a").text().equals("")) {
				diSan.khuVuc = infoos.get(3).selectFirst("span").text();
			}
			if (diSan.namThanhLap == null && infoos.get(4).selectFirst("a") != null) {
				diSan.namThanhLap = infoos.get(4).text();
			}
			if (diSan.moTa == null && !infoos.get(6).selectFirst("a").text().equals("")) {
				diSan.moTa = infoos.get(6).text();
			}
			m.put(Diadiem_Links.removeAccent(diSan.ten.trim().toLowerCase()), diSan);
		}
		return m;
	}

	public static DiSan mergeRule(Object oldVal, Object newVal) {
		DiSan v2 = (DiSan) newVal;
		DiSan v1 = (DiSan) DiaDiem.mergeRule(oldVal, newVal);
		if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
		return v1;
	}
}
