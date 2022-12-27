package dataCrawler.info.diadiem;


public class DiTich extends DiaDiem {

	protected String ten;
	protected String loai;
	protected String nam;
	
	
	public DiTich() {
		// TODO Auto-generated constructor stub
	}
	public DiTich(String ten, String loai, String nam) {
		super();
		this.ten = ten;
		this.loai = loai;
		this.nam = nam;
	}	
	
	
	public String getTen() {
		return ten;
	}
	public String getLoai() {
		return loai;
	}
	public String getNam() {
		return nam;
	}


	public static DiTich mergeRule(Object oldVal, Object newVal) {
		DiTich v1 = (DiTich) oldVal;
		DiTich v2 = (DiTich) newVal;
		if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
		if (v1.loai == null || v1.loai.equals("?")) {
            v1.loai = v2.loai;
        }
		if (v1.nam == null || v1.nam.equals("?")) {
            v1.nam = v2.nam;
        }
		return v1;
	}
}
