package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import logic.LoginModel;
import logic.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
public class loginControler implements Initializable{
	@FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private DialogPane pleaseLog;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;
   
    
    
	
	@FXML
	private void handleCancle() {
		System.exit(0);
	}
	
	@FXML
	private void handleLogin() {
		String user1 = user.getText();
		String pass1 = pass.getText();
		
		
             
            
		if (LoginModel.validate(user1, pass1)){
			pleaseLog.setContentText("Login succesful!");
			
				
	        	Main.showNav();
	        	
	        	

	        	
	        	
	        			}
		else{
			
			
			Text text1=new Text("*invalid login");
			text1.setStyle("-fx-fill: red;");
			TextFlow flow = new TextFlow(text1);
			pleaseLog.setContent(flow);

			
		}
		
	}
	@FXML
	private void handleRegister() {
	        boolean okClicked = Main.showPersonEditDialog();
	        if (okClicked) {
	        	Main.showPersonEditDialog();
	        

	    } 
	        
}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
}

