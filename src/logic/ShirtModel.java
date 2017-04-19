package logic;

public class ShirtModel extends ProductModel {

	String size; 
	String shirtDescription;
	String shirtName;

	public ShirtModel(String prodName, String prodD, double price, double code) {
		super(prodName, prodD, price, code);
		shirtDescription = prodD;
		shirtName = prodName;
	}

	
	public void shirtSize(String input){
		size.equals(input); 
	}
}
