package logic;

import Controller.Transaction;

public class Return extends Transaction {
	ProductModel itemBack;
    
    public Return(ProductModel sitemBack){
        itemBack = sitemBack; 
        
    }

@Override
	public void run() {
		//Inventory.add(itemBack);
		System.out.println("you have been refunded "+itemBack.cost+" dollars");
	}


}
