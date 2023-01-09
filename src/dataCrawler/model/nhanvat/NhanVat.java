package dataCrawler.model.nhanvat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class NhanVat {
    protected String ten;
    protected String tenKhac;
    protected String thoiKy;
    protected String sinh;
    protected String mat;
    protected String anTang;
    protected String chucVu;
    protected String thanPhu;
    protected String thanMau;
    protected String phoiNgau;
    protected String tonGiao;
    protected String nguyenNhanMat;
    protected String queQuan;
    protected String dangPhai;
    protected String noiO;
    protected String danToc;
    protected String hocvan;
    protected Map cuocDoi;
    protected String moTa;
    protected ArrayList<String> vo;
    protected ArrayList<String> hauDue;
    protected ArrayList<String> nhanVatCungThoiKy;
    protected ArrayList<String> links = new ArrayList<>();


    public NhanVat() {
    }

    public static Map getInfoFromNguoiKeSu(ArrayList<String> urls) throws IOException {
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
            NhanVat nhanVat = new NhanVat();
            nhanVat.addLink(url);
            nhanVat.ten = doc.selectFirst("div.page-header h1").text();
            Element info = doc.selectFirst(".infobox");
            if (info != null) {
                for (Element row : info.select("tr")) {
                    if (row.selectFirst("th:contains(Triều Đại)") != null || row.selectFirst("th:contains(Thời kỳ)") != null || row.selectFirst("th:contains(Hoàng tộc)") != null || row.selectFirst("th:contains(Kỷ nguyên)") != null) {
                        if (row.selectFirst("td") == null) {
                            nhanVat.thoiKy = row.nextElementSibling().text();
                        } else {
                            nhanVat.thoiKy = row.selectFirst("td").text();
                        }
                    }
                    if (row.selectFirst("th:contains(Chức vụ)") != null || row.selectFirst("th:contains(Nghề nghiệp)") != null || row.selectFirst("th:contains(Công việc)") != null) {
                        if (row.selectFirst("td") == null) {
                            nhanVat.chucVu = row.nextElementSibling().text();
                        } else {
                            nhanVat.chucVu = row.selectFirst("td").text();
                        }
                    }
                    if (row.selectFirst("th:contains(Tên đầy đủ)") != null || row.selectFirst("th:contains(Tên khác)") != null || row.selectFirst("th:contains(Tự)") != null || row.selectFirst("th:contains(Tên khai sinh)") != null || row.selectFirst("th:contains(Biệt danh)") != null || row.selectFirst("th:contains(Tên thật)") != null) {
                        if (row.selectFirst("td") == null) {
                            nhanVat.tenKhac = row.nextElementSibling().text();
                        } else {
                            nhanVat.tenKhac = row.selectFirst("td").text();
                        }
                    }
                    if (row.selectFirst("th:contains(Sinh)") != null) {
                        nhanVat.sinh = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Nguyên nhân mất)") != null) {
                        nhanVat.nguyenNhanMat = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Quê quán)") != null) {
                        nhanVat.queQuan = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Đảng phái)") != null) {
                        nhanVat.dangPhai = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Nơi ở)") != null) {
                        nhanVat.noiO = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Dân tộc)") != null) {
                        nhanVat.danToc = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Học vấn)") != null) {
                        nhanVat.hocvan = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Sinh)") != null) {
                        nhanVat.sinh = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Mất)") != null) {
                        nhanVat.mat = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(An táng)") != null || row.selectFirst("th:contains(Nơi an nghỉ)") != null) {
                        nhanVat.anTang = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Thân phụ)") != null || row.selectFirst("th:contains(Cha mẹ)") != null) {
                        nhanVat.thanPhu = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Thân mẫu)") != null) {
                        nhanVat.thanMau = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Tôn giáo)") != null) {
                        nhanVat.tonGiao = row.selectFirst("td").text();
                    }
                    if ((row.selectFirst("th:contains(Phối ngẫu)") != null || row.selectFirst("th:contains(Phu quân)") != null) && row.selectFirst("td") != null) {
                        nhanVat.phoiNgau = row.selectFirst("td").text();
                    }
                    if (row.selectFirst("th:contains(Hậu phi)") != null || row.selectFirst("th:contains(Thê thiếp)") != null || row.selectFirst("th:contains(Vợ)") != null || row.selectFirst("th:contains(Hoàng hậu)") != null || row.selectFirst("th:contains(Phi tần)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            nhanVat.addVo(row.selectFirst("td").text());
                        } else {
                            for (Element vo : results) {
                                nhanVat.addVo(vo.text());
                            }
                        }
                    }
                    if (row.selectFirst("th:contains(Hậu duệ)") != null || row.selectFirst("th:contains(Con cái)") != null) {
                        results = row.select("li");
                        if (results.size() == 0 && row.selectFirst("td") != null) {
                            nhanVat.addHauDue(row.selectFirst("td").text());
                        } else {
                            for (Element hauDue : results) {
                                nhanVat.addHauDue(hauDue.text());
                            }
                        }
                    }
                }
            }
            if (nhanVat.ten != null) {
                m.put(Tool.normalizeKey(nhanVat.ten), nhanVat);
            }
        }
        return m;
    }

    public static Map getInfoFromThuVienLichSu(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);

        for (String url : urls) {
//            System.out.println(url);
            final Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            NhanVat nhanVat = new NhanVat();
            nhanVat.addLink(url);
            nhanVat.ten = doc.selectFirst("h3.header-edge").text();

            Map<String, String> info = new LinkedHashMap<>();
            Boolean check = false;
            for (Element milestone : doc.select("div.divide-tag:nth-of-type(3) table tr")) {
                if (milestone.selectFirst("td") != null) {
                    info.put(milestone.selectFirst("td:nth-of-type(1)").text(), milestone.selectFirst("td:nth-of-type(3)").text());
                    check = true;
                }
            }
            if (check == true) {
                nhanVat.setCuocDoi(info);
            }

            nhanVat.moTa = doc.select("div.divide-tag:nth-of-type(4)").text();

            for (Element link : doc.select("div.divide-tag:nth-of-type(5) a")) {
                nhanVat.addLink(link.attr("href"));
            }
            for (Element character : doc.select("div.divide-tag:nth-of-type(6) h4.card-title")) {
                nhanVat.addNhanVatCungThoiKy(Tool.separateKeyWithoutQuotation(character.text()));
            }

            m.put(Tool.separateKeyWithoutQuotation(nhanVat.ten), nhanVat);
        }
        return m;
    }

    public static NhanVat mergeRule(Object oldVal, Object newVal) {
        NhanVat v1 = (NhanVat) oldVal;
        NhanVat v2 = (NhanVat) newVal;
        if (v1.tenKhac == null || v1.tenKhac.equals("?")) {
            v1.tenKhac = v2.tenKhac;
        }
        if (v1.thoiKy == null || v1.thoiKy.equals("?")) {
            v1.thoiKy = v2.thoiKy;
        }
        if (v1.sinh == null || v1.sinh.equals("?")) {
            v1.sinh = v2.sinh;
        }
        if (v1.mat == null || v1.mat.equals("?")) {
            v1.mat = v2.mat;
        }
        if (v1.anTang == null || v1.anTang.equals("?")) {
            v1.anTang = v2.anTang;
        }
        if (v1.chucVu == null || v1.chucVu.equals("?")) {
            v1.chucVu = v2.chucVu;
        }
        if (v1.thanPhu == null || v1.thanPhu.equals("?")) {
            v1.thanPhu = v2.thanPhu;
        }
        if (v1.thanMau == null || v1.thanMau.equals("?")) {
            v1.thanMau = v2.thanMau;
        }
        if (v1.phoiNgau == null || v1.phoiNgau.equals("?")) {
            v1.phoiNgau = v2.phoiNgau;
        }
        if (v1.tonGiao == null || v1.tonGiao.equals("?")) {
            v1.tonGiao = v2.tonGiao;
        }
        if (v1.nguyenNhanMat == null || v1.nguyenNhanMat.equals("?")) {
            v1.nguyenNhanMat = v2.nguyenNhanMat;
        }
        if (v1.queQuan == null || v1.queQuan.equals("?")) {
            v1.queQuan = v2.queQuan;
        }
        if (v1.dangPhai == null || v1.dangPhai.equals("?")) {
            v1.dangPhai = v2.dangPhai;
        }
        if (v1.noiO == null || v1.noiO.equals("?")) {
            v1.noiO = v2.noiO;
        }
        if (v1.danToc == null || v1.danToc.equals("?")) {
            v1.danToc = v2.danToc;
        }
        if (v1.hocvan == null || v1.hocvan.equals("?")) {
            v1.hocvan = v2.hocvan;
        }
        if (v1.vo == null) {
            v1.vo = v2.vo;
        }
        if (v1.hauDue == null) {
            v1.hauDue = v2.hauDue;
        }
        if (v1.cuocDoi == null) {
            v1.cuocDoi = v2.cuocDoi;
        }
        if (v1.moTa == null) {
            v1.moTa = v2.moTa;
        }
        if (v1.nhanVatCungThoiKy == null) {
            v1.nhanVatCungThoiKy = v2.nhanVatCungThoiKy;
        }
        for (String link : v2.links) {
            if (!v1.links.contains(link))
                v1.links.add(link);
        }
        return v1;
    }

    protected void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }

    protected void addNhanVatCungThoiKy(String item) {
        if (nhanVatCungThoiKy == null) {
            nhanVatCungThoiKy = new ArrayList<>();
        }
        if (nhanVatCungThoiKy.contains(item)) {
            return;
        }
        nhanVatCungThoiKy.add(item);
    }

    protected void addVo(String item) {
        if (vo == null) {
            vo = new ArrayList<>();
        }
        if (vo.contains(item)) {
            return;
        }
        vo.add(item);
    }

    protected void addHauDue(String item) {
        if (hauDue == null) {
            hauDue = new ArrayList<>();
        }
        if (hauDue.contains(item)) {
            return;
        }
        hauDue.add(item);
    }

    protected void setCuocDoi(Map m) {
        this.cuocDoi = m;
    }
}
