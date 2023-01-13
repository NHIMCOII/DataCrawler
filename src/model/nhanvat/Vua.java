package model.nhanvat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Vua extends NhanVat {


    protected String triVi; //tai_vi
    protected String tienNhiem;
    protected String keNhiem;
    protected String nienHieu;
    protected String tonHieu;
    protected String thuyHieu;
    protected String mieuHieu;
    protected ArrayList<String> tuocHieu; //tuocVi


    public Vua() {
        super();
    }

    public static Map getInfoFromWiki(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int i = 0;
        Element result;
        Elements results;
        for (String url : urls) {
//            System.out.println(url);
            final Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            Vua vua = new Vua();
            vua.addLink(url);
            if (doc.selectFirst(".mw-page-title-main") != null) {
                vua.ten = doc.selectFirst(".mw-page-title-main").text();
                vua.chucVu = "Vua Chúa";
            }
//            vua.ten = doc.selectFirst("div.page-header h1").text();
            Element info = doc.selectFirst(".infobox");
            if (info != null) {
                for (Element row : info.select("tr")) {
                    if (row.selectFirst("th:contains(Triều Đại)") != null || row.selectFirst("th:contains(Thời kỳ)") != null || row.selectFirst("th:contains(Hoàng tộc)") != null) {
                        vua.thoiKy = row.selectFirst("td").text();
                    }
                    result = row.selectFirst(".nickname");
                    if (result != null) {
                        vua.tenKhac = result.text();
                    }
                    if (row.selectFirst("th:contains(Sinh)") != null) {
                        vua.sinh = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Mất)") != null) {
                        vua.mat = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(An táng)") != null) {
                        vua.anTang = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Thân phụ)") != null) {
                        vua.thanPhu = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Thân mẫu)") != null) {
                        vua.thanMau = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Tôn giáo)") != null) {
                        vua.tonGiao = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Phối ngẫu)") != null && row.selectFirst("td") != null) {
                        vua.phoiNgau = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Hậu phi)") != null || row.selectFirst("th:contains(Thê thiếp)") != null || row.selectFirst("th:contains(Vợ)") != null || row.selectFirst("th:contains(Hoàng hậu)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            vua.addVo(row.selectFirst("td").text());
                        } else {
                            for (Element vo : results) {
                                vua.addVo(vo.text());
                            }
                        }
                    }
                    if (row.selectFirst("th:contains(Hậu duệ)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            vua.addHauDue(row.selectFirst("td").text());
                        } else {
                            for (Element hauDue : results) {
                                vua.addHauDue(hauDue.text());
                            }
                        }
                    }
                    if (row.selectFirst("th:contains(Trị vì)") != null || row.selectFirst("th:contains(Tại vị)") != null) {
                        vua.triVi = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Tiền nhiệm)") != null) {
                        vua.tienNhiem = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Kế nhiệm)") != null) {
                        vua.keNhiem = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Niên hiệu)") != null) {
                        if (row.selectFirst("td") == null) {
                            vua.nienHieu = row.nextElementSibling().text();
                        } else {
                            vua.nienHieu = row.selectFirst("td").text();
                        }
                    }
                    if (row.selectFirst("th:contains(Thụy hiệu)") != null) {
                        if (row.selectFirst("td") == null) {
                            vua.thuyHieu = row.nextElementSibling().text();
                        } else {
                            vua.thuyHieu = row.selectFirst("td").text();
                        }
                    }
                    if (row.selectFirst("th:contains(Miếu hiệu)") != null) {
                        if (row.selectFirst("td") == null) {
                            vua.mieuHieu = row.nextElementSibling().text();
                        } else {
                            vua.mieuHieu = row.selectFirst("td").text();
                        }
                    }
                    if (row.selectFirst("th:contains(Tước hiệu)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            vua.addTuocHieu(row.selectFirst("td").text());
                        } else {
                            for (Element tuocHieu : results) {
                                vua.addTuocHieu(tuocHieu.text());
                            }
                        }
                    }
                }
            }
            if (vua.ten != null) {
                m.put(Tool.normalizeKey(vua.ten), vua);
            }
//            i++;
//            if (i == 1) {
//                break;
//            }
        }
        return m;
    }

    /*
    [Vua].forEach((key, value) -> [NhanVat].merge(key, value, (oldVal, newVal) -> {
                return Vua.mergeRule(oldVal, newVal);
            }))
    * */
    public static Vua mergeRule(Object oldVal, Object newVal) {
        Vua result = (Vua) NhanVat.mergeRule(newVal, oldVal);
        if (oldVal instanceof Vua) {
            // Only when merge 2 Vua
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
            if (v1.tuocHieu == null) {
                v1.tuocHieu = v2.tuocHieu;
            }
            return v1;
        }

        return result;


    }

    protected void addTuocHieu(String item) {
        if (tuocHieu == null) {
            tuocHieu = new ArrayList<>();
        }
        if (tuocHieu.contains(item)) {
            return;
        }
        tuocHieu.add(item);
    }
}
