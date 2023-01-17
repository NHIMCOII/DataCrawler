package model.sukien;


import dataCrawler.links.Diadiem_Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.Tool;

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

            Elements dynasties = periodInfo.select("h3,h4");
            Elements dynastiesInfos = periodInfo.select("table[class=wikitable]");

            for (int j = 0; j < dynastiesInfos.size(); j++) {
                ChienTranh chienTranh = new ChienTranh();

                if (dynasties.size() != 0) {
                    chienTranh.thoiKy = dynasties.get(j).select("span[class=mw-headline]").text();
                }

                Elements infos = dynastiesInfos.get(j).select("tbody")
                        .select("tr").get(1)
                        .select("td");

                if (infos.get(0) != null) {
                    chienTranh.ten = Tool.separateKeyWithoutQuotation(infos.get(0).text());
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
                if (infos.get(1) != null) {
                    chienTranh.dongMinh = infos.get(1).text();
                }
                if (infos.get(2) != null) {
                    chienTranh.doiPhuong = infos.get(2).text();
                }
                if (infos.get(3) != null) {
                    chienTranh.ketQua = infos.get(3).text();
                }
                m.put(Tool.normalizeKey(chienTranh.ten), chienTranh);
            }
        }
        return m;
    }

    public static ChienTranh mergeRule(Object oldVal, Object newVal) {
        ChienTranh result = (ChienTranh) SuKien.mergeRule(newVal, oldVal);
        if (oldVal instanceof ChienTranh) {
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
        return result;
    }
}
