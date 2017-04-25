package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import logic.Inventory;
import logic.ShoppingCart;

public class CartController implements Initializable {
	
	@FXML
	public ListView<String> products;
	@FXML
	public Text cartTotal;
	public double total;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items =(ObservableList) FXCollections.observableArrayList ();
		
		for(int i = 0; i< ShoppingCart.cart.size(); i++){
			items.add(ShoppingCart.cart.get(i).getName()+"   "+ShoppingCart.cart.get(i).getCost());
			total = ShoppingCart.cart.get(i).getCost() + total;
			
		}
		cartTotal.setText(""+total);
		products.setItems(items);
		products.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        for(int i =0; i< ShoppingCart.cart.size(); i++){
		        	
	
		        	if(newValue.equals(ShoppingCart.cart.get(i).getName())){
		        		
		        			
		        		
		        
		        	}
		        	
		        	
		        }
		    }
		});
		
	}
	@FXML
	 private void handleCancel() {
	    	Main.showNav();
	    }
	public void checkoutClick(){
		Main.showCheckout();
	}

}