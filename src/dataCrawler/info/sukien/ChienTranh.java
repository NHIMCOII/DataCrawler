package dataCrawler.info.sukien;


public class ChienTranh extends SuKien{


	protected String cuocChien;
	protected String dongMinh;
	protected String doiPhuong;
	protected String ketQua;

		
	public ChienTranh() {
		// TODO Auto-generated constructor stub
	}
	public ChienTranh(String ten, String thoiGian, String dienBien, String cuocChien, String dongMinh, String doiPhuong, String ketQua) {
		super(ten, thoiGian, dienBien);
		this.cuocChien = cuocChien;
		this.dongMinh = dongMinh;
		this.doiPhuong = doiPhuong;
		this.ketQua = ketQua;
	}

	
	public String getCuocChien() {
		return cuocChien;
	}
	public String getDongMinh() {
		return dongMinh;
	}
	public String getDoiPhuong() {
		return doiPhuong;
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
		if (v1.dongMinh == null || v1.dongMinh.equals("?")) {
            v1.dongMinh = v2.dongMinh;
        }
		if (v1.doiPhuong == null || v1.doiPhuong.equals("?")) {
            v1.doiPhuong = v2.doiPhuong;
        }
		if (v1.ketQua == null || v1.ketQua.equals("?")) {
            v1.ketQua = v2.ketQua;
        }
		return v1;
	}

}
