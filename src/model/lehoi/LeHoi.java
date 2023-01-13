package model.lehoi;

import java.util.ArrayList;

public class LeHoi {


    protected String lichSu;            //Nguon goc
    protected String moTa;                //Tong quan di tich
    protected String luatLe;
    protected String sachThamKhao;
    protected ArrayList<String> links = new ArrayList<>();


    public LeHoi() {
        // TODO Auto-generated constructor stub
    }

    public LeHoi(String lichSu, String moTa, String luatLe, String sachThamKhao) {
        super();
        this.lichSu = lichSu;
        this.moTa = moTa;
        this.luatLe = luatLe;
        this.sachThamKhao = sachThamKhao;
    }

    public static LeHoi mergeRule(Object oldVal, Object newVal) {
        LeHoi v1 = (LeHoi) oldVal;
        LeHoi v2 = (LeHoi) newVal;
        if (v1.lichSu == null || v1.lichSu.equals("?")) {
            v1.lichSu = v2.lichSu;
        }
        if (v1.moTa == null || v1.moTa.equals("?")) {
            v1.moTa = v2.moTa;
        }
        if (v1.luatLe == null || v1.luatLe.equals("?")) {
            v1.luatLe = v2.luatLe;
        }
        if (v1.sachThamKhao == null || v1.sachThamKhao.equals("?")) {
            v1.sachThamKhao = v2.sachThamKhao;
        }
        return v1;
    }

    public String getLichSu() {
        return lichSu;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getLuatLe() {
        return luatLe;
    }

    public String getSachThamKhao() {
        return sachThamKhao;
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
