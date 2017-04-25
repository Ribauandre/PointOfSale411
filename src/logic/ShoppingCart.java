package logic;

import java.util.ArrayList;

public class ShoppingCart {
	static ProductModel itemToAdd;
    public static ArrayList<ProductModel> cart = new ArrayList();

    public ShoppingCart(ProductModel sItemToAdd) {

        itemToAdd = sItemToAdd;
    }

    public void run() {

            cart.add(itemToAdd);

        

    }
}
