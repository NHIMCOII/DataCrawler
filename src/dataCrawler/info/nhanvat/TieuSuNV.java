package dataCrawler.info.nhanvat;

import java.util.ArrayList;

public class TieuSuNV extends NhanVat {


	protected String cuoc_doi;
	protected String su_nghiep;
	protected String tai_lieu_tham_khao;
	protected ArrayList<String> nv_cungthoiky = new ArrayList<>();

	
	public TieuSuNV() {
		// TODO Auto-generated constructor stub
	}
	public TieuSuNV(String cuoc_doi, String su_nghiep, String tai_lieu_tham_khao, ArrayList<String> nv_cungthoiky) {
		super();
		this.cuoc_doi = cuoc_doi;
		this.su_nghiep = su_nghiep;
		this.tai_lieu_tham_khao = tai_lieu_tham_khao;
		this.nv_cungthoiky = nv_cungthoiky;
	}
	
	
	public String getCuoc_doi() {
		return cuoc_doi;
	}
	public String getSu_nghiep() {
		return su_nghiep;
	}
	public String getTai_lieu_tham_khao() {
		return tai_lieu_tham_khao;
	}
	public ArrayList<String> getNv_cungthoiky() {
		return nv_cungthoiky;
	}
	
}
