package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory extends ProductModel {

	public Inventory(String prodName, String prodD, double price, double code, int amountInv) {
		super(prodName, prodD, price, code, amountInv);
		// TODO Auto-generated constructor stub
	}

	
	public ProductModel addItem(){
	Scanner scnr = new Scanner(System.in);
	System.out.println("Please input the product name: ");
	String userInput = scnr.nextLine();
	System.out.println("Please add a product description: ");
	String descriptionInput= scnr.nextLine();
	System.out.println("Please add a cost value: ");
	double costInput = scnr.nextDouble();
	System.out.println("Enter an item code: ");
	double newID = scnr.nextDouble();
	System.out.println("How much of this item do you have? ");
	int invAmountInput = scnr.nextInt(); 
	ProductModel newItem = new ProductModel(userInput,descriptionInput, costInput, newID, invAmountInput);
	return newItem; 
	
	}
	
	  static ArrayList<ProductModel> inventory = new ArrayList();
	    
	    public static void returnItem(ProductModel itemBack) {
	        inventory.add(itemBack);
	        System.out.println("you have been refunded "+itemBack.cost+" dollars");
	    
	    }


}
