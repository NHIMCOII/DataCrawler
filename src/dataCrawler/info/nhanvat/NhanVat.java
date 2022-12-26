package dataCrawler.info.nhanvat;

//import java.lang.reflect.Array;
import java.util.ArrayList;


public class NhanVat {


	protected String ten;
    protected String ten_khac;		//ten huy
    protected String trieu_dai;
    protected String sinh;
    protected String mat;
    protected String an_tang;
    protected String chuc_vu;
    protected String bo;			//than phu
    protected String me;			//than mau
    protected String chong;			//
    protected String vo;			//the thiep
    protected String con;			//hau due
    protected ArrayList<String> links = new ArrayList<>();


    
    public NhanVat() {
    }

    public NhanVat(String ten, String ten_khac, String trieu_dai, String sinh, String mat, String an_tang,
			String chuc_vu, String bo, String me, String chong, String vo, String con) {
		this.ten = ten;
		this.ten_khac = ten_khac;
		this.trieu_dai = trieu_dai;
		this.sinh = sinh;
		this.mat = mat;
		this.an_tang = an_tang;
		this.chuc_vu = chuc_vu;
		this.bo = bo;
		this.me = me;
		this.chong = chong;
		this.vo = vo;
		this.con = con;
	}

    
    
    public static NhanVat mergeRule(Object oldVal, Object newVal) {
        NhanVat v1 = (NhanVat) oldVal;
        NhanVat v2 = (NhanVat) newVal;
        if (v1.ten_khac == null || v1.ten_khac.equals("?")) {
            v1.ten_khac = v2.ten_khac;
        }
        if (v1.trieu_dai == null || v1.trieu_dai.equals("?")) {
            v1.trieu_dai = v2.trieu_dai;
        }
        if (v1.sinh == null || v1.sinh.equals("?")) {
            v1.sinh = v2.sinh;
        }
        if (v1.mat == null || v1.mat.equals("?")) {
            v1.mat = v2.mat;
        }
        if (v1.an_tang == null || v1.an_tang.equals("?")) {
            v1.an_tang = v2.an_tang;
        }
        if (v1.chuc_vu == null || v1.chuc_vu.equals("?")) {
            v1.chuc_vu = v2.chuc_vu;
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
        return v1;
    }

    
    public String getTen() {
		return ten;
	}
	public String getTen_khac() {
		return ten_khac;
	}
	public String getTrieu_dai() {
		return trieu_dai;
	}
	public String getSinh() {
		return sinh;
	}
	public String getMat() {
		return mat;
	}
	public String getChuc_vu() {
		return chuc_vu;
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
    
    public ArrayList<String> getLinks() {
        return links;
    }

    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }


}
