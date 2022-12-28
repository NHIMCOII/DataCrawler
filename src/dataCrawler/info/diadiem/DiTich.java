package dataCrawler.info.diadiem;

import java.util.ArrayList;

public class DiTich extends DiaDiem {


	protected String tenDiTich;
	protected String loai;
	protected String nam;

	
	public DiTich() {
		// TODO Auto-generated constructor stub
	}
	public DiTich(String ten, String viTri, String nienDai, String moTa, String dienTich, String vungDem, String toaDo,
			String dienBienLichSu, String tenDiTich, String loai, String nam) {
		super(ten, viTri, nienDai, moTa, dienTich, vungDem, toaDo, dienBienLichSu);
		this.tenDiTich = tenDiTich;
		this.loai = loai;
		this.nam = nam;
	}	
	
	
	public String getTenDiTich() {
		return tenDiTich;
	}
	public String getLoai() {
		return loai;
	}
	public String getNam() {
		return nam;
	}

	
	public static DiTich mergeRule(Object oldVal, Object newVal) {
		DiTich v2 = (DiTich) newVal;
		DiTich v1 = (DiTich) DiaDiem.mergeRule(oldVal, newVal);
		if (v1.tenDiTich == null || v1.tenDiTich.equals("?")) {
            v1.tenDiTich = v2.tenDiTich;
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
