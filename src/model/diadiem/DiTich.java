package model.diadiem;


public class DiTich extends DiaDiem {
    protected String viTri;
    protected String loai;
    protected String namCongNhan;


    public DiTich() {
        // TODO Auto-generated constructor stub
    }

    public DiTich(String ten, String lichSu, String khuVuc, String namThanhLap, String dienTich, String viTri, String loai,
                  String namCongNhan) {
        super(ten, lichSu, khuVuc, namThanhLap, dienTich);
        this.viTri = viTri;
        this.loai = loai;
        this.namCongNhan = namCongNhan;
    }

    public static DiTich mergeRule(Object oldVal, Object newVal) {
        DiTich v2 = (DiTich) newVal;
        DiTich v1 = (DiTich) DiaDiem.mergeRule(oldVal, newVal);
        if (v1.viTri == null || v1.viTri.equals("?")) {
            v1.viTri = v2.viTri;
        }
        if (v1.loai == null || v1.loai.equals("?")) {
            v1.loai = v2.loai;
        }
        if (v1.namCongNhan == null || v1.namCongNhan.equals("?")) {
            v1.namCongNhan = v2.namCongNhan;
        }
        return v1;
    }

    public String getViTri() {
        return viTri;
    }

    public String getLoai() {
        return loai;
    }

    public String getNamCongNhan() {
        return namCongNhan;
    }


}
