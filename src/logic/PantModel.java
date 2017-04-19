package logic;

public class PantModel extends ProductModel {
	
	String pantDescription;
	String pantName;
	int waistSize;
	int pantLength;
	
	public PantModel(String prodName, String prodD, double price, double code) {
		super(prodName, prodD, price, code);
		pantDescription = prodD;
		pantName = prodName; 
	}
	
	
	public void pantSize(int waist, int length){
		waist = this.waistSize;
		length = this.pantLength; 
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


	public int getWaistSize() {
		return waistSize;
	}


	public void setWaistSize(int waistSize) {
		this.waistSize = waistSize;
	}


	public int getPantLength() {
		return pantLength;
	}


	public void setPantLength(int pantLength) {
		this.pantLength = pantLength;
	}
	
	
	
}
 