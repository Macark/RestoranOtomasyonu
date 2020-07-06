package application;

public class UrunBilgi {
	Integer urunId;
	String urunAdi;
	String urunKategori;
	String urunFiyat;
	
	public UrunBilgi(Integer urunId, String urunAdi , String urunKategori, String urunFiyat) 
	{
		this.urunId=urunId;
		this.urunAdi=urunAdi;
		this.urunKategori=urunKategori;
		this.urunFiyat=urunFiyat;
				
		
	}
	
	public Integer getUrunId() {
		return urunId;
	}
	public void setUrunId(Integer urunId) {
		this.urunId = urunId;
	}
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public String getUrunKategori() {
		return urunKategori;
	}
	public void setUrunKategori(String urunKategori) {
		this.urunKategori = urunKategori;
	}
	public String getUrunFiyat() {
		return urunFiyat;
	}
	public void setUrunFiyat(String urunFiyat) {
		this.urunFiyat = urunFiyat;
	}
	
}
