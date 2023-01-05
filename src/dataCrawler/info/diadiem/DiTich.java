package dataCrawler.info.diadiem;


import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class DiTich extends DiaDiem {
	protected String viTri;
	protected String loai;
	protected String namCongNhan;


	public DiTich() {
		// TODO Auto-generated constructor stub
	}
	public DiTich(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich, String viTri, String loai,
				  String namCongNhan) {
		super(ten, lichSu, khuVuc, namThanhLap, dienTich);
		this.viTri = viTri;
		this.loai = loai;
		this.namCongNhan = namCongNhan;
	}

	public String getViTri() {
		return viTri;
	}
	public String getLoai() {
		return loai;
	}
	public String getNamCongNhan() {
		return namCongNhan;
	}

	public static Map getInfo_Wiki() throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		String url = "https://vi.m.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam";
		Document document = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(0)
				.get();
		Elements khuVuc = document.select("h3").select("span[class=mw-headline]");
		Elements tables = document.select("table[class=wikitable sortable]");
		for (int i = 0; i < khuVuc.size(); i++) {
			String khuVucTen = khuVuc.get(i).text();
			Element tbody = tables.get(i).selectFirst("tbody");
			Elements infos = tbody.select("tr");
			for(int j = 0; j < infos.size(); j++) {
				DiTich diTich = new DiTich();
				Elements infoos = infos.get(j).select("td");
				if(infoos.size() > 0) {
					if(diTich.ten == null && infoos.get(0) != null) {
						diTich.ten = infoos.get(0).text();
					} else if(diTich.viTri == null && infoos.get(1) != null) {
						diTich.viTri = infos.get(1).select("td").get(1).text();
					} else if(diTich.loai == null && infoos.get(2) != null) {
						diTich.loai = infoos.get(2).text();
					} else if(diTich.namCongNhan == null && infoos.get(3) != null) {
						diTich.namCongNhan = infoos.get(3).text();
					}
					diTich.khuVuc = khuVucTen;
					m.put(Diadiem_Links.removeAccent(diTich.ten.trim().toLowerCase()), diTich);
				}
			}
		}
		return m;
	}
	
	public static DiTich mergeRule(Object oldVal, Object newVal) {
		DiTich v2 = (DiTich) newVal;
		DiTich v1 = (DiTich) DiaDiem.mergeRule(oldVal, newVal);
		if (v1.viTri == null || v1.viTri.equals("?")) {
            v1.viTri = v2.viTri;
        }
		if (v1.loai == null || v1.loai.equals("?")) {
            v1.loai = v2.loai;
        }
		if (v1.namCongNhan == null || v1.namCongNhan.equals("?")) {
            v1.namCongNhan = v2.namCongNhan;
        }
		return v1;
	}


}
