package model.dia_diem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.NormalizeTool;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class DiSan extends DiaDiem {
    protected String moTa;

    public String getMoTa() {
        return moTa;
    }

    public DiSan() {
        // TODO Auto-generated constructor stub
    }

    public String getTypeModel() {
        return "Địa điểm";
    }


    public static Map getInfo_Wiki() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

        String url = "https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_di_s%E1%BA%A3n_" +
                "th%E1%BA%BF_gi%E1%BB%9Bi_t%E1%BA%A1i_Vi%E1%BB%87t_Nam";
        Document document = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();
        Element table = document.selectFirst("table[class=wikitable sortable]");
        Elements infos = table.selectFirst("tbody").select("tr");
        for (int i = 1; i < infos.size(); i++) {
            DiSan diSan = new DiSan();
            Elements infoos = infos.get(i).select("td");
            if (infoos.get(1).selectFirst("a") != null) {
                diSan.ten = infoos.get(1).selectFirst("a").text();
            }
            if (infoos.get(3).selectFirst("span") != null) {
                diSan.khuVuc = infoos.get(3).selectFirst("span").text();
            }
            if (infoos.get(4) != null) {
                diSan.namThanhLap = infoos.get(4).text();
            }
            if (infoos.get(6) != null) {
                diSan.moTa = infoos.get(6).text();
            }
            m.put(NormalizeTool.normalizeKey(diSan.ten), diSan);
        }
        return m;
    }

    public static DiSan mergeRule(Object oldVal, Object newVal) {
        DiSan result = (DiSan) DiaDiem.mergeRule(newVal, oldVal);
        if (oldVal instanceof DiSan) {
            DiSan v2 = (DiSan) newVal;
            DiSan v1 = (DiSan) DiaDiem.mergeRule(oldVal, newVal);
            if (v1.moTa == null || v1.moTa.equals("?")) {
                v1.moTa = v2.moTa;
            }
            return v1;
        }
        return result;
    }
}
