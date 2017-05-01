package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import logic.ShoppingCart;
import logic.Inventory;
import logic.Order;
import logic.ProductModel;
import logic.Return;

public class CheckoutController implements Initializable{
	
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
		
		
	}
	@FXML
	private void handlePlaceOrder() {
		for(int i = 0; i< ShoppingCart.cart.size(); i++){
			int nStock = ShoppingCart.cart.get(i).getQuantity() - 1;
			ShoppingCart.cart.get(i).setQuantity(nStock);
			
		}
		for(int i = 0; i< ShoppingCart.cart.size(); i++){
			
			Order o1 = new Order(ShoppingCart.cart.get(i).getName(),ShoppingCart.cart.get(i).getQuantity());
            Thread order = new Thread(o1);
            order.start();
			}
		Main.showOrder();
		}
	
	private void handleReturnItem(){
		for(int j = 0; j< ShoppingCart.cart.size(); j++){
			int returnStock = ShoppingCart.cart.get(j).getQuantity() + 1;
			ShoppingCart.cart.get(j).setQuantity(returnStock);
			
		}
		
		for(int j = 0; j< ShoppingCart.cart.size(); j++){
			Return r1 = new Return(ShoppingCart.cart.get(j),ShoppingCart.cart.get(j).getQuantity(),ShoppingCart.cart.get(j).getName());
			Thread return1 = new Thread(r1);
			return1.start();
			
		}
		
	//Main.showReturn(); 
	}
	
	@FXML
	private void handleCancel() {
    	Main.showNav();
    }

}
