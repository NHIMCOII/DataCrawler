package model.thoi_ky;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import util.NormalizeTool;
import util.SeperateTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class ThoiKy {
    protected String ten;
    protected String moTa;
    protected ArrayList<TrieuDai> trieuDai = new ArrayList<>();
    protected ArrayList<String> sukien;
    protected ArrayList<String> links = new ArrayList<>();

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public ArrayList<TrieuDai> getTrieuDai() {
        return trieuDai;
    }

    public ArrayList<String> getSukien() {
        return sukien;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public String getTypeModel() {
        return "Thời kỳ";
    }

    public String getDescriptionThoiKy() {
        return ("Mô tả: " + moTa);
    }

    public ThoiKy() {
    }

    public ThoiKy(String ten, String moTa) {
        this.ten = ten;
        this.moTa = moTa;
    }

    public static Map getInfoFromNguoiKeSu(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Element result;
        Map m = new LinkedHashMap();

        for (String url : urls) {
//            System.out.println(url);
            Document curr = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            ThoiKy thoiKy = new ThoiKy();
            thoiKy.addLink(url);
//            byte arr[] = doc.selectFirst(".subheading-category").text().getBytes("UTF-8");
//            String value = new String(arr, "UTF-8");
            thoiKy.ten = curr.selectFirst("h1").text();
            thoiKy.moTa = curr.selectFirst(".clearfix.category-desc").text();

            do {
                for (Element item : curr.select(".item-content")) {
                    TrieuDai trieuDai = new TrieuDai(item.selectFirst("h2").text(), item.select("p:not(.readmore)").text());
                    trieuDai.addLink("https://nguoikesu.com" + item.selectFirst("h2 a").attr("href"));
                    thoiKy.addTrieuDai(trieuDai);
                }
                result = curr.selectFirst("li.page-item > a:has(span.icon-angle-right)");
                if (result != null) {
                    curr = Jsoup.connect("https://nguoikesu.com" + result.attr("href"))
                            .ignoreContentType(true)
                            .timeout(0)
                            .get();
                }
            } while (result != null);
            m.put(NormalizeTool.normalizeKey(thoiKy.ten), thoiKy);
        }
        return m;
    }

    public static Map getInfoFromThuVienLichSu(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Element result;
        Map m = new LinkedHashMap();

        for (String url : urls) {
//            System.out.println(url);
            Document curr = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            ThoiKy thoiKy = new ThoiKy();
            thoiKy.addLink(url);
            for (Element suKien : curr.select("h3.card-title")) {
                thoiKy.addSuKien(
                        suKien.text()
                );
            }
            thoiKy.ten = curr.selectFirst("h1").text();

            m.put(NormalizeTool.normalizeKeyThoiKyFromThuVienLichSu(
                    NormalizeTool.normalizeKey(
                            SeperateTool.separateKeyWithoutQuotation(
                                    thoiKy.ten
                            )
                    )
            ), thoiKy);
        }
        return m;
    }

    public static ThoiKy mergeRule(Object oldVal, Object newVal) {
        ThoiKy v1 = (ThoiKy) oldVal;
        ThoiKy v2 = (ThoiKy) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
        if (v1.sukien == null) {
            v1.sukien = v2.sukien;
        }
        v1.links.addAll(v2.links);
        return v1;
    }

    protected void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }

    protected void addTrieuDai(TrieuDai item) {
        if (trieuDai.contains(item)) {
            return;
        }
        trieuDai.add(item);
    }

    protected void addSuKien(String item) {
        if (sukien == null) {
            sukien = new ArrayList<>();
        }
        if (sukien.contains(item)) {
            return;
        }
        sukien.add(item);
    }
}