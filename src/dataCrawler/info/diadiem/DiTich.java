package dataCrawler.info.diadiem;

public class DiTich extends DiaDiem {

	protected String ten_DT;
	protected String loai;
	protected String nam;
	
	
	public DiTich() {
		// TODO Auto-generated constructor stub
	}
	public DiTich(String ten_DT, String loai, String nam) {
		super();
		this.ten_DT = ten_DT;
		this.loai = loai;
		this.nam = nam;
	}	
	
	
	public String getTen_DT() {
		return ten_DT;
	}
	public String getLoai() {
		return loai;
	}
	public String getNam() {
		return nam;
	}
}
