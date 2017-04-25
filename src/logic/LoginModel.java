package logic;

import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import application.Main;
import application.NavigationController;

import java.util.*;

public class LoginModel extends DB {
	Connection connection = null; 
	Statement statement = null; 
	ResultSet resultSet = null; 
	
	public static String name;
	public static String last;
	public static String user;
	public static String pass;
	
	
	

	public static boolean validate(String username, String pwd) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DB.getDataSource().getConnection();

			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from Accounts where UserName=? and Password=?");
			ps.setString(1, username);
			ps.setString(2, pwd);

			ResultSet rs = (ResultSet) ps.executeQuery();

			status = rs.next();
			con.close();
			logPerson(username, pwd);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
			return status;  
	}
	public static void logPerson(String username, String pwd) {
		boolean status = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DB.getDataSource().getConnection();

			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from Accounts where UserName=? and Password=?");
			ps.setString(1, username);
			ps.setString(2, pwd);

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("FirstNAme");
				last = rs.getString("LastName");
				user = rs.getString("UserName");
				pass = rs.getString("Password");
				
	            
	        }
			
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	
	}

	 }

