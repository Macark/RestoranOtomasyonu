package application;

import java.sql.Date;
import java.time.LocalDate;

public class PersonelBilgi {
	Integer id;
	String personelAdi;
	String personelSoyadi;
	String personelAdres;
	String personelTelefon;
	String personelDogumTarihi;
	
	
	public PersonelBilgi(Integer id,String personelAdi ,String personelSoyadi,String personelAdres,String personelTelefon,String personelDogumTarihi) {
		this.id=id;
		this.personelAdi=personelAdi;
		this.personelSoyadi=personelSoyadi;
		this.personelAdres=personelAdres;
		this.personelTelefon=personelTelefon;
		this.personelDogumTarihi=personelDogumTarihi;
				
	}
	
	
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	public String getPersonelSoyadi() {
		return personelSoyadi;
	}
	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}
	public String getPersonelAdres() {
		return personelAdres;
	}
	public void setPersonelAdres(String personelAdres) {
		this.personelAdres = personelAdres;
	}
	public String getPersonelTelefon() {
		return personelTelefon;
	}
	public void setPersonelTelefon(String personelTelefon) {
		this.personelTelefon = personelTelefon;
	}
	public String getPersonelDogumTarihi() {
		return personelDogumTarihi;
	}
	public void setPersonelDogumTarihi(String personelDogumTarihi) {
		this.personelDogumTarihi = personelDogumTarihi;
	}

	
	

}
