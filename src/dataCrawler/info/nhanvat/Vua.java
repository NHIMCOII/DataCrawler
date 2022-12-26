package dataCrawler.info.nhanvat;

/*import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;*/


public class Vua extends NhanVat {
    
	
	protected String tri_vi; //tai_vi
	protected String tien_nhiem;
	protected String ke_nhiem;
	protected String nien_hieu;
	protected String ton_hieu;
	protected String thuy_hieu;
	protected String mieu_hieu;
	protected String tuoc_hieu;

    
	public Vua() {
        super();
    }
	public Vua(String tri_vi, String tien_nhiem, String ke_nhiem, String nien_hieu, String ton_hieu, String thuy_hieu,
			String mieu_hieu, String tuoc_hieu) {
		super();
		this.tri_vi = tri_vi;
		this.tien_nhiem = tien_nhiem;
		this.ke_nhiem = ke_nhiem;
		this.nien_hieu = nien_hieu;
		this.ton_hieu = ton_hieu;
		this.thuy_hieu = thuy_hieu;
		this.mieu_hieu = mieu_hieu;
		this.tuoc_hieu = tuoc_hieu;
	}
	
    
    
    public String getTri_vi() {
		return tri_vi;
	}
	public String getTien_nhiem() {
		return tien_nhiem;
	}
	public String getKe_nhiem() {
		return ke_nhiem;
	}
	public String getNien_hieu() {
		return nien_hieu;
	}
	public String getTon_hieu() {
		return ton_hieu;
	}
	public String getThuy_hieu() {
		return thuy_hieu;
	}
	public String getMieu_hieu() {
		return mieu_hieu;
	}
	public String getTuoc_hieu() {
		return tuoc_hieu;
	}
    

    /*public static Map getInfoFromWiki(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (String url : urls) {
            final Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            Vua vua = new Vua();
            vua.addLink(url);
            Elements info = doc.select("table.infobox tbody tr");
            if (info.size() != 0) {
                if (vua.ten == null && doc.selectFirst(".mw-page-title-main") != null) {
                    vua.ten = doc.selectFirst(".mw-page-title-main").text();
                }
                for (Element row : info) {
                    if (vua.tenDayDu == null && row.selectFirst(".nickname") != null) {
                        vua.tenDayDu = row.selectFirst(".nickname").text();
                    }
                    if (vua.sinh == null && row.selectFirst("th:contains(Sinh)") != null) {
                        vua.sinh = row.selectFirst("td").text();
                    }
                    if (vua.mat == null && row.selectFirst("th:contains(Mất)") != null) {
                        vua.mat = row.selectFirst("td").text();
                    }

                }
                m.put(vua.ten, vua);
            }
        }
        return m;
    }*/

    public static Vua mergeRule(Object oldVal, Object newVal) {
        Vua v2 = (Vua) newVal;
        Vua v1 = (Vua) NhanVat.mergeRule(oldVal, newVal);
        if (v1.tri_vi == null || v1.tri_vi.equals("?")) {
            v1.tri_vi = v2.tri_vi;
        }
        if (v1.tien_nhiem == null || v1.tien_nhiem.equals("?")) {
            v1.tien_nhiem = v2.tien_nhiem;
        }
        if (v1.ke_nhiem == null || v1.ke_nhiem.equals("?")) {
            v1.ke_nhiem = v2.ke_nhiem;
        }
        if (v1.nien_hieu == null || v1.nien_hieu.equals("?")) {
            v1.nien_hieu = v2.nien_hieu;
        }
        if (v1.ton_hieu == null || v1.ton_hieu.equals("?")) {
            v1.ton_hieu = v2.ton_hieu;
        }
        if (v1.thuy_hieu == null || v1.thuy_hieu.equals("?")) {
            v1.thuy_hieu = v2.thuy_hieu;
        }
        if (v1.mieu_hieu == null || v1.mieu_hieu.equals("?")) {
            v1.mieu_hieu = v2.mieu_hieu;
        }
        if (v1.tuoc_hieu == null || v1.tuoc_hieu.equals("?")) {
            v1.tuoc_hieu = v2.tuoc_hieu;
        }
        return v1;
    }

    /*public void print() {
        System.out.println(this.ten + "-" + this.tenDayDu + "-" + this.sinh + "-" + this.mat);
    }*/

}
