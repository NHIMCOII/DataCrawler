package dataCrawler.info.diadiem;

public class DiSan extends DiaDiem {
	protected String moTa;
	
	public DiSan() {
		// TODO Auto-generated constructor stub
	}	
	public DiSan(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich, String moTa) {
		super(ten, lichSu, khuVuc, namThanhLap, dienTich);
		this.moTa = moTa;
	}

	public String getMoTa() {
		return moTa;
	}

	public static DiSan mergeRule(Object oldVal, Object newVal) {
		DiSan v2 = (DiSan) newVal;
		DiSan v1 = (DiSan) DiaDiem.mergeRule(oldVal, newVal);
		if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
		return v1;
	}
}
