package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import veritabani.connection;


public class LoginController {

   
    @FXML
    private PasswordField txtsifre;


    @FXML
    private TextField txtadi;

    @FXML
    private Slider slidergiris;

    @FXML
    private Button btnGirisYap;

    @FXML
    private Button btnKayýtOl;

    @FXML
    private Label lblSayi1;

    @FXML
    private Label lblSayiSonuc;

    @FXML
    private Label lblSayi2;
    
    @FXML
    private Label lblSonuc;
    
    private Button giris;
    
    Stage dialogState=new Stage();
    Scene scene;
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    PreparedStatement sorguIfadesi1=null;
    ResultSet getirilen=null;
    String sql;

    public LoginController() {
    	baglanti =connection.Baglan();
    }
    

    @FXML
    void btnClickGirisYap(ActionEvent event) throws SQLException {
    	baglanti=connection.Baglan();

    	
    	sql = "SELECT * FROM login where Kulanici_Adi = ? and sifre = ?";
    try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtadi.getText().trim());
    		sorguIfadesi.setString(2, txtsifre.getText().trim());
    		ResultSet getirilen=sorguIfadesi.executeQuery();
	
    			
    		if(getirilen.next()) {
        		
        		Stage stage1=new Stage();
        		btnGirisYap.getScene().getWindow().hide();
        		AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("AnaSayfa.fxml"));
        		Scene scene1=new Scene(pane1,900,600);
        		stage1.setScene(scene1);
        		stage1.show();
        			  		
        		}
        		else { 
        			Alert alert1=new Alert(Alert.AlertType.ERROR);
        			alert1.setTitle("Giriþ Yapýlamadý");
        			alert1.setHeaderText(null);
        			alert1.setContentText("Kullanýcý adý veya þifre hatalý");
        			alert1.showAndWait();
		
    					
		} }
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		
		}
    }
        
    
    @FXML
    void btnClickKayýtOl(ActionEvent event) {
    	try{
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Kayitol.fxml"));
            
           
            stage.setScene(new Scene(root));
            stage.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
    	
    	
    

}
    }





