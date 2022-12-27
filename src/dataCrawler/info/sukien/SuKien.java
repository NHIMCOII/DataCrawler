package dataCrawler.info.sukien;

import java.util.ArrayList;

public class SuKien {


	protected String ten;
	protected String dienBien;
	protected ArrayList<String> taiLieuThamKhao = new ArrayList<>();
	protected ArrayList<String> diaDiemLienQuan = new ArrayList<>();
	protected ArrayList<String> nhanVat = new ArrayList<>();

	
	public SuKien() {
		// TODO Auto-generated constructor stub
	}
	public SuKien(String ten, String dienBien) {
		this.ten = ten;
		this.dienBien = dienBien;
	}
	


	public String getTen() {
		return ten;
	}
	public String getDienBien() {
		return dienBien;
	}
	public ArrayList<String> getTaiLieuThamKhao() {
		return taiLieuThamKhao;
	}
	public ArrayList<String> getDiaDiemLienQuan() {
		return diaDiemLienQuan;
	}
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}	

	
	public static SuKien mergeRule(Object oldVal, Object newVal) {
		SuKien v1 = (SuKien) oldVal;
		SuKien v2 = (SuKien) newVal;
		if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.dienBien == null || v1.dienBien.equals("?")) {
            v1.dienBien = v2.dienBien;
        }
        return v1;
    }
}
