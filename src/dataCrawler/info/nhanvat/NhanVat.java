package dataCrawler.info.nhanvat;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class NhanVat {
    protected String ten;
    protected String sinh;
    protected String mat;
    protected String chucVu;
    protected ArrayList<String> links = new ArrayList<>();

    public NhanVat() {
    }

    public NhanVat(String ten, String chucVu, String sinh, String mat) {
        this.chucVu = chucVu;
        this.ten = ten;
        this.sinh = sinh;
        this.mat = mat;
    }

    public static NhanVat mergeRule(Object oldVal, Object newVal) {
        NhanVat v1 = (NhanVat) oldVal;
        NhanVat v2 = (NhanVat) newVal;
        if (v1.chucVu == null || v1.chucVu.equals("?")) {
            v1.chucVu = v2.chucVu;
        }
        if (v1.sinh == null || v1.sinh.equals("?")) {
            v1.sinh = v2.sinh;
        }
        if (v1.mat == null || v1.mat.equals("?")) {
            v1.mat = v2.mat;
        }
        return v1;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getTen() {
        return ten;
    }

    public String getSinh() {
        return sinh;
    }

    public String getMat() {
        return mat;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }


}
