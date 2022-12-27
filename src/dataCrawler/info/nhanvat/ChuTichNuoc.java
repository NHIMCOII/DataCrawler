package dataCrawler.info.nhanvat;


public class ChuTichNuoc extends NhanVat{
	

	protected String nhiemKy;
	protected String tienNhiem;
	protected String keNhiem;
    protected String phoChuTich;
    
    
    
	public ChuTichNuoc() {
		// TODO Auto-generated constructor stub
	}
	public ChuTichNuoc(String nhiemKy, String tienNhiem, String keNhiem, String phoChuTich) {
		super();
		this.nhiemKy = nhiemKy;
		this.tienNhiem = tienNhiem;
		this.keNhiem = keNhiem;
		this.phoChuTich = phoChuTich;
	}
	
	
	public String getNhiemKy() {
		return nhiemKy;
	}
	public String getTienNhiem() {
		return tienNhiem;
	}
	public String getKeNhiem() {
		return keNhiem;
	}
	public String getPhoChuTich() {
		return phoChuTich;
	}
	
	
	public static ChuTichNuoc mergeRule(Object oldVal, Object newVal) {
		ChuTichNuoc v1 = (ChuTichNuoc) oldVal;
		ChuTichNuoc v2 = (ChuTichNuoc) newVal;
		if (v1.nhiemKy == null || v1.nhiemKy.equals("?")) {
            v1.nhiemKy = v2.nhiemKy;
        }
		if (v1.tienNhiem == null || v1.tienNhiem.equals("?")) {
            v1.tienNhiem = v2.tienNhiem;
        }
		if (v1.keNhiem == null || v1.keNhiem.equals("?")) {
            v1.keNhiem = v2.keNhiem;
        }
		if (v1.phoChuTich == null || v1.phoChuTich.equals("?")) {
            v1.phoChuTich = v2.phoChuTich;
        }
		return v1;
	}
	
}
