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



	protected String triVi; //tai_vi
	protected String tienNhiem;
	protected String keNhiem;
	protected String nienHieu;
	protected String tonHieu;
	protected String thuyHieu;
	protected String mieuHieu;
	protected String tuocHieu;

    
	public Vua() {
        super();
    }
	public Vua(String triVi, String tienNhiem, String keNhiem, String nienHieu, String tonHieu, String thuyHieu,
			String mieuHieu, String tuocHieu) {
		super();
		this.triVi = triVi;
		this.tienNhiem = tienNhiem;
		this.keNhiem = keNhiem;
		this.nienHieu = nienHieu;
		this.tonHieu = tonHieu;
		this.thuyHieu = thuyHieu;
		this.mieuHieu = mieuHieu;
		this.tuocHieu = tuocHieu;
	}
	
    
	public String getTriVi() {
		return triVi;
	}
	public String getTienNhiem() {
		return tienNhiem;
	}
	public String getKeNhiem() {
		return keNhiem;
	}
	public String getNienHieu() {
		return nienHieu;
	}
	public String getTonHieu() {
		return tonHieu;
	}
	public String getThuyHieu() {
		return thuyHieu;
	}
	public String getMieuHieu() {
		return mieuHieu;
	}
	public String getTuocHieu() {
		return tuocHieu;
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
        if (v1.triVi == null || v1.triVi.equals("?")) {
            v1.triVi = v2.triVi;
        }
        if (v1.tienNhiem == null || v1.tienNhiem.equals("?")) {
            v1.tienNhiem = v2.tienNhiem;
        }
        if (v1.keNhiem == null || v1.keNhiem.equals("?")) {
            v1.keNhiem = v2.keNhiem;
        }
        if (v1.nienHieu == null || v1.nienHieu.equals("?")) {
            v1.nienHieu = v2.nienHieu;
        }
        if (v1.tonHieu == null || v1.tonHieu.equals("?")) {
            v1.tonHieu = v2.tonHieu;
        }
        if (v1.thuyHieu == null || v1.thuyHieu.equals("?")) {
            v1.thuyHieu = v2.thuyHieu;
        }
        if (v1.mieuHieu == null || v1.mieuHieu.equals("?")) {
            v1.mieuHieu = v2.mieuHieu;
        }
        if (v1.tuocHieu == null || v1.tuocHieu.equals("?")) {
            v1.tuocHieu = v2.tuocHieu;
        }
        return v1;
    }

    /*public void print() {
        System.out.println(this.ten + "-" + this.tenDayDu + "-" + this.sinh + "-" + this.mat);
    }*/

}
