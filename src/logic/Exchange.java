package logic;

import Controller.Transaction;
import logic.Inventory;

public class Exchange extends Transaction { // class allows for the exhange of products if needed
	 ProductModel itemBack; // item to be exhanged
	   ProductModel itemTo; // item to be exchanged for
	        
	    
	    public void Exchanging (ProductModel sitemBack, ProductModel sitemTo) { // constructor initializing objects
	        itemBack = sitemBack;
	        itemTo = sitemTo;
	        
	        
	    }
	        

	    @Override
	    public void run() { // run method for thread
	        
	       for (int i = 0; i < Inventory.inventory.size(); i++) {
	            synchronized(Inventory.inventory) {
	            if (Inventory.inventory.get(i).code == itemTo.code) { // replaces item in inventory array list
	                Inventory.inventory.add(itemBack);
	                Inventory.inventory.remove(i);
	            }

	            } 

	        }
	    }

}
