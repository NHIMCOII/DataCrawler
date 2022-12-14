package dataCrawler.info.nhanvat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Vua extends NhanVat {
    private String tenDayDu;
    private String trieuDai;
    private String theThiep;
    private String thanPhu;
    private String thanMau;

    public Vua() {
        super();
    }

    public Vua(String ten, String chucVu, String sinh, String mat, String trieuDai, String tenDayDu, String theThiep, String thanPhu, String thanMau) {
        super(ten, chucVu, sinh, mat);
        this.trieuDai = trieuDai;
        this.tenDayDu = tenDayDu;
        this.theThiep = theThiep;
        this.thanPhu = thanPhu;
        this.thanMau = thanMau;
    }

    public static Map getInfoFromWiki(ArrayList<String> urls) throws IOException {
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
    }

    public static Vua mergeRule(Object oldVal, Object newVal) {
        Vua v2 = (Vua) newVal;
        Vua v1 = (Vua) NhanVat.mergeRule(oldVal, newVal);
        if (v1.trieuDai == null || v1.trieuDai.equals("?")) {
            v1.trieuDai = v2.trieuDai;
        }
        if (v1.tenDayDu == null || v1.tenDayDu.equals("?")) {
            v1.tenDayDu = v2.tenDayDu;
        }
        return v1;
    }

    public String getTenDayDu() {
        return tenDayDu;
    }

    public String getTheThiep() {
        return theThiep;
    }

    public String getThanPhu() {
        return thanPhu;
    }

    public String getThanMau() {
        return thanMau;
    }

    public String getTrieuDai() {
        return trieuDai;
    }

    public void print() {
        System.out.println(this.ten + "-" + this.tenDayDu + "-" + this.sinh + "-" + this.mat);
    }

}
