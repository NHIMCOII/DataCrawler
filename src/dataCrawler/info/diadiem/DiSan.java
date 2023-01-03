package dataCrawler.info.diadiem;

import java.util.Map;
import java.util.TreeMap;

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

	public static Map getInfo_Wiki() {
		System.setProperty("http.proxyhost", "127.0.0.1");
		System.setProperty("http.proxyport", "8080");
		Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

		String url = "https://vi.m.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam";
		return m;
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
