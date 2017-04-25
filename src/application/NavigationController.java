package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import logic.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import application.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import logic.DB;
import logic.Inventory;
import logic.LoginModel;
import logic.Person;


public class NavigationController implements Initializable{

	// Budget
	// Account View
	@FXML
	public static Button logButton;
	@FXML
	public ListView<String> products;
	

	public static Person loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass);
	
	@FXML
	public Text accountName;
   
	
	
	String name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Inventory.popInv();
		LoginModel.logPerson(LoginModel.user, LoginModel.pass);
		loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass );
		name = loginP.firstName+" "+loginP.lastName;
		accountName.setText(name);
		ObservableList<String> items =(ObservableList) FXCollections.observableArrayList ();
			
			for(int i = 0; i< Inventory.inventory.size(); i++){
				items.add(Inventory.inventory.get(i).getName());
				System.out.println(Inventory.inventory.get(i).getName());
			}
			
			
			products.setItems(items);
			products.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			        for(int i =0; i< Inventory.inventory.size(); i++){
			        	
		
			        	if(newValue.equals(Inventory.inventory.get(i).getName())){
			        		
			        
			        	}
			        	
			        	
			        }
			    }
			});

		
	}
	
	@FXML
	public void handelLogout(){
		loginP=null;
		Main.showPersonOverview();
		
	}
	public void accountClick(){
		Main.showAccount();
	}
	


	
	

}
