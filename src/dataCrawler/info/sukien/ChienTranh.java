package dataCrawler.info.sukien;

import dataCrawler.info.nhanvat.ChuTichNuoc;

public class ChienTranh {


	protected String ten;
	protected String thoiGian;
	protected String diaDiem;
	protected String ketQua;
	
		
	public ChienTranh() {
		// TODO Auto-generated constructor stub
	}
	public ChienTranh(String ten, String thoiGian, String diaDiem, String ketQua) {
		super();
		this.ten = ten;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
		this.ketQua = ketQua;
	}


	public String getTen() {
		return ten;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public String getKetQua() {
		return ketQua;
	}


	public static ChienTranh mergeRule(Object oldVal, Object newVal) {
		ChienTranh v1 = (ChienTranh) oldVal;
		ChienTranh v2 = (ChienTranh) newVal;
		if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
		if (v1.thoiGian == null || v1.thoiGian.equals("?")) {
            v1.ten = v2.ten;
        }
		if (v1.diaDiem == null || v1.diaDiem.equals("?")) {
            v1.diaDiem = v2.diaDiem;
        }
		if (v1.ketQua == null || v1.ketQua.equals("?")) {
            v1.ketQua = v2.ketQua;
        }
		return v1;
	}
}
