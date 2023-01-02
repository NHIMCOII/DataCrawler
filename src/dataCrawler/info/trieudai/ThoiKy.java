package dataCrawler.info.trieuDai;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tool.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class ThoiKy {
    protected String ten;
    protected String moTa;
    protected ArrayList<TrieuDai> trieuDai = new ArrayList<>();
    protected ArrayList<String> links = new ArrayList<>();

    public ThoiKy() {
    }

    public ThoiKy(String ten, String moTa) {
        this.ten = ten;
        this.moTa = moTa;
    }

    public static Map getInfoFromVietYCoTruyen() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");
        Map m = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        final Document doc = Jsoup.connect("http://vietycotruyen.com.vn/cac-trieu-dai-viet-nam-qua-tung-thoi-ky-lich-su")
                .ignoreContentType(true)
                .timeout(0)
                .get();
        System.out.println(doc.select("table tbody tr:not(tr:nth-of-type(1)) "));
        return m;
    }

    public static Map getInfoFromNguoiKeSu(ArrayList<String> urls) throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        Map m = new LinkedHashMap();
        int i = 0;
        Element result;

        for (String url : urls) {
            final Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            ThoiKy thoiKy = new ThoiKy();
            thoiKy.addLink(url);
//            byte arr[] = doc.selectFirst(".subheading-category").text().getBytes("UTF-8");
//            String value = new String(arr, "UTF-8");
            thoiKy.ten = doc.selectFirst(".subheading-category").text();
            thoiKy.moTa = doc.selectFirst(".clearfix.category-desc").text();
            for (Element item : doc.select("div.items-leading > div:not(.advertise-box)")) {
                TrieuDai trieuDai = new TrieuDai(item.selectFirst(".page-header > h2 > a").text(), item.select("p:not(.readmore)").text());
                trieuDai.addLink("https://nguoikesu.com" + item.selectFirst(".page-header > h2 > a").attr("href"));
                thoiKy.addTrieuDai(trieuDai);
            }
            result = doc.selectFirst("li.pagination-next > a");
            if (result != null) {
                final Document nextDoc = Jsoup.connect("https://nguoikesu.com" + result.attr("href"))
                        .ignoreContentType(true)
                        .timeout(0)
                        .get();
                for (Element item : nextDoc.select("div.items-leading > div:not(.advertise-box)")) {
                    TrieuDai trieuDai = new TrieuDai(item.selectFirst(".page-header > h2 > a").text(), item.select("p:not(.readmore)").text());
                    trieuDai.addLink("https://nguoikesu.com" + item.selectFirst(".page-header > h2 > a").attr("href"));
                    thoiKy.addTrieuDai(trieuDai);
                }
            }
            m.put(Tool.normalizeKey(thoiKy.ten), thoiKy);
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
}
