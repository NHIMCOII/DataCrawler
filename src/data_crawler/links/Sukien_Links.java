package data_crawler.links;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Sukien_Links {
    private static ArrayList<String> suKien_TVLS = new ArrayList<>();
    private static ArrayList<String> suKien_Wiki = new ArrayList<>();

    public Sukien_Links() {

    }

    public static ArrayList<String> getSuKien_TVLS() throws IOException {
        Sukien_Links.setSuKien_TVLS();
        return suKien_TVLS;
    }

    public static void setSuKien_TVLS() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://thuvienlichsu.com/su-kien?page=1";

        for (int i = 1; i <= 19; i++) {
            Document document = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            Elements cards = document.selectFirst("div[class=col-12 col-md-8]")
                    .select("div[class=col-md-8]");
            for (int j = 0; j < cards.size(); j++) {
                Element card_link = cards.get(j).getElementsByTag("a").first();
                if (card_link == null) {
                    continue;
                }
                String link = "https://m.thuvienlichsu.com" + card_link.attr("href");
                //link = Diadiem_Links.removeAccent(link);
                suKien_TVLS.add(link);
            }
            url = url.replace(Integer.toString(i), Integer.toString(i + 1));
        }
    }

    public static void printLinks(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
