package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import veritabani.connection;

public class Kayitol implements Initializable {

    @FXML
    private TextField txtKullanici;

    @FXML
    private PasswordField txtSifre;

    @FXML
    private Button btnKaydet;
   
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    PreparedStatement sorguIfadesi1=null;
    ResultSet getirilen=null;
    String sql;
    
    ObservableList<KayitolBilgi> kayitData;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
   		
   		baglanti=connection.Baglan();
           if(baglanti==null)
           {
           	System.out.println("Baðlantý Kurulamadý");
   	}}
    @FXML
     void btnClickKaydet(ActionEvent event)throws SQLException {
    	baglanti=(Connection) connection.Baglan();

     	 String sql = "insert into login(Kulanici_Adi,sifre) values(?,?)";
    
     	try {
     	  
     		sorguIfadesi=baglanti.prepareStatement(sql);
     		sorguIfadesi.setString(1,txtKullanici.getText());
     		sorguIfadesi.setString(2,txtSifre.getText());
     		
     		sorguIfadesi.execute();
     		
     		
     	    
  			Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Kullanýcý Kayýt Ekleme Ýþlemi");
             alert.setContentText("Kullanýcý Ekleme  Ýþlemi Tamamlandý.");
             alert.showAndWait();
  			

                  } catch (Exception e) {
                 	 Alert alert = new Alert(Alert.AlertType.ERROR);
                      alert.setHeaderText("Kullanýcý Kayýt Ekleme Ýþlemi");
                      alert.setContentText("Kullanýcý Ekleme  Ýþlemi  Baþarýsýz Oldu.");
                      alert.showAndWait();
          			e.printStackTrace();

               }
     finally {
     	sorguIfadesi.close();
     	     	
     }

   }

    }


