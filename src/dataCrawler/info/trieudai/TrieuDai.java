package dataCrawler.info.trieudai;

import java.util.ArrayList;


public class TrieuDai {


	protected String ten;
	protected String thoiKy;
	protected int tuoi;
	protected ArrayList<String> suKien = new ArrayList<>();
	protected ArrayList<String> vua = new ArrayList<>();

	
	public TrieuDai() {
		// TODO Auto-generated constructor stub
	}
	public TrieuDai(String ten, String thoiKy, int tuoi) {
		super();
		this.ten = ten;
		this.thoiKy = thoiKy;
		this.tuoi = tuoi;
	}

	
	public String getTen() {
		return ten;
	}
	public String getThoiKy() {
		return thoiKy;
	}
	public int getTuoi() {
		return tuoi;
	}
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	public ArrayList<String> getVua() {
		return vua;
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
        if (v1.tuoi == 0) {
            v1.tuoi = v2.tuoi;
        }
        return v1;
    }
}
