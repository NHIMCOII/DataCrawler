package dataCrawler.info.diadiem;


import java.util.Map;
import java.util.TreeMap;

public class DiTich extends DiaDiem {
	protected String viTri;
	protected String loai;
	protected String namCongNhan;


	public DiTich() {
		// TODO Auto-generated constructor stub
	}
	public DiTich(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich, String viTri, String loai,
				  String namCongNhan) {
		super(ten, lichSu, khuVuc, namThanhLap, dienTich);
		this.viTri = viTri;
		this.loai = loai;
		this.namCongNhan = namCongNhan;
	}

	public String getViTri() {
		return viTri;
	}
	public String getLoai() {
		return loai;
	}
	public String getNamCongNhan() {
		return namCongNhan;
	}

	public static Map getInfo_Wiki() {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		String url = "https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_di_s%E1%BA%A3n_" +
				"th%E1%BA%BF_gi%E1%BB%9Bi_t%E1%BA%A1i_Vi%E1%BB%87t_Nam";
		return m;
	}
	
	public static DiTich mergeRule(Object oldVal, Object newVal) {
		DiTich v2 = (DiTich) newVal;
		DiTich v1 = (DiTich) DiaDiem.mergeRule(oldVal, newVal);
		if (v1.viTri == null || v1.viTri.equals("?")) {
            v1.viTri = v2.viTri;
        }
		if (v1.loai == null || v1.loai.equals("?")) {
            v1.loai = v2.loai;
        }
		if (v1.namCongNhan == null || v1.namCongNhan.equals("?")) {
            v1.namCongNhan = v2.namCongNhan;
        }
		return v1;
	}


}
