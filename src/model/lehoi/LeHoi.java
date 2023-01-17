package model.lehoi;

import java.util.ArrayList;

public class LeHoi {


    protected String ten;
    protected String ngayAmLich;
    protected String viTri;
    protected String moTa;
    protected String lanDauToChuc;
    protected ArrayList<String> links = new ArrayList<>();
    protected ArrayList<String> nhanVat = new ArrayList<>();


    public LeHoi() {
        // TODO Auto-generated constructor stub
    }

    public static LeHoi mergeRule(Object oldVal, Object newVal) {
        LeHoi v1 = (LeHoi) oldVal;
        LeHoi v2 = (LeHoi) newVal;
        if (v1.ten == null || v1.ten.equals("?")) {
            v1.ten = v2.ten;
        }
        if (v1.ngayAmLich == null || v1.ngayAmLich.equals("?")) {
            v1.ngayAmLich = v2.ngayAmLich;
        }
        if (v1.viTri == null || v1.viTri.equals("?")) {
            v1.viTri = v2.viTri;
        }
        if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
        if (v1.lanDauToChuc == null || v1.lanDauToChuc.equals("?")) {
            v1.lanDauToChuc = v2.lanDauToChuc;
        }
        return v1;
    }

    public void addLink(String link) {
        if (links.contains(link)) {
            return;
        }
        links.add(link);
    }
}
