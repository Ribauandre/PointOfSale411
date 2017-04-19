package logic;

import Controller.Transaction;

public class Order extends Transaction {
	 static double total;

	    public Order() {

	    }

	    @Override
	    public void run() {
	        int count = 0;
	  



	            for (int i = 0; i < ShoppingCart.cart.size(); i++) {
	                total = total + ShoppingCart.cart.get(i).cost;

	            }
	            
	        System.out.println("Your estimated total is: " + total );
	        
	    }

}
