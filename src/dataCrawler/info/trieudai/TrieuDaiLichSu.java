package dataCrawler.info.trieudai;

import dataCrawler.info.nhanvat.Vua;

public class TrieuDaiLichSu extends Vua {


	protected String thoi_ky;
	protected String ten;
	protected String cac_vi_vua;
	protected String nam_tri_vi;
	protected String su_kien;
	
	
	public TrieuDaiLichSu() {
		// TODO Auto-generated constructor stub
	}
	public TrieuDaiLichSu(String thoi_ky, String ten, String cac_vi_vua, String nam_tri_vi, String su_kien) {
		super();
		this.thoi_ky = thoi_ky;
		this.ten = ten;
		this.cac_vi_vua = cac_vi_vua;
		this.nam_tri_vi = nam_tri_vi;
		this.su_kien = su_kien;
	}

	
	public String getThoi_ky() {
		return thoi_ky;
	}
	public String getTen() {
		return ten;
	}
	public String getCac_vi_vua() {
		return cac_vi_vua;
	}
	public String getNam_tri_vi() {
		return nam_tri_vi;
	}
	public String getSu_kien() {
		return su_kien;
	}	
	
}
