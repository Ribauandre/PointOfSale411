package logic;

public class PantModel extends ProductModel {

	String pantDescription;
	String pantName;
	String pantSize;

	public PantModel(String prodName, String prodD, double price, double code, int amountInv) {
		super(prodName, prodD, price, code, amountInv);
		pantName = prodName;
		pantDescription = prodD; 
		
	}

	
	
	public void pantSize(String input){
		input = this.pantSize;
		
	}

	public void setName(String input){
		pantName.equals(input);
	}
	
	public void setDescription(String input){
		pantDescription.equals(input);
	}

	public String getPantDescription() {
		return pantDescription;
	}


	public void setPantDescription(String pantDescription) {
		this.pantDescription = pantDescription;
	}


	public String getPantName() {
		return pantName;
	}


	public void setPantName(String pantName) {
		this.pantName = pantName;
	}



	
	
	
}
 