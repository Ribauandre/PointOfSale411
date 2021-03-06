package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import logic.*;
import javafx.animation.PauseTransition;
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


	@FXML
	public static Button logButton;
	@FXML
	public ListView<String> products;
	@FXML
    private DialogPane discrip;
	boolean isClicked;

	

	public static Person loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass);
	
	@FXML
	public Text accountName;
	@FXML
	public Text cartSize;
	
   
	
	
	String name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cartSize.setText(""+ShoppingCart.cart.size());
		Inventory.inventory.clear();
		Inventory.popInv();
		LoginModel.logPerson(LoginModel.user, LoginModel.pass);
		loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass );
		name = loginP.firstName+" "+loginP.lastName;
		accountName.setText(name);
		
		
		ObservableList<String> items =(ObservableList) FXCollections.observableArrayList ();
			
			
			if(items.size()==0){
				for(int i = 0; i< Inventory.inventory.size(); i++){
				items.add(Inventory.inventory.get(i).getName());
				products.setItems(items);
				
				}
			}
			
			
			
    			
				
    			
    			
    			
			products.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			    	
			        for(int i =0; i< Inventory.inventory.size(); i++){
			        	if(newValue.equals(Inventory.inventory.get(i).getName())){
			        		double cost = Inventory.inventory.get(i).getCost();
			        		String dis = Inventory.inventory.get(i).getProductDesc();
			        		int stk = Inventory.inventory.get(i).getQuantity();
			        		
			        		if(Inventory.inventory.get(i).getQuantity() >0 ){
			        			discrip.setContentText("Price: "+cost+"\n"+"Stock: "+stk+"\n"+dis);
				
			        		}
			        		if(Inventory.inventory.get(i).getQuantity() <= 0){
			        			
			        			discrip.setContentText("Price: "+cost+"\n"+"Stock: "+"OUT OF STOCK"+"\n"+dis);
			        		}
			        		
							
			        			
			        		
			        
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
	public void CartClick(){
		Main.showCart();
	}
	public void accountClick(){
		Main.showAccount();
	}
	public void addToCartClick(){
		for(int i =0; i< Inventory.inventory.size(); i++){
			if(products.getSelectionModel().getSelectedItem().equals(Inventory.inventory.get(i).getName())){
			
			ShoppingCart.cart.add(Inventory.inventory.get(i));
			
			cartSize.setText(""+ShoppingCart.cart.size());
			
			
			}
		}
	}
	public void returnClick(){
		for(int j = 0; j < Inventory.inventory.size(); j++){
			if(products.getSelectionModel().getSelectedItem().equals(Inventory.inventory.get(j).getName())){
				ProductModel returnProd = new ProductModel(Inventory.inventory.get(j).getName(), Inventory.inventory.get(j).getProductDesc(), (-Inventory.inventory.get(j).getCost()), (-Inventory.inventory.get(j).getiD()), Inventory.inventory.get(j).getQuantity());
			ShoppingCart.cart.add(returnProd);
			}
		}
	}
	public void checkoutClick(){
		Main.showCheckout();
	}


	
	

}
