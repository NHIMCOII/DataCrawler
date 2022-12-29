package dataCrawler.info.diadiem;

import java.util.ArrayList;


public class DiaDiem {


	protected String ten;
	protected String dienBienLichSu;
	protected String khuVuc;
	protected String namThanhLap;
	protected String dienTich;
	protected ArrayList<String> links = new ArrayList<>();
	protected ArrayList<String> suKien = new ArrayList<>();
	protected ArrayList<String> nhanVat = new ArrayList<>();
	
	
	public DiaDiem() {
		// TODO Auto-generated constructor stub
	}
	public DiaDiem(String ten, String dienBienLichSu, String khuVuc, String namThanhLap, String dienTich) {
		this.ten = ten;
		this.dienBienLichSu = dienBienLichSu;
		this.khuVuc = khuVuc;
		this.namThanhLap = namThanhLap;
		this.dienTich = dienTich;
	}
	
	
	public String getTen() {
		return ten;
	}
	public String getDienBienLichSu() {
		return dienBienLichSu;
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
	
	
	
	public static DiaDiem mergeRule(Object oldVal, Object newVal) {
		DiaDiem v1 = (DiaDiem) oldVal;
		DiaDiem v2 = (DiaDiem) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.dienBienLichSu == null || v1.dienBienLichSu.equals("?")) {
            v1.dienBienLichSu = v2.dienBienLichSu;
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
