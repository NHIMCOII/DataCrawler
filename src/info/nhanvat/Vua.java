package info.nhanvat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


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
        Map m = new LinkedHashMap();
        for (String url : urls) {
            final Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            Vua vua = new Vua();

            Elements info = doc.select("table.infobox tbody tr");
            if (info.size() != 0) {
                if (vua.getTen() == null && doc.selectFirst(".mw-page-title-main") != null) {
                    vua.setTen(doc.selectFirst(".mw-page-title-main").text());
                }
                for (Element row : info) {
                    if (vua.getTenDayDu() == null && row.selectFirst(".nickname") != null) {
                        vua.setTenDayDu(row.selectFirst(".nickname").text());
                    }
                    if (vua.getSinh() == null && row.selectFirst("th:contains(Sinh)") != null) {
                        vua.setSinh(row.selectFirst("td").text());
                    }
                    if (vua.getMat() == null && row.selectFirst("th:contains(Mất)") != null) {
                        vua.setMat(row.selectFirst("td").text());
                    }

                }
                m.put(vua.getTen(), vua);
            }
        }
        return m;
    }

    public String getTenDayDu() {
        return tenDayDu;
    }

    public void setTenDayDu(String tenDayDu) {
        this.tenDayDu = tenDayDu;
    }

    public String getTheThiep() {
        return theThiep;
    }

    public void setTheThiep(String theThiep) {
        this.theThiep = theThiep;
    }

    public String getThanPhu() {
        return thanPhu;
    }

    public void setThanPhu(String thanPhu) {
        this.thanPhu = thanPhu;
    }

    public String getThanMau() {
        return thanMau;
    }

    public void setThanMau(String thanMau) {
        this.thanMau = thanMau;
    }

    public String getTrieuDai() {
        return trieuDai;
    }

    public void setTrieuDai(String trieuDai) {
        this.trieuDai = trieuDai;
    }

    public void sync(Vua obj) throws IllegalAccessException {
        super.sync(obj);
        this.trieuDai = (this.trieuDai == null) ? obj.trieuDai : this.trieuDai;
        this.tenDayDu = (this.tenDayDu == null) ? obj.tenDayDu : this.tenDayDu;
        this.theThiep = (this.theThiep == null) ? obj.theThiep : this.theThiep;
        this.thanPhu = (this.ten == null) ? obj.thanPhu : this.thanPhu;
        this.thanMau = (this.thanMau == null) ? obj.thanMau : this.thanMau;
    }

    public void print() {
        System.out.println(this.getTen() + "-" + this.getTenDayDu() + "-" + this.getSinh() + "-" + this.getMat());
    }

}
