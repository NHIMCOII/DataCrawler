package dataCrawler.links;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class ThoiKy_Links {
    private static ArrayList<String> thoiKy_nguoikesu = new ArrayList<>();
    private static ArrayList<String> thoiKy_thuvienlichsu = new ArrayList<>();

    public ThoiKy_Links() {
    }

    public static ArrayList<String> getThoiKy_nguoikesu() throws IOException {
        ThoiKy_Links.setThoiKy_nguoikesu();
        int size = thoiKy_nguoikesu.size();
        for (int i = size - 1; i > size / 2 - 1; i--) {
            thoiKy_nguoikesu.remove(i);
        }
//        printLinks(thoiKy_nguoikesu);
        return thoiKy_nguoikesu;
    }

    public static ArrayList<String> getThoiKy_thuvienlichsu() throws IOException {
        ThoiKy_Links.setThoiKy_thuvienlichsu();
//        printLinks(thoiKy_thuvienlichsu);
        return thoiKy_thuvienlichsu;
    }

    public static void setThoiKy_nguoikesu() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://nguoikesu.com/dong-lich-su";

        final Document doc = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();
        for (Element link : doc.select("div.jm-module-content.clearfix ul.jm-red.list-categories.title-star-ms li.level-0 > a[href]")) {
            thoiKy_nguoikesu.add("https://nguoikesu.com" + link.attr("href"));
        }
    }

    public static void setThoiKy_thuvienlichsu() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://thuvienlichsu.com/thoi-ky";

        final Document doc = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();

        for (Element link : doc.select("div.divide-content a[href]")) {
            thoiKy_thuvienlichsu.add("https://thuvienlichsu.com" + link.attr("href"));
        }
    }

    public static void printLinks(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
