package logic;

public class ShirtModel extends ProductModel { // class to store getters and setters having to do with product

	String shirtSize; 
	String shirtDescription;
	String shirtName;
	
	public ShirtModel(String prodName, String prodD, double price, double code, int amountInv) { // constructor 
		super(prodName, prodD, price, code, amountInv);
		
		shirtName = prodName;
		shirtDescription = prodD;
	}


	
	public void shirtSize(String input){
		shirtSize.equals(input); 
	}
	
	public void setShirtName(String input){
		shirtName.equals(input);
	}
	
	public void setShirtDesc(String input){
		shirtDescription.equals(input);
	}
	
}
