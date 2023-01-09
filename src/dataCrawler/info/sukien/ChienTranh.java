package dataCrawler.info.sukien;


import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ChienTranh extends SuKien {
    protected String dongMinh;
    protected String doiPhuong;
    protected String ketQua;
    protected String thoiKy;

    public ChienTranh() {
        // TODO Auto-generated constructor stub
    }

    public ChienTranh(String ten, String thoiGian, String dienBien, String dongMinh,
                      String doiPhuong, String ketQua, String thoiKy) {
        super(ten, thoiGian, dienBien);
        this.dongMinh = dongMinh;
        this.doiPhuong = doiPhuong;
        this.ketQua = ketQua;
        this.thoiKy = thoiKy;
    }

    public static Map getInfo_Wiki() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

        String url = "https://vi.m.wikipedia.org/wiki/C%C3%A1" +
                "c_cu%E1%BB%99c_chi%E1%BA%BFn_tranh_Vi%E1%BB%87t_Nam_tham_gia";
        Document document = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();
        Elements periods = document.select("h2[class=section-heading]");

        for (int i = 1; i <= periods.size(); i++) {
            String cls = "class=mf-section-" + i + " collapsible-block";
            Element periodInfo = document.selectFirst("section[" + cls + "]");

            Elements dynasties = periodInfo.select("h3").select("span[class=mw-headline]");
            Elements dynastiesInfos = periodInfo.select("table[class=wikitable]");

            System.out.println(dynasties.size());
            for (int j = 0; j < dynasties.size(); j++) {
                ChienTranh chienTranh = new ChienTranh();

                if (chienTranh.thoiKy == null && dynasties.select("a").size() > 0) {
                    Elements anchors = dynasties.select("a");
                    chienTranh.thoiKy = "";
                    for (Element anchor : anchors) {
                        chienTranh.thoiKy = chienTranh.thoiKy.concat(anchor.text());
                    }
                }

                Elements infos = dynastiesInfos.select("tbody")
                        .select("tr").get(1)
                        .select("td");

                if (chienTranh.ten == null && infos.get(0) != null) {
                    String ten;
                    int index = infos.get(0).text().indexOf("(");
                    if (index > 0) {
                        ten = infos.get(0).text().substring(0, index);
                    } else {
                        ten = infos.get(0).text();
                    }
                    chienTranh.ten = ten;
                }
                if (infos.get(0) != null) {
                    String thoiGian;
                    int index = infos.get(0).text().indexOf("(");
                    if (index > 0) {
                        thoiGian = infos.get(0).text().substring(index + 1, infos.get(0).text().length() - 1);
                    } else {
                        thoiGian = "?";
                    }
                    chienTranh.thoiGian = thoiGian;
                }
                if (chienTranh.dongMinh == null && infos.get(1) != null) {
                    chienTranh.dongMinh = infos.get(1).text();
                }
                if (chienTranh.doiPhuong == null && infos.get(2) != null) {
                    chienTranh.doiPhuong = infos.get(2).text();
                }
                if (chienTranh.ketQua == null && infos.get(3) != null) {
                    chienTranh.ketQua = infos.get(3).text();
                }
                m.put(Diadiem_Links.removeAccent(chienTranh.ten).trim().toLowerCase(), chienTranh);
            }
        }
        return m;
    }

    public static ChienTranh mergeRule(Object oldVal, Object newVal) {
        ChienTranh v2 = (ChienTranh) newVal;
        ChienTranh v1 = (ChienTranh) SuKien.mergeRule(oldVal, newVal);
        if (v1.dongMinh == null || v1.dongMinh.equals("?")) {
            v1.dongMinh = v2.dongMinh;
        }
        if (v1.doiPhuong == null || v1.doiPhuong.equals("?")) {
            v1.doiPhuong = v2.doiPhuong;
        }
        if (v1.ketQua == null || v1.ketQua.equals("?")) {
            v1.ketQua = v2.ketQua;
        }
        return v1;
    }

    public String getDongMinh() {
        return dongMinh;
    }

    public String getDoiPhuong() {
        return doiPhuong;
    }

    public String getKetQua() {
        return ketQua;
    }

    public String getThoiKy() {
        return thoiKy;
    }
}
