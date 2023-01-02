package dataCrawler.info.nhanvat;


public class ChuTichNuoc extends NhanVat {


    protected String nhiemKy;
    protected String tienNhiem;
    protected String keNhiem;
    protected String phoChuTich;


    public ChuTichNuoc() {
        super();
    }

    public ChuTichNuoc(String ten, String tenKhac, String trieuDai, String sinh, String mat, String anTang, String chucVu,
                       String thanPhu, String thanMau, String chong, String tonGiao, String cuocDoi, String suNghiep, String nhiemKy, String tienNhiem, String keNhiem, String phoChuTich, String nguyenNhanMat, String queQuan, String dangPhai, String noiO, String danToc, String hocvan) {
        super(ten, tenKhac, trieuDai, sinh, mat, anTang, chucVu, thanPhu, thanMau, chong, tonGiao, cuocDoi, suNghiep, nguyenNhanMat, queQuan, dangPhai, noiO, danToc, hocvan);
        this.nhiemKy = nhiemKy;
        this.tienNhiem = tienNhiem;
        this.keNhiem = keNhiem;
        this.phoChuTich = phoChuTich;
    }

    public static ChuTichNuoc mergeRule(Object oldVal, Object newVal) {
        ChuTichNuoc v2 = (ChuTichNuoc) newVal;
        ChuTichNuoc v1 = (ChuTichNuoc) NhanVat.mergeRule(oldVal, newVal);
        if (v1.nhiemKy == null || v1.nhiemKy.equals("?")) {
            v1.nhiemKy = v2.nhiemKy;
        }
        if (v1.tienNhiem == null || v1.tienNhiem.equals("?")) {
            v1.tienNhiem = v2.tienNhiem;
        }
        if (v1.keNhiem == null || v1.keNhiem.equals("?")) {
            v1.keNhiem = v2.keNhiem;
        }
        if (v1.phoChuTich == null || v1.phoChuTich.equals("?")) {
            v1.phoChuTich = v2.phoChuTich;
        }
        return v1;
    }
}
