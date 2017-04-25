package logic;

public class ProductModel {
String name;
String productDesc; 
double cost;
double code;
int quantity;

	public ProductModel(String prodName, String prodD, double price, double iD, int amountInv){
		name = prodName;
		productDesc = prodD;
		cost = price;
		code = iD;
		quantity = amountInv;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int nQuantity) {
		quantity = nQuantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getiD() {
		return code;
	}

	public void setiD(double iD) {
		 iD = code;
	}
	
	
}
	
	
