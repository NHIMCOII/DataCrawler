package model.diadiem;

import java.util.ArrayList;


public class DiaDiem {
    protected String ten;
    protected String lichSu;
    protected String khuVuc;
    protected String namThanhLap;
    protected String dienTich;
    protected ArrayList<String> links = new ArrayList<>();
    protected ArrayList<String> suKien = new ArrayList<>();
    protected ArrayList<String> nhanVat = new ArrayList<>();


    public DiaDiem() {
        // TODO Auto-generated constructor stub
    }

    public DiaDiem(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich) {
        this.ten = ten;
        this.lichSu = lichSu;
        this.khuVuc = khuVuc;
        this.namThanhLap = namThanhLap;
        this.dienTich = dienTich;
    }

    public static DiaDiem mergeRule(Object oldVal, Object newVal) {
        DiaDiem v1 = (DiaDiem) oldVal;
        DiaDiem v2 = (DiaDiem) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.lichSu == null || v1.lichSu.equals("?")) {
            v1.lichSu = v2.lichSu;
        }
        if (v1.khuVuc == null || v1.khuVuc.equals("?")) {
            v1.khuVuc = v2.khuVuc;
        }
        if (v1.namThanhLap == null || v1.namThanhLap.equals("?")) {
            v1.namThanhLap = v2.namThanhLap;
        }
        if (v1.dienTich == null || v1.dienTich.equals("?")) {
            v1.dienTich = v2.dienTich;
        }
        return v1;
    }

    public String getTen() {
        return ten;
    }

    public String getLichSu() {
        return lichSu;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public String getNamThanhLap() {
        return namThanhLap;
    }

    public String getDienTich() {
        return dienTich;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public ArrayList<String> getSuKien() {
        return suKien;
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

    public void addSuKien(String sukien) {
        if (suKien.contains(sukien)) {
            return;
        }
        suKien.add(sukien);
    }

    public void addNhanVat(String nhanvat) {
        if (nhanVat.contains(nhanvat)) {
            return;
        }
        nhanVat.add(nhanvat);
    }
}
