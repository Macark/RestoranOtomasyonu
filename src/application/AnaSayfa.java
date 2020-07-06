package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnaSayfa {

    @FXML
    private AnchorPane Anchor1;

    @FXML
    private Button btnMasa;

    @FXML
    private Button btnUrunler;

    @FXML
    private Button btnPersoneller;

    @FXML
    private Button btn_Cýkýs;

    @FXML
    private Button btn_Hakkýmýzda;
    @FXML
    private Button btnSiparis;
    @FXML
    private AnchorPane anchor2;

    @FXML
    void btn_ClickCýkýs(ActionEvent event) {
    	try{
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            btn_Cýkýs.getScene().getWindow().hide();
            stage.setScene(new Scene(root));
            stage.show();
            }
            catch(Exception e){
                System.out.println(e.toString());
            }

    	
    		 
    		
    		

    		 
    }

    @FXML
    void btn_ClickHakkýmýzda(ActionEvent event) {
    	try {
    		AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Hakkimizda.fxml"));
    		anchor2.getChildren().setAll(pane1);
    		
    		

    		 } catch (IOException e) { e.printStackTrace(); }


    }

    @FXML
    void btn_ClickMasa(ActionEvent event) {
    	try {
    		AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Rezervasyon.fxml"));
    		anchor2.getChildren().setAll(pane1);
    		
    		

    		 } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    void btn_ClickPersoneller(ActionEvent event) {
    	try {
    		AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Personeller.fxml"));
    		anchor2.getChildren().setAll(pane1);
    		
    		

    		 } catch (IOException e) { e.printStackTrace(); }

    }

    @FXML
    void btn_ClickUrunler(ActionEvent event) {
    	try {
    		AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Urunler.fxml"));
    		anchor2.getChildren().setAll(pane1);
    		
    		

    		 } catch (IOException e) { e.printStackTrace(); }

    }
    @FXML
    void btn_ClickSiparis(ActionEvent event) {
    	try {
    		AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Siparisler.fxml"));
    		anchor2.getChildren().setAll(pane1);
    		
    		

    		 } catch (IOException e) { e.printStackTrace(); }

    }

}
