package application;

public class RezervasyonBilgi {
	int id;
	String isim;
	String telefon;
	String masa;
	String tarih;
	String saat;
	
	public RezervasyonBilgi(int id,String isim,String telefon,String masa,String tarih,String saat) {
		this.id=id;
		this.isim=isim;
		this.telefon=telefon;
		this.masa=masa;
		this.tarih=tarih;
		this.saat=saat;
				
		
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMasa() {
		return masa;
	}
	public void setMasa(String masa) {
		this.masa = masa;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getSaat() {
		return saat;
	}
	public void setSaat(String saat) {
		this.saat = saat;
	}
	
	

}
