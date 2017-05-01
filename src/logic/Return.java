package logic;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import Controller.Transaction;

public class Return extends Transaction {
	 static double total;
	 String name;
	 int stock;
	 ProductModel itemBack;
    
    public Return(ProductModel sitemBack, int updatedStock, String returnName){
        itemBack = sitemBack; 
        stock = updatedStock;
        name = returnName;
        
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



