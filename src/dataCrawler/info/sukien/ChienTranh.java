package dataCrawler.info.sukien;

import java.util.ArrayList;

public class ChienTranh extends SuKien{


	protected String cuocChien;
	protected String thoiGian;
	protected String diaDiem;
	protected String ketQua;

		
	public ChienTranh() {
		// TODO Auto-generated constructor stub
	}
	public ChienTranh(String ten, String dienBien, String cuocChien, String thoiGian, String diaDiem, String ketQua) {
		super(ten, dienBien);
		this.cuocChien = cuocChien;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
		this.ketQua = ketQua;
	}


	public String getCuocChien() {
		return cuocChien;
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
		ChienTranh v2 = (ChienTranh) newVal;
		ChienTranh v1 = (ChienTranh) SuKien.mergeRule(oldVal, newVal);
		if (v1.cuocChien == null || v1.ten.equals("?")) {
            v1.cuocChien = v2.cuocChien;
        }
		if (v1.thoiGian == null || v1.thoiGian.equals("?")) {
            v1.thoiGian = v2.thoiGian;
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
