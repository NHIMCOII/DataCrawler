package dataCrawler.info.nhanvat;


public abstract class NhanVat {
    protected String ten;
    protected String sinh;
    protected String mat;
    protected String chucVu;

    public NhanVat() {
    }

    public NhanVat(String ten, String chucVu, String sinh, String mat) {
        this.chucVu = chucVu;
        this.ten = ten;
        this.sinh = sinh;
        this.mat = mat;
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

    public void sync(NhanVat obj) throws IllegalAccessException {
        this.ten = (this.ten == null) ? obj.ten : this.ten;
        this.chucVu = (this.chucVu == null) ? obj.chucVu : this.chucVu;
        this.sinh = (this.sinh == null) ? obj.sinh : this.sinh;
        this.mat = (this.mat == null) ? obj.mat : this.mat;
    }

}
