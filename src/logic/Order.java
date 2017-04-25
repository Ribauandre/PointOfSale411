package logic;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import Controller.Transaction;
import application.Main;
import application.NavigationController;

public class  Order extends Transaction { // class dealing with a customer's order
	 static double total; // declaring basic objects used to manage the order
	 ProductModel product;
	 String name;
	 int stock;
	 

	    public Order(String nName, int nStock) { // constructor
	    	stock = nStock;
	    	name = nName;
	    	
	    	
	    	 

	    }

	    @Override
	    public synchronized void run() { // run method for thread
	    	 try
	 		{  
	    		
	 			Class.forName("com.mysql.jdbc.Driver");  
	 			Connection con = (Connection) DB.getDataSource().getConnection(); 
	 			String query = "UPDATE Product SET StockCount= ? WHERE Name=? ";
	 			   

	 		      
	 			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query); // allows for SQL command execution
	 			ps.setInt(1, stock );  
	 			ps.setString(2,name);
	 			ps.execute();

	 			con.close();	
	 		     
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
	 		}  
	 	  }
	        
	    }

