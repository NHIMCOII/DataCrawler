package dataCrawler.info.sukien;

import java.util.ArrayList;

import dataCrawler.info.diadiem.DiaDiem;

public class SuKien extends DiaDiem{


	protected String dien_bien;
	protected String tai_lieu_tham_khao;
	protected ArrayList<String> dia_diem_lien_quan = new ArrayList<>();

	
	public SuKien() {
		// TODO Auto-generated constructor stub
	}
	public SuKien(String dien_bien, String tai_lieu_tham_khao, ArrayList<String> dia_diem_lien_quan) {
		super();
		this.dien_bien = dien_bien;
		this.tai_lieu_tham_khao = tai_lieu_tham_khao;
		this.dia_diem_lien_quan = dia_diem_lien_quan;
	}

	
	public String getDien_bien() {
		return dien_bien;
	}
	public String getTai_lieu_tham_khao() {
		return tai_lieu_tham_khao;
	}
	public ArrayList<String> getDia_diem_lien_quan() {
		return dia_diem_lien_quan;
	}
}
