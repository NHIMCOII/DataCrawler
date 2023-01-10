package dataCrawler.model.sukien;

import java.util.ArrayList;

public class SuKien {
    protected String ten;
    protected String thoiGian;
    protected String dienBien;
    protected ArrayList<String> links = new ArrayList<>();
    protected ArrayList<String> diaDiem = new ArrayList<>();
    protected ArrayList<String> nhanVat = new ArrayList<>();


    public SuKien() {
        // TODO Auto-generated constructor stub
    }

    public SuKien(String ten, String thoiGian, String dienBien) {
        this.ten = ten;
        this.thoiGian = thoiGian;
        this.dienBien = dienBien;
    }

    public static SuKien mergeRule(Object oldVal, Object newVal) {
        SuKien v1 = (SuKien) oldVal;
        SuKien v2 = (SuKien) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.thoiGian == null || v1.thoiGian.equals("?")) {
            v1.thoiGian = v2.thoiGian;
        }
        if (v1.dienBien == null || v1.dienBien.equals("?")) {
            v1.dienBien = v2.dienBien;
        }
        return v1;
    }

    public String getTen() {
        return ten;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public String getDienBien() {
        return dienBien;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public ArrayList<String> getDiaDiem() {
        return diaDiem;
    }

    public ArrayList<String> getNhanVat() {
        return nhanVat;
    }

    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }

    public void addDiaDiem(String diadiem) {
        if (diaDiem.contains(diadiem)) {
            return;
        }
        diaDiem.add(diadiem);
    }

    public void addNhanVat(String nhanvat) {
        if (nhanVat.contains(nhanvat)) {
            return;
        }
        nhanVat.add(nhanvat);
    }
}
