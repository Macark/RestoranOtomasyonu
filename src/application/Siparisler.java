package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import veritabani.connection;

public class Siparisler implements Initializable {

    @FXML
    private ComboBox<String> comboKategori;

    @FXML
    private ComboBox<String> ComboSiparis;

    @FXML
    private ComboBox<String> ComboMasaNumarasi;

    @FXML
    private TableView<SiparisBilgi> tbl_siparisler;

    @FXML
    private TableColumn<SiparisBilgi, Integer> col_id;

    @FXML
    private TableColumn<SiparisBilgi, String> col_kategori;

    @FXML
    private TableColumn<SiparisBilgi, String> col_siparis;

    @FXML
    private TableColumn<SiparisBilgi, String> col_masaNumarasi;
    @FXML
    private Button btnSiparisVer;

    @FXML
    private Button btnSiparisGüncel;

    @FXML
    private Button btnSiparisSil;
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    PreparedStatement sorguIfadesi1=null;
    ResultSet getirilen=null;
    String sql;
    String Masasec;
    String urunKategori;
    String siparis;

    ObservableList<SiparisBilgi> siparisData;
    
    public void Guncelle(TableView tbl) {
    	sql="select * from siparisler";
    	
    	ObservableList<SiparisBilgi> siparisData=FXCollections.observableArrayList();
    	try {
			
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		
    		
    		while(getirilen.next()) {
    			siparisData.add(new SiparisBilgi(getirilen.getInt("id"),getirilen.getString("kategori"),getirilen.getString("siparis"),			
    					getirilen.getString("masa")));
    		}
    	col_id.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, Integer>("id"));
    	col_kategori.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, String>("Kategori"));
    	col_siparis.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, String>("Siparis"));
    	col_masaNumarasi.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, String>("Masa"));
    	siparisData = connection.getBaglansiparis();
    	
    	tbl_siparisler.setItems(siparisData); 
    	System.out.println("baþarýlý");
		
    	} catch (Exception e) {
    		// TODO: handle exception
    	}
    }
    
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
   		
   		baglanti=connection.Baglan();
           if(baglanti==null)
           {
           	System.out.println("Baðlantý Kurulamadý");
           	}
           

         tbl_siparisler.setItems(siparisData); 
       	col_id.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, Integer>("id"));
    	col_kategori.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, String>("Kategori"));
    	col_siparis.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, String>("Siparis"));
    	col_masaNumarasi.setCellValueFactory(new PropertyValueFactory<SiparisBilgi, String>("Masa"));
        
       	ObservableList<String> urunKategori=FXCollections.observableArrayList("Sýcak Ýçecek","Soðuk Ýçecek","Yiyecek","Fast Food","Tatlý");
       	comboKategori.setItems(urunKategori);
       	
        ObservableList<String> Masasec=FXCollections.observableArrayList("Masa-1","Masa-2","Masa-3","Masa-4","Masa-5","Masa-6","Masa-7","Masa-8",
        		"Masa-9","Masa-10","Masa-11","Masa-12");
        ComboMasaNumarasi.setItems(Masasec);
        
        ObservableList<String> siparis=FXCollections.observableArrayList("Cola"," Sprite","Fanta","Su","Çay","Kebab","Ciðer"
        		,"Mercimek Çorbasý","Salata","Menemen","Künefe","Kadayýf");
        ComboSiparis.setItems(siparis);
       
    	siparisData = connection.getBaglansiparis();
       	tbl_siparisler.setItems(siparisData); 
       	
           
   	}
    public Siparisler() {
    	baglanti =connection.Baglan();
    }
    @FXML
    void ComboMasaNumarasi(ActionEvent event) {
    	Masasec=ComboMasaNumarasi.getValue();

    }

    @FXML
    void ComboSiparis(ActionEvent event) {
    	siparis=ComboSiparis.getValue();

    }

    @FXML
    void comboKategori(ActionEvent event) {
    	urunKategori=comboKategori.getValue();

    }
    @FXML
    void btn_ClickSiparisGüncel(ActionEvent event) throws SQLException{
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Siparis Güncelleme");
    	alert.setHeaderText("");
    	alert.setContentText("Güncellemek istediðinize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	baglanti=(Connection) connection.Baglan();
    	

    	SiparisBilgi siparisData;
    	siparisData= tbl_siparisler.getSelectionModel().getSelectedItem();
    	int value=siparisData.getId();
    	
     String sql = "update siparisler set kategori=?,siparis=?,masa=? where id='"+value+ "'";
  
   	try {
   		sorguIfadesi=baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1,urunKategori);
   		sorguIfadesi.setString(2,siparis);
   		sorguIfadesi.setString(3,Masasec);
   
   		sorguIfadesi.execute();
   		Guncelle(tbl_siparisler);
		

                } catch (Exception e) {
               

             }
   finally {
   	sorguIfadesi.close();
   	     	
   }}
    	else {
     		alert.close();
     	}

    }

    @FXML
    void btn_ClickSiparisSil(ActionEvent event)throws SQLException {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Siparis Güncelleme");
    	alert.setHeaderText("");
    	alert.setContentText("Güncellemek istediðinize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	baglanti=(Connection) connection.Baglan();

    	SiparisBilgi siparisData;
    	siparisData= tbl_siparisler.getSelectionModel().getSelectedItem();
    	int value=siparisData.getId();
    	
       String sql = "delete from siparisler where id='"+value+ "'";
  
   	try {
   		sorguIfadesi=baglanti.prepareStatement(sql);
    	sorguIfadesi.executeUpdate();
    	Guncelle(tbl_siparisler);
  

                } catch (Exception e) {   	

             }}
    	else {
     		alert.close();
     	}

    }

    @FXML
    void btn_ClickSiparisVer(ActionEvent event)throws SQLException {
    	baglanti=(Connection) connection.Baglan();

   	 String sql = "insert into siparisler(kategori,siparis,masa) values(?,?,?)";
  
   	try {
   	  
   		sorguIfadesi=baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1,urunKategori);
   		sorguIfadesi.setString(2,siparis);
   		sorguIfadesi.setString(3,Masasec);
   
   		sorguIfadesi.execute();
   		Guncelle(tbl_siparisler);
   		
   	    
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText("Siparis Ekleme");
           alert.setContentText("Siparis Ekleme Tamamlandý.");
           alert.showAndWait();
			

                } catch (Exception e) {
               	 Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Siparis Ekleme");
                    alert.setContentText("Siparis Ekleme Baþarýsýz Oldu.");
                    alert.showAndWait();
        			e.printStackTrace();

             }
   	finally {
   	   	sorguIfadesi.close();
   	   	     	
   	   }

    }

}
