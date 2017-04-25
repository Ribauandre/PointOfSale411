package logic;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import logic.DB;

public class Inventory extends ProductModel {
	static String name;
	static String productDesc; 
	static double cost;
	static double iD;
	static int quantity;

	public Inventory(String prodName, String prodD, double price, double code, int amountInv) {
		super(prodName, prodD, price, code, amountInv);
		// TODO Auto-generated constructor stub
	}

	
	  public static ArrayList<ProductModel> inventory = new ArrayList();
	    
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

				ResultSet rs = (ResultSet) ps.executeQuery();
				while (rs.next()) {
					
					
					ProductModel aProduct = new ProductModel(rs.getString("Name"), rs.getString("Description"), rs.getDouble("Price"),rs.getInt("StockID"), rs.getInt("StockCount"));
					inventory.add(aProduct);
					
		        }
				
				
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}  
		
		}
	    	
	    }

