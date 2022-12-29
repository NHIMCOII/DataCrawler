package dataCrawler.info.diadiem;

public class DiSan extends DiaDiem {


	protected String diSan;
	protected String viTri;
	protected String nienDai;
	protected String moTa;
	
	
	public DiSan() {
		// TODO Auto-generated constructor stub
	}	
	public DiSan(String ten, String dienBienLichSu, String khuVuc, String namThanhLap, String dienTich, String diSan, String viTri, String nienDai, String moTa) {
		super(ten, dienBienLichSu, khuVuc, namThanhLap, dienTich);
		this.diSan = diSan;
		this.viTri = viTri;
		this.nienDai = nienDai;
		this.moTa = moTa;
	}
	
	
	public String getDiSan() {
		return diSan;
	}
	public String getViTri() {
		return viTri;
	}
	public String getNienDai() {
		return nienDai;
	}
	public String getMoTa() {
		return moTa;
	}
	
	
	public static DiSan mergeRule(Object oldVal, Object newVal) {
		DiSan v2 = (DiSan) newVal;
		DiSan v1 = (DiSan) DiaDiem.mergeRule(oldVal, newVal);
		if (v1.diSan == null || v1.diSan.equals("?")) {
            v1.diSan = v2.diSan;
        }
		if (v1.viTri == null || v1.viTri.equals("?")) {
            v1.viTri = v2.viTri;
        }
		if (v1.nienDai == null || v1.nienDai.equals("?")) {
            v1.nienDai = v2.nienDai;
        }
		if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
		return v1;
	}

	
}
