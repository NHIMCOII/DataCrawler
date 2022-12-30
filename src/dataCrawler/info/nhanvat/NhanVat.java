package dataCrawler.info.nhanvat;

//import java.lang.reflect.Array;
import java.util.ArrayList;


public class NhanVat {



	protected String ten;
    protected String tenKhac;		//ten huy
    protected String trieuDai;
    protected String sinh;
    protected String mat;
    protected String anTang;
    protected String chucVu;
    protected String bo;			//than phu
    protected String me;			//than mau
    protected String chong;			//
    protected String vo;			//the thiep
    protected String con;			//hau due
	protected String cuocDoi;
	protected String suNghiep;
	protected ArrayList<String> links = new ArrayList<>();
	protected ArrayList<String> nhanVatCungThoiKy = new ArrayList<>();


    
    public NhanVat() {
    }

    public NhanVat(String ten, String tenKhac, String trieuDai, String sinh, String mat, String anTang, String chucVu,
			String bo, String me, String chong, String vo, String con, String cuocDoi, String suNghiep) {
		this.ten = ten;
		this.tenKhac = tenKhac;
		this.trieuDai = trieuDai;
		this.sinh = sinh;
		this.mat = mat;
		this.anTang = anTang;
		this.chucVu = chucVu;
		this.bo = bo;
		this.me = me;
		this.chong = chong;
		this.vo = vo;
		this.con = con;
		this.cuocDoi = cuocDoi;
		this.suNghiep = suNghiep;
	}
    
    
    public String getTen() {
		return ten;
	}
	public String getTenKhac() {
		return tenKhac;
	}
	public String getTrieuDai() {
		return trieuDai;
	}
	public String getSinh() {
		return sinh;
	}
	public String getMat() {
		return mat;
	}
	public String getAnTang() {
		return anTang;
	}
	public String getChucVu() {
		return chucVu;
	}
	public String getBo() {
		return bo;
	}
	public String getMe() {
		return me;
	}
	public String getChong() {
		return chong;
	}
	public String getVo() {
		return vo;
	}
	public String getCon() {
		return con;
	}
	public String getCuocDoi() {
		return cuocDoi;
	}
	public String getSuNghiep() {
		return suNghiep;
	}
	public ArrayList<String> getLinks() {
		return links;
	}
	public ArrayList<String> getNhanVatCungThoiKy() {
		return nhanVatCungThoiKy;
	}

    
    public static NhanVat mergeRule(Object oldVal, Object newVal) {
        NhanVat v1 = (NhanVat) oldVal;
        NhanVat v2 = (NhanVat) newVal;
        if (v1.tenKhac == null || v1.tenKhac.equals("?")) {
            v1.tenKhac = v2.tenKhac;
        }
        if (v1.trieuDai == null || v1.trieuDai.equals("?")) {
            v1.trieuDai = v2.trieuDai;
        }
        if (v1.sinh == null || v1.sinh.equals("?")) {
            v1.sinh = v2.sinh;
        }
        if (v1.mat == null || v1.mat.equals("?")) {
            v1.mat = v2.mat;
        }
        if (v1.anTang == null || v1.anTang.equals("?")) {
            v1.anTang = v2.anTang;
        }
        if (v1.chucVu == null || v1.chucVu.equals("?")) {
            v1.chucVu = v2.chucVu;
        }
        if (v1.bo == null || v1.bo.equals("?")) {
            v1.bo = v2.bo;
        }
        if (v1.me == null || v1.me.equals("?")) {
            v1.me = v2.me;
        }
        if (v1.chong == null || v1.chong.equals("?")) {
            v1.chong = v2.chong;
        }
        if (v1.vo == null || v1.vo.equals("?")) {
            v1.vo = v2.vo;
        }
        if (v1.con == null || v1.con.equals("?")) {
            v1.con = v2.con;
        }
        if (v1.cuocDoi == null || v1.cuocDoi.equals("?")) {
            v1.cuocDoi = v2.cuocDoi;
        }
        if (v1.suNghiep == null || v1.suNghiep.equals("?")) {
            v1.suNghiep = v2.suNghiep;
        }
        return v1;
    }

    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }
    
    public void addNhanVatCungThoiKy(String nhanvat) {
        if (nhanVatCungThoiKy.contains(nhanvat)) {
            return;
        }
        nhanVatCungThoiKy.add(nhanvat);
    }
}
