package test;

import dataCrawler.info.diadiem.DiaDiem;
import dataCrawler.links.Diadiem_Links;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class DiaDiemTest {
    public static void main(String[] args) throws IOException {
        Map m = DiaDiem.getInfo_TVLS(Diadiem_Links.getDiaDiem_TVLS());
        Iterator entries = m.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String)entry.getKey();
            DiaDiem value = (DiaDiem) entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value.getTen());
        }
    }
}
