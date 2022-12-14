package dataCrawler.links;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Nhanvat_Links {
    private static ArrayList<String> vua_wiki = new ArrayList<>();
    private static ArrayList<String> chuTichNuoc_wiki = new ArrayList<>();
    private static ArrayList<String> nhanVat_nguoikesu = new ArrayList<>();

    Nhanvat_Links() {
    }

    public static ArrayList<String> getVua_wiki() throws IOException {
        Nhanvat_Links.setVua_wiki();
//        printLinks(vua_wiki);
        return vua_wiki;
    }

    public static ArrayList<String> getChuTichNuoc_wiki() throws IOException {
        Nhanvat_Links.setChuTichNuoc_wiki();
//        printLinks(chuTichNuoc_wiki);
        return chuTichNuoc_wiki;
    }

    public static ArrayList<String> getNhanVat_nguoikesu() throws IOException {
        Nhanvat_Links.setNhanVat_nguoikesu();
//        printLinks(nhanVat_nguoikesu);
        return nhanVat_nguoikesu;
    }


    private static void setVua_wiki() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://vi.wikipedia.org/wiki/Vua_Việt_Nam";

        final Document doc = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();

        for (Element table : doc.select("table")) {
            if (!table.select("tr th:nth-of-type(2):containsOwn(Vua)").text().equals("")
                    || !table.select("tr th:nth-of-type(2):containsOwn(Hoàng Đế)").text().equals("")) {
                for (Element link : table.select("tr td:nth-of-type(2) a[href^=/]")) {
                    vua_wiki.add("https://vi.wikipedia.org" + link.attr("href"));
                }
            }
        }
    }

    private static void setChuTichNuoc_wiki() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://vi.wikipedia.org/wiki/Danh_sách_Chủ_tịch_nước_Việt_Nam";

        final Document doc = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .get();

        for (Element table : doc.select("table.wikitable")) {
            for (Element link : table.select("tr td:nth-of-type(2) a[href^=/]")) {
                chuTichNuoc_wiki.add("https://vi.wikipedia.org" + link.attr("href"));
            }
        }
    }

    private static void setNhanVat_nguoikesu() throws IOException {
        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "8080");

        String url = "https://nguoikesu.com/nhan-vat?start=0";

// 		Append dataCrawler.info from all pages
//		5 characters each page & 291 pages
        for (int i = 0; i < 291; i += 5) {
            Document subDoc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            url = url.replace(Integer.toString(i), Integer.toString(i + 5));
            for (Element x : subDoc.select("h2 a")) {
                nhanVat_nguoikesu.add("https://nguoikesu.com" + x.attr("href"));
            }
        }
    }

    public static void printLinks(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

}
