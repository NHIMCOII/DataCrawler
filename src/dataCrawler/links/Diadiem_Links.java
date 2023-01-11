package dataCrawler.links;

import dataCrawler.info.diadiem.DiaDiem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Diadiem_Links {
    private static ArrayList<String> diaDiem_TVLS = new ArrayList<>();
    private static ArrayList<String> diaDiem_Wiki = new ArrayList<>();

    public Diadiem_Links() {

    }

    public static ArrayList<String> getDiaDiem_TVLS() throws IOException {
        Diadiem_Links.setDiaDiem_TVLS();
        return diaDiem_TVLS;
    }

    public static void setDiaDiem_TVLS() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://thuvienlichsu.com/dia-diem?page=1";
        Document document = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();

        for (int i = 1; i <= 10; i++) {
            Elements elms = document.getElementsByClass("col-md-4");
            for (int j = 0; j < elms.size(); j++) {
                Elements elm_a = elms.get(j).getElementsByTag("a");
                if(elm_a.attr("href").equals("")) {
                    continue;
                }
                String link = "https://thuvienlichsu.com" + elm_a.attr("href");
                link = Diadiem_Links.removeAccent(link);
                diaDiem_TVLS.add(link);
            }
            url = url.replace(Integer.toString(i), Integer.toString(i + 1));
        }
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                .replace("(", "")
                .replace(")", "")
                .replace("đ", "d")
                .replace("Đ", "d");
    }

    public static void printLinks(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
