package dataCrawler.info.sukien;

import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SuKien {
	protected String ten;
	protected String thoiGian;
	protected String dienBien;
	protected ArrayList<String> links;
	protected ArrayList<String> diaDiem;
	protected ArrayList<String> nhanVat;
	
	
	public SuKien() {
		// TODO Auto-generated constructor stub
	}
	public SuKien(String ten, String thoiGian, String dienBien) {
		this.ten = ten;
		this.thoiGian = thoiGian;
		this.dienBien = dienBien;
	}

	public String getTen() {
		return ten;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public String getDienBien() {
		return dienBien;
	}
	public ArrayList<String> getLinks() {
		return links;
	}
	public ArrayList<String> getDiaDiem() {
		return diaDiem;
	}
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}
	
	public static Map getInfo_TVLS(ArrayList<String> urls) throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		for (String url: urls) {
			Document document = Jsoup.connect(url)
					.ignoreContentType(true)
					.timeout(0)
					.get();
			SuKien suKien = new SuKien();
			Elements info = document.getElementsByClass("col-12 col-md-8");

			if (info.size() != 0) {
				Elements headers = document.getElementsByClass("header-edge");
				for (Element header: headers) {
					if (suKien.dienBien == null && header.text().equals(" Diễn biễn lịch sử ")) {
						suKien.dienBien = header.parent().selectFirst("div[class=card-body]").text();
					} else if (header.text().equals("Tài liệu tham khảo")) {
						suKien.links = new ArrayList<>();
						Elements links = header.parents().parents()
								.select("a");
						for (Element link: links) {
							suKien.addLink(link.attr("href"));
						}
					} else if (header.text().equals("Địa điểm liên quan")) {
						Elements links = header.parents().parents()
								.select("div[class=card]");
						if (links.size() != 0) {
							suKien.diaDiem = new ArrayList<>();
						}
						for (Element link: links) {
							int index = link.select("h4[class=card-title]").text().indexOf("(");
							if (index > 0) {
								suKien.addDiaDiem(link.select("h3[class=card-title]")
										.text()
										.substring(0, index));
							} else {
								suKien.addDiaDiem(link.select("h3[class=card-title]").text());
							}
						}
					} else if(header.text().equals("Nhân vật liên quan")) {
						Elements links = header.parents().parents()
								.select("div[class=card]");
						suKien.nhanVat = new ArrayList<>();
						for(Element link: links) {
							int index = link.select("h4[class=card-title]").text().indexOf("(");
							if (index > 0) {
								suKien.addNhanVat(link.select("h4[class=card-title]")
										.text()
										.substring(0, index));
							} else {
								suKien.addNhanVat(link.select("h4[class=card-title]").text());
							}
						}
					} else if (suKien.ten == null && !header.text().equals("")) {
						suKien.ten = header.text();
					}
				}
				m.put(Diadiem_Links.removeAccent(suKien.ten.trim().toLowerCase()), suKien);
			}
		}
		return m;
	}

	public static SuKien mergeRule(Object oldVal, Object newVal) {
		SuKien v1 = (SuKien) oldVal;
		SuKien v2 = (SuKien) newVal;
		if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
		if (v1.thoiGian == null || v1.thoiGian.equals("?")) {
            v1.thoiGian = v2.thoiGian;
        }
        if (v1.dienBien == null || v1.dienBien.equals("?")) {
            v1.dienBien = v2.dienBien;
        }
        return v1;
    }
	
    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }
	public void addDiaDiem(String diadiem) {
        if (diaDiem.contains(diadiem)) {
            return;
        }
        diaDiem.add(diadiem);
    }
	public void addNhanVat(String nhanvat) {
        if (nhanVat.contains(nhanvat)) {
            return;
        }
        nhanVat.add(nhanvat);
    }
}
