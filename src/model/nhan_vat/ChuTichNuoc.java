package model.nhan_vat;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.NormalizeTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ChuTichNuoc extends NhanVat {
    protected String nhiemKyBatDau;
    protected String nhiemKyKetThuc;
    protected String thoiGianTaiNhiem;
    protected String ghiChu;
    protected String chuKy;
    protected String website;
    protected ArrayList<String> giaQuyen;
    protected ArrayList<String> truongLop;

    public String getNhiemKyBatDau() {
        return nhiemKyBatDau;
    }

    public String getNhiemKyKetThuc() {
        return nhiemKyKetThuc;
    }

    public String getThoiGianTaiNhiem() {
        return thoiGianTaiNhiem;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getChuKy() {
        return chuKy;
    }

    public String getWebsite() {
        return website;
    }

    public ArrayList<String> getGiaQuyen() {
        return giaQuyen;
    }

    public ArrayList<String> getTruongLop() {
        return truongLop;
    }

    public String getDescription() {
        return ("Nhiệm kỳ bắt đầu: " + nhiemKyBatDau + "\n" + "Nhiệm kỳ kết thúc: " + nhiemKyKetThuc + "\n" + "Thời gian tái nhiệm: " + thoiGianTaiNhiem + "\n" + "Ghi chú: " + ghiChu);
    }

    public ChuTichNuoc() {
        super();
    }

    public static Map getInfoFromWiki(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Map bonus = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Element result;
        Elements results;

        for (String url : urls) {
//            System.out.println(url);
            final Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            ChuTichNuoc chuTichNuoc = new ChuTichNuoc();
            chuTichNuoc.addLink(url);
            result = doc.selectFirst(".mw-page-title-main");
            if (result != null) {
                chuTichNuoc.ten = result.text();
                chuTichNuoc.chucVu = "Chủ tịch nước";
            }
            result = doc.selectFirst("div.mw-parser-output p");
            if (result != null) {
                chuTichNuoc.moTa = result.text();
            }

            Element info = doc.selectFirst("table.infobox");
            if (info != null) {
                for (Element row : info.select("tr")) {
                    if (row.selectFirst("th:contains(Cha)") != null) {
                        chuTichNuoc.thanPhu = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Sinh)") != null) {
                        chuTichNuoc.sinh = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Mất)") != null) {
                        chuTichNuoc.mat = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Đảng phái)") != null) {
                        chuTichNuoc.dangPhai = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Nơi ở)") != null) {
                        chuTichNuoc.noiO = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Học vấn)") != null) {
                        chuTichNuoc.hocvan = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Tôn giáo)") != null) {
                        chuTichNuoc.tonGiao = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:containsOwn(Dân tộc)") != null) {
                        chuTichNuoc.danToc = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Website)") != null) {
                        chuTichNuoc.website = row.selectFirst("td a").attr("href");
                    }
                    if (row.selectFirst("th:contains(Chữ ký)") != null) {
                        chuTichNuoc.chuKy = row.selectFirst("td img").attr("src");
                    }
                    if (row.selectFirst("th:contains(Vợ)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            chuTichNuoc.addVo(row.selectFirst("td").text());
                        } else {
                            for (Element vo : results) {
                                chuTichNuoc.addVo(vo.text());
                            }
                        }
                    }
                    if (row.selectFirst("th:contains(Con cái)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            chuTichNuoc.addHauDue(row.selectFirst("td").text());
                        } else {
                            for (Element hauDue : results) {
                                chuTichNuoc.addHauDue(hauDue.text());
                            }
                        }
                    }
                    if (row.selectFirst("th:contains(Gia quyến)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            chuTichNuoc.addGiaQuyen(row.selectFirst("td").text());
                        } else {
                            for (Element giaQuyen : results) {
                                chuTichNuoc.addGiaQuyen(giaQuyen.text());
                            }
                        }
                    }
                    if (row.selectFirst("th:contains(Trường lớp)") != null) {
                        results = row.select("a");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            chuTichNuoc.addHauDue(row.selectFirst("td").text());
                        } else {
                            for (Element truongLop : results) {
                                if (truongLop.text().equals("Trường lớp")) {
                                    continue;
                                }
                                chuTichNuoc.addTruongLop(truongLop.text());
                            }
                        }
                    }
                }
            }
            if (chuTichNuoc.ten != null) {
                m.put(NormalizeTool.normalizeKey(chuTichNuoc.ten), chuTichNuoc);
            }
        }

        final Document doc = Jsoup.connect("https://vi.m.wikipedia.org/wiki/Danh_sách_Chủ_tịch_nước_Cộng_hòa_xã_hội_chủ_nghĩa_Việt_Nam")
                .ignoreContentType(true)
                .timeout(0)
                .get();
        Element table = doc.selectFirst("table.wikitable");
        for (Element row : table.select("tr")) {
            if (row.select("td").size() != 9) {
                continue;
            }
            ChuTichNuoc chuTichNuoc = new ChuTichNuoc();
            chuTichNuoc.addLink("https://vi.m.wikipedia.org/wiki/Danh_sách_Chủ_tịch_nước_Cộng_hòa_xã_hội_chủ_nghĩa_Việt_Nam");
            chuTichNuoc.ten = row.selectFirst("td:nth-of-type(3) a:last-child").text();
            result = row.selectFirst("td:nth-of-type(2) img");
            if (result != null) {
                chuTichNuoc.image = result.attr("src");
            }
            chuTichNuoc.nhiemKyBatDau = row.selectFirst("td:nth-of-type(4)").text();
            chuTichNuoc.nhiemKyKetThuc = row.selectFirst("td:nth-of-type(5)").text();
            chuTichNuoc.thoiGianTaiNhiem = row.selectFirst("td:nth-of-type(8)").text();
            result = row.selectFirst("td:nth-of-type(9)");
            if (!result.text().equals("")) {
                chuTichNuoc.ghiChu = result.text();
            }
            bonus.put(NormalizeTool.normalizeKey(chuTichNuoc.ten), chuTichNuoc);
        }
        bonus.forEach((key, value) -> m.merge(key, value, (oldVal, newVal) -> {
            return ChuTichNuoc.mergeRule(oldVal, newVal);
        }));
        return m;
    }

    public static ChuTichNuoc mergeRule(Object oldVal, Object newVal) {
        ChuTichNuoc result = (ChuTichNuoc) NhanVat.mergeRule(newVal, oldVal);
        if (oldVal instanceof ChuTichNuoc) {
            // Only when merge 2 ChuTichNuoc
            ChuTichNuoc v2 = (ChuTichNuoc) newVal;
            ChuTichNuoc v1 = (ChuTichNuoc) NhanVat.mergeRule(oldVal, newVal);
            if (v1.nhiemKyKetThuc == null || v1.nhiemKyKetThuc.equals("?")) {
                v1.nhiemKyKetThuc = v2.nhiemKyKetThuc;
            }
            if (v1.nhiemKyBatDau == null || v1.nhiemKyBatDau.equals("?")) {
                v1.nhiemKyBatDau = v2.nhiemKyBatDau;
            }
            if (v1.thoiGianTaiNhiem == null || v1.thoiGianTaiNhiem.equals("?")) {
                v1.thoiGianTaiNhiem = v2.thoiGianTaiNhiem;
            }
            if (v1.ghiChu == null || v1.ghiChu.equals("?")) {
                v1.ghiChu = v2.ghiChu;
            }
            if (v1.chuKy == null || v1.chuKy.equals("?")) {
                v1.chuKy = v2.chuKy;
            }
            if (v1.website == null || v1.website.equals("?")) {
                v1.website = v2.website;
            }
            if (v1.giaQuyen == null) {
                v1.giaQuyen = v2.giaQuyen;
            }
            if (v1.truongLop == null) {
                v1.truongLop = v2.truongLop;
            }
            for (String link : v2.links) {
                if (!v1.links.contains(link))
                    v1.links.add(link);
            }
            return v1;
        }
        return result;
    }

    protected void addGiaQuyen(String item) {
        if (giaQuyen == null) {
            giaQuyen = new ArrayList<>();
        }
        if (giaQuyen.contains(item)) {
            return;
        }
        giaQuyen.add(item);
    }

    protected void addTruongLop(String item) {
        if (truongLop == null) {
            truongLop = new ArrayList<>();
        }
        if (truongLop.contains(item)) {
            return;
        }
        truongLop.add(item);
    }
}
