package dataCrawler.info.nhanvat;

import java.util.ArrayList;

public class ChuTichNuoc extends NhanVat{
	

	protected String nhiem_ky;
	protected String tien_nhiem;
	protected String ke_nhiem;
    protected String pho_chu_tich;
    
    
    
	public ChuTichNuoc() {
		// TODO Auto-generated constructor stub
	}
	
	public ChuTichNuoc(String nhiem_ky, String tien_nhiem, String ke_nhiem, String pho_chu_tich) {
		super();
		this.nhiem_ky = nhiem_ky;
		this.tien_nhiem = tien_nhiem;
		this.ke_nhiem = ke_nhiem;
		this.pho_chu_tich = pho_chu_tich;
	}
	
	

	public String getNhiem_ky() {
		return nhiem_ky;
	}
	public String getTien_nhiem() {
		return tien_nhiem;
	}
	public String getKe_nhiem() {
		return ke_nhiem;
	}
	public String getPho_chu_tich() {
		return pho_chu_tich;
	}
	
	
	public static ChuTichNuoc mergeRule(Object oldVal, Object newVal) {
		ChuTichNuoc v1 = (ChuTichNuoc) oldVal;
		ChuTichNuoc v2 = (ChuTichNuoc) newVal;
		if (v1.nhiem_ky == null || v1.nhiem_ky.equals("?")) {
            v1.nhiem_ky = v2.nhiem_ky;
        }
		if (v1.tien_nhiem == null || v1.tien_nhiem.equals("?")) {
            v1.tien_nhiem = v2.tien_nhiem;
        }
		if (v1.ke_nhiem == null || v1.ke_nhiem.equals("?")) {
            v1.ke_nhiem = v2.ke_nhiem;
        }
		if (v1.pho_chu_tich == null || v1.pho_chu_tich.equals("?")) {
            v1.pho_chu_tich = v2.pho_chu_tich;
        }
		return v1;
	}
	
}
