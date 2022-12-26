package dataCrawler.info.diadiem;

import java.util.ArrayList;

public class DiaDiem {


	protected String ten;
	protected String vi_tri;
	protected String nien_dai;
	protected String mo_ta;
	protected String dien_tich;
	protected String vung_dem;
	protected String toa_do;
	protected String dien_bien_lich_su;
	protected String tai_lieu_tham_khao;
	protected ArrayList<String> su_kien = new ArrayList<>();
	
	
	public DiaDiem() {
		// TODO Auto-generated constructor stub
	}
	
	public DiaDiem(String ten, String vi_tri, String nien_dai, String mo_ta, String dien_tich, String vung_dem,
			String toa_do, String dien_bien_lich_su, String tai_lieu_tham_khao, ArrayList<String> su_kien) {
		super();
		this.ten = ten;
		this.vi_tri = vi_tri;
		this.nien_dai = nien_dai;
		this.mo_ta = mo_ta;
		this.dien_tich = dien_tich;
		this.vung_dem = vung_dem;
		this.toa_do = toa_do;
		this.dien_bien_lich_su = dien_bien_lich_su;
		this.tai_lieu_tham_khao = tai_lieu_tham_khao;
		this.su_kien = su_kien;
	}
	
	
	public String getTen() {
		return ten;
	}
	public String getVi_tri() {
		return vi_tri;
	}
	public String getNien_dai() {
		return nien_dai;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public String getDien_tich() {
		return dien_tich;
	}
	public String getVung_dem() {
		return vung_dem;
	}
	public String getToa_do() {
		return toa_do;
	}
	public String getDien_bien_lich_su() {
		return dien_bien_lich_su;
	}
	public String getTai_lieu_tham_khao() {
		return tai_lieu_tham_khao;
	}
	public ArrayList<String> getSu_kien() {
		return su_kien;
	}
}
