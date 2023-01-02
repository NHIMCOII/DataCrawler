package dataCrawler.info.trieuDai;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TrieuDai {
    protected String ten;
    protected String moTa;
    protected ArrayList<String> links = new ArrayList<>();

    public TrieuDai() {
    }

    public TrieuDai(String ten, String moTa) {
        this.ten = ten;
        this.moTa = moTa;
    }


    public static TrieuDai mergeRule(Object oldVal, Object newVal) {
        TrieuDai v1 = (TrieuDai) oldVal;
        TrieuDai v2 = (TrieuDai) newVal;
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
}
