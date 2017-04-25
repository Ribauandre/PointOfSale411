package logic;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import logic.DB;

public class Inventory extends ProductModel { // class containing inventory array list 
	static String name; // basic objects used to manage inventory
	static String productDesc; 
	static double cost;
	static double iD;
	static int quantity;

	public Inventory(String prodName, String prodD, double price, double code, int amountInv) { // constructor 
		super(prodName, prodD, price, code, amountInv);
		// TODO Auto-generated constructor stub
	}

	
	  public static ArrayList<ProductModel> inventory = new ArrayList(); // array list managing inventory
	    
	    public static void returnItem(ProductModel itemBack) {
	        inventory.add(itemBack);
	        System.out.println("you have been refunded "+itemBack.cost+" dollars");
	    
	    }
	    
	    public static void popInv(){
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DB.getDataSource().getConnection();

				PreparedStatement ps = (PreparedStatement) con
						.prepareStatement("select * from Product");

				ResultSet rs = (ResultSet) ps.executeQuery(); // executing SQL query
				while (rs.next()) {
					
					
					ProductModel aProduct = new ProductModel(rs.getString("Name"), rs.getString("Description"), rs.getDouble("Price"),rs.getInt("StockID"), rs.getInt("StockCount"));
					inventory.add(aProduct); // adding product to inventory array list
					
		        }
				
				
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}  
		
		}
	    	
	    }

