package dataCrawler.info.diadiem;

import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	protected ArrayList<String> links = new ArrayList<>();
	protected ArrayList<String> suKien = new ArrayList<>();
	protected ArrayList<String> nhanVat = new ArrayList<>();
	
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
			if(info.size() != 0) {
				Elements headers = doc.getElementsByClass("header-edge");
				for(Element header: headers) {
					if(diadiem.lichSu == null && header.text().equals("Diễn biễn lịch sử ")) {
						diadiem.lichSu = header.parent().parent().select("div[class=card-body]").text();
					}
					if(header.text().equals("Tài liệu tham khảo")) {
						Elements links = header.parent().parent()
								.select("a");
						for(Element link: links) {
							diadiem.addLink(link.attr("href"));
						}
					}
					if(header.text().equals("Sự kiện liên quan")) {
						Elements links = header.parents().parents()
								.select("div[class=card]");
						for(Element link: links) {
							int index = link.select("h4[class=card-title]").text().indexOf("(");
							if (index > 0) {
								diadiem.addSuKien(link.select("h4[class=card-title]")
										.text()
										.substring(0, index));
							} else {
								diadiem.addSuKien(link.select("h4[class=card-title]").text());
							}
						}
					}
					if(header.text().equals("Nhân vật liên quan")) {
						Elements links = header.parents().parents()
								.select("div[class=card]");
						for(Element link: links) {
							int index = link.select("h4[class=card-title]").text().indexOf("(");
							if (index > 0) {
								diadiem.addNhanVat(link.select("h4[class=card-title]")
										.text()
										.substring(0, index));
							} else {
								diadiem.addNhanVat(link.select("h4[class=card-title]").text());
							}
						}
					}
					if(diadiem.ten == null && !header.text().equals("")) {
						diadiem.ten = header.text();
					}
				}
				m.put(diadiem.ten, diadiem);
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
