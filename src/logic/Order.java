package logic;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import Controller.Transaction;
import application.Main;
import application.NavigationController;

public class  Order extends Transaction {
	 static double total;
	 ProductModel product;
	 String name;
	 int stock;
	 

	    public Order(String nName, int nStock) {
	    	stock = nStock;
	    	name = nName;
	    	
	    	
	    	 

	    }

	    @Override
	    public synchronized void run() {
	    	 try
	 		{  
	    		
	 			Class.forName("com.mysql.jdbc.Driver");  
	 			Connection con = (Connection) DB.getDataSource().getConnection(); 
	 			String query = "UPDATE Product SET StockCount= ? WHERE Name=? ";
	 			   

	 		      
	 			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
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

