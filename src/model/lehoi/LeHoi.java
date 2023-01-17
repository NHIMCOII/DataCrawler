package model.lehoi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.NormalizeTool;
import util.SeperateTool;
import util.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class LeHoi {


    protected String ten;
    protected String ngayAmLich;
    protected String viTri;
    protected String moTa;
    protected String lanDauToChuc;
    protected ArrayList<String> links = new ArrayList<>();
    protected ArrayList<String> nhanVat;


    public LeHoi() {
        // TODO Auto-generated constructor stub
    }

    public static Map getInfoFromWiki() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Element result;
        Elements results;

        final Document doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Lễ_hội_Việt_Nam?fbclid=IwAR1gxFOGLW4GwPTdXeBnmpG9j1F1j1u1gaCovn9B68iewJIorwYElXiYVmk#Lễ_hội_lớn_các_tỉnh_thành")
                .ignoreContentType(true)
                .timeout(0)
                .get();
        Element table = doc.selectFirst(".wikitable");

        for (Element row : table.select("tr")) {
            if (row.selectFirst("th") != null) {
                continue;
            }
            LeHoi leHoi = new LeHoi();
            leHoi.ten = row.selectFirst("td:nth-of-type(3)").text();
            leHoi.addLink("https://vi.wikipedia.org/wiki/Lễ_hội_Việt_Nam?fbclid=IwAR1gxFOGLW4GwPTdXeBnmpG9j1F1j1u1gaCovn9B68iewJIorwYElXiYVmk#Lễ_hội_lớn_các_tỉnh_thành");
            result = row.selectFirst("td:nth-of-type(1)");
            if (result != null) {
                if (!result.text().equals("")) {
                    leHoi.ngayAmLich = result.text();
                }
            }
            result = row.selectFirst("td:nth-of-type(2)");
            if (result != null) {
                if (!result.text().equals("")) {
                    leHoi.viTri = result.text();
                }
            }
            result = row.selectFirst("td:nth-of-type(4)");
            if (result != null) {
                if (!result.text().equals("")) {
                    leHoi.lanDauToChuc = result.text();
                }
            }
            result = row.selectFirst("td:nth-of-type(6)");
            if (result != null) {
                if (!result.text().equals("")) {
                    leHoi.moTa = result.text();
                }
            }
            result = row.selectFirst("td:nth-of-type(5)");
            if (result != null) {
                if (!result.text().equals("")) {
                    leHoi.setNhanVat(SeperateTool.seperateByComma(result.text()));
                }
            }

            m.put(NormalizeTool.normalizeKey(leHoi.ten), leHoi);
        }
        return m;
    }

    public static LeHoi mergeRule(Object oldVal, Object newVal) {
        LeHoi v1 = (LeHoi) oldVal;
        LeHoi v2 = (LeHoi) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.ngayAmLich == null || v1.ngayAmLich.equals("?")) {
            v1.ngayAmLich = v2.ngayAmLich;
        }
        if (v1.viTri == null || v1.viTri.equals("?")) {
            v1.viTri = v2.viTri;
        }
        if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
        if (v1.lanDauToChuc == null || v1.lanDauToChuc.equals("?")) {
            v1.lanDauToChuc = v2.lanDauToChuc;
        }
        return v1;
    }

    protected void setNhanVat(ArrayList<String> nhanVat) {
        if (this.nhanVat == null) {
            this.nhanVat = new ArrayList<>();
        }
        for (String item : nhanVat) {
            this.nhanVat.add(NormalizeTool.normalizeKey(item));
        }
    }

    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }
}
