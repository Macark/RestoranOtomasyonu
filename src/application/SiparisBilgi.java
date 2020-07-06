package application;

public class SiparisBilgi {
	int id;
	String Kategori;
	String Siparis;
	String Masa;
	
	public SiparisBilgi(int id,String Kategori,String Siparis,String Masa) {
		this.id=id;
		this.Kategori=Kategori;
		this.Siparis=Siparis;
		this.Masa=Masa;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKategori() {
		return Kategori;
	}
	public void setKategori(String kategori) {
		Kategori = kategori;
	}
	public String getSiparis() {
		return Siparis;
	}
	public void setSiparis(String siparis) {
		Siparis = siparis;
	}
	public String getMasa() {
		return Masa;
	}
	public void setMasa(String masa) {
		Masa = masa;
	}

}
