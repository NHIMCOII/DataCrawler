package dataCrawler.info.diadiem;

import java.util.ArrayList;


public class DiaDiem {


	protected String ten;
	protected String viTri;
	protected String nienDai;
	protected String moTa;
	protected String dienTich;
	protected String vungDem;
	protected String toaDo;
	protected String dienBienLichSu;
	protected ArrayList<String> taiLieuThamKhao = new ArrayList<>();
	protected ArrayList<String> suKien = new ArrayList<>();
	
	
	public DiaDiem() {
		// TODO Auto-generated constructor stub
	}
	
	public DiaDiem(String ten, String viTri, String nienDai, String moTa, String dienTich, String vungDem, String toaDo,
			String dienBienLichSu) {
		this.ten = ten;
		this.viTri = viTri;
		this.nienDai = nienDai;
		this.moTa = moTa;
		this.dienTich = dienTich;
		this.vungDem = vungDem;
		this.toaDo = toaDo;
		this.dienBienLichSu = dienBienLichSu;
	}
	
	
	
	public String getTen() {
		return ten;
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
	public String getDienTich() {
		return dienTich;
	}
	public String getVungDem() {
		return vungDem;
	}
	public String getToaDo() {
		return toaDo;
	}
	public String getDienBienLichSu() {
		return dienBienLichSu;
	}
	public ArrayList<String> getTaiLieuThamKhao() {
		return taiLieuThamKhao;
	}
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	
	
	public static DiaDiem mergeRule(Object oldVal, Object newVal) {
		DiaDiem v1 = (DiaDiem) oldVal;
		DiaDiem v2 = (DiaDiem) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
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
        if (v1.dienTich == null || v1.dienTich.equals("?")) {
            v1.dienTich = v2.dienTich;
        }
        if (v1.vungDem == null || v1.vungDem.equals("?")) {
            v1.vungDem = v2.vungDem;
        }
        if (v1.toaDo == null || v1.toaDo.equals("?")) {
            v1.toaDo = v2.toaDo;
        }
        if (v1.dienBienLichSu == null || v1.dienBienLichSu.equals("?")) {
            v1.dienBienLichSu = v2.dienBienLichSu;
        }
        return v1;
    }
}
