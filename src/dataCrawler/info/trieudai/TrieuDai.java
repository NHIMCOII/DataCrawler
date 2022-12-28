package dataCrawler.info.trieudai;

import java.util.ArrayList;


public class TrieuDai {


	protected String ten;
	protected String thoiKy;
	protected String triVi;
	protected ArrayList<String> suKien = new ArrayList<>();
	protected ArrayList<String> viVua = new ArrayList<>();
	protected ArrayList<String> links = new ArrayList<>();

	
	public TrieuDai() {
		// TODO Auto-generated constructor stub
	}
	public TrieuDai(String ten, String thoiKy, String triVi) {
		super();
		this.ten = ten;
		this.thoiKy = thoiKy;
		this.triVi = triVi;
	}

	
	public String getTen() {
		return ten;
	}
	public String getThoiKy() {
		return thoiKy;
	}
	public String getTriVi() {
		return triVi;
	}
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	public ArrayList<String> getViVua() {
		return viVua;
	}
	public ArrayList<String> getLinks() {
		return links;
	}
	
	
	public static TrieuDai mergeRule(Object oldVal, Object newVal) {
		TrieuDai v1 = (TrieuDai) oldVal;
		TrieuDai v2 = (TrieuDai) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.thoiKy == null || v1.thoiKy.equals("?")) {
            v1.thoiKy = v2.thoiKy;
        }
        if (v1.triVi == null || v1.triVi.equals("?")) {
            v1.triVi = v2.triVi;
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
    
    public void addViVua(String vua) {
        if (viVua.contains(vua)) {
            return;
        }
        viVua.add(vua);
    }
}
