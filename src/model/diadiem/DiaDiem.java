package model.diadiem;

import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class DiaDiem {
	protected String ten;
	protected String lichSu;
	protected String khuVuc;
	protected String namThanhLap;
	protected String dienTich;
	protected ArrayList<String> links;
	protected ArrayList<String> suKien;
	protected ArrayList<String> nhanVat;
	
	public DiaDiem() {
		// TODO Auto-generated constructor stub
	}
	public DiaDiem(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich) {
		this.ten = ten;
		this.lichSu = lichSu;
		this.khuVuc = khuVuc;
		this.namThanhLap = namThanhLap;
		this.dienTich = dienTich;
	}

	public String getTen() {
		return ten;
	}
	public String getLichSu() {
		return lichSu;
	}
	public String getKhuVuc() {
		return khuVuc;
	}
	public String getNamThanhLap() {
		return namThanhLap;
	}
	public String getDienTich() {
		return dienTich;
	}
	public ArrayList<String> getLinks() {
		return links;
	}
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}

	public static Map getInfo_TVLS(ArrayList<String> urls) throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		for (String url : urls) {
			final Document doc = Jsoup.connect(url)
					.ignoreContentType(true)
					.timeout(0)
					.get();
			DiaDiem diadiem = new DiaDiem();
			Elements info = doc.select("div[class=col-12 col-md-8]");
			Element lichSuTag = info.select("div[class=divide-tag]").get(1);

			if(info.size() != 0) {
				Elements headers = doc.getElementsByClass("header-edge");
				diadiem.lichSu = lichSuTag.selectFirst("div[class=card-body]").text();
				for(Element header: headers) {
					if(header.text().equals("Tài liệu tham khảo")) {
						diadiem.links = new ArrayList<>();
						Elements links = header.parent().parent()
								.select("a");
						for(Element link: links) {
							diadiem.addLink(link.attr("href"));
						}
					}
					if(header.text().equals("Sự kiện liên quan")) {
						Elements links = header.parents().nextAll("div[class=card]");
						if (links.size() != 0) {
							diadiem.suKien = new ArrayList<>();
						}
						for(Element link: links) {
							diadiem.addSuKien(Tool.separateKeyWithoutQuotation(
									link.select("h4[class=card-title]").text())
							);
						}
					}
					if(header.text().equals("Nhân vật liên quan")) {
						Elements links = header.parents().nextAll("div[class=card]");
						diadiem.nhanVat = new ArrayList<>();
						for(Element link: links) {
							diadiem.addNhanVat(Tool.separateKeyWithoutQuotation(
									link.select("h4[class=card-title]").text())
							);

						}
					}
					if(diadiem.ten == null && !header.text().equals("")) {
						diadiem.ten = header.text();
					}
				}
				m.put(Tool.normalizeKey(diadiem.ten), diadiem);
			}
		}
		return m;
	}

	public static Map getInfo_Wiki() throws IOException {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		String url = "https://vi.wikipedia.org/wiki/T%E1%BB%89nh_th%C3%A0nh_Vi%E1%BB%87t_Nam";
		Document document = Jsoup.connect(url)
				.ignoreContentType(true)
				.timeout(0)
				.get();
		Element table = document.selectFirst("table[class=wikitable sortable mw-collapsible]");
		if (table != null) {
			Elements trs = table.select("tbody tr");
			for (int i = 1; i <= 63; i++) {
				if (trs.get(i) == null) {
					continue;
				}
				DiaDiem diadiem = new DiaDiem();
				Elements tds = trs.get(i).select("td");
				if (diadiem.ten == null && tds.get(1) != null) {
					diadiem.ten = tds.get(1).select("center").text();
				}
				if (diadiem.ten == null && tds.get(3) != null) {
					if (tds.get(3).selectFirst("a") != null) {
						diadiem.khuVuc = tds.get(3).selectFirst("a").text();
					} else {
						diadiem.khuVuc = tds.get(3).text();
					}
				}
				if (diadiem.namThanhLap == null && tds.get(4) != null) {
					diadiem.namThanhLap = tds.get(4).select("center").text();
				}
				if (diadiem.dienTich == null && tds.get(6) != null) {
					diadiem.dienTich = tds.get(6).select("center").text().replace(".", "");
				}
				m.put(Tool.normalizeKey(diadiem.ten), diadiem);
			}
		}
		return m;
	}
	
	public static DiaDiem mergeRule(Object oldVal, Object newVal) {
		DiaDiem v1 = (DiaDiem) oldVal;
		DiaDiem v2 = (DiaDiem) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.lichSu == null || v1.lichSu.equals("?")) {
            v1.lichSu = v2.lichSu;
        }
        if (v1.khuVuc == null || v1.khuVuc.equals("?")) {
            v1.khuVuc = v2.khuVuc;
        }
        if (v1.namThanhLap == null || v1.namThanhLap.equals("?")) {
            v1.namThanhLap = v2.namThanhLap;
        }
        if (v1.dienTich == null || v1.dienTich.equals("?")) {
            v1.dienTich = v2.dienTich;
        }
        return v1;
    }
	
	
    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }
	public void addSuKien(String sukien) {
        if (suKien.contains(sukien)) {
            return;
        }
        suKien.add(sukien);
    }
	public void addNhanVat(String nhanvat) {
        if (nhanVat.contains(nhanvat)) {
            return;
        }
        nhanVat.add(nhanvat);
    }
}
