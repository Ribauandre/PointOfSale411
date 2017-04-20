package logic;

import Controller.Transaction;
import logic.Inventory;

public class Exchange extends Transaction {
	 ProductModel itemBack;
	   ProductModel itemTo;
	        
	    
	    public void Exchanging (ProductModel sitemBack, ProductModel sitemTo) {
	        itemBack = sitemBack;
	        itemTo = sitemTo;
	        
	        
	    }
	        

	    @Override
	    public void run() {
	        
	       for (int i = 0; i < Inventory.inventory.size(); i++) {
	            synchronized(Inventory.inventory) {
	            if (Inventory.inventory.get(i).iD == itemTo.iD) {
	                Inventory.inventory.add(itemBack);
	                Inventory.inventory.remove(i);
	            }

	            } 

	        }
	    }

}
