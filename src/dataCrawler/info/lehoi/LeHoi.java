package dataCrawler.info.lehoi;

public class LeHoi {


	protected String lichSu;			//Nguon goc 
	protected String moTa;				//Tong quan di tich
	protected String luatLe;
	protected String sachThamKhao;
	protected String lienKetNgoai;

	
	public LeHoi() {
		// TODO Auto-generated constructor stub
	}
	public LeHoi(String lichSu, String moTa, String luatLe, String sachThamKhao, String lienKetNgoai) {
		super();
		this.lichSu = lichSu;
		this.moTa = moTa;
		this.luatLe = luatLe;
		this.sachThamKhao = sachThamKhao;
		this.lienKetNgoai = lienKetNgoai;
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
	public String getLienKetNgoai() {
		return lienKetNgoai;
	}
	
}
