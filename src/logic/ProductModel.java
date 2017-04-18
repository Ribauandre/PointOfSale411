package logic;

public class ProductModel {
String name;
String productDesc; 
double cost;
double iD;

	public ProductModel(String prodName, String prodD, double price, double code){
		prodName = this.name;
		prodD = this.productDesc;
		price = this.cost;
		code = this.iD; 
	}

	public String getName() {
		return name;
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
		return iD;
	}

	public void setiD(double iD) {
		this.iD = iD;
	}
	
	
}
	
	
