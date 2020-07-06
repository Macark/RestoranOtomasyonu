package application;

public class KayitolBilgi {
int id;
String adi;
String sifre;

public KayitolBilgi(int id, String adi,String sifre) {
	this.id=id;
	this.adi=adi;
	this.sifre=sifre;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAdi() {
	return adi;
}
public void setAdi(String adi) {
	this.adi = adi;
}
public String getSifre() {
	return sifre;
}
public void setSifre(String sifre) {
	this.sifre = sifre;
}
}
