package veritabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.PersonelBilgi;
import application.UrunBilgi;
import application.RezervasyonBilgi;
import application.SiparisBilgi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class connection {

	
	static Connection conn=null;
	public static Connection Baglan() {
		try {
			
		conn=DriverManager.getConnection("jdbc:mysql://localhost/restorantdb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
			
		}
	}
	   public static ObservableList<PersonelBilgi> getPersonel(){
	    	conn=connection.Baglan();
	        ObservableList<PersonelBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from personeller");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new PersonelBilgi(Integer.parseInt(rs.getString("id")), rs.getString("PersonelAdi"), rs.getString("PersonelSoyadi"), rs.getString("PersonelAdres"), rs.getString("PersonelTelefon"),rs.getString("PersonelDogumTarih")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	    
	     public static ObservableList<UrunBilgi> getUrun(){
	    	conn=connection.Baglan();
	        ObservableList<UrunBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from urunler");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new UrunBilgi(Integer.parseInt(rs.getString("id")), rs.getString("UrunAdi"), rs.getString("UrunKategori"), rs.getString("UrunFiyat")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    
	   }
	    public static ObservableList<RezervasyonBilgi> getBaglanrezerve(){
	    	conn=connection.Baglan();
	        ObservableList<RezervasyonBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from rezervasyon");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new RezervasyonBilgi(Integer.parseInt(rs.getString("id")),rs.getString("isim"),rs.getString("telefonNumara"), rs.getString("masa"), rs.getString("tarih"), rs.getString("saat")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    
	   }
	    public static ObservableList<SiparisBilgi> getBaglansiparis(){
	    	conn=connection.Baglan();
	        ObservableList<SiparisBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from siparisler");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new SiparisBilgi(Integer.parseInt(rs.getString("id")),rs.getString("kategori"),rs.getString("siparis"), rs.getString("masa")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    
	   }
	    }
	   
	   
	   

	


