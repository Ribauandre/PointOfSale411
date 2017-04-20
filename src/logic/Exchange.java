package logic;

import Controller.Transaction;

public class Exchange extends Transaction {
	 ProductModel itemBack;
	   ProductModel itemTo;
	        
	    
	    public void Exchanging (ProductModel sitemBack, ProductModel sitemTo) {
	        itemBack = sitemBack;
	        itemTo = sitemTo;
	        
	        
	    }
	        

	    @Override
	    public void run() {
	        
	       for (int i = 0; i < Inventory.sizd(); i++) {
	            synchronized(Inventory) {
	            if (Inventory.get(i).iD == itemTo.iD) {
	                Inventory.add(itemBack);
	                Inventory.remove(i);
	            }

	            } 

	        }
	    }

}
