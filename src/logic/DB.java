package logic;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver; 

public class DB {
	
	public static MysqlDataSource getDataSource(){
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("sql9170972");
		dataSource.setPassword("zw9tQ8q3uq");
		dataSource.setServerName("sql9.freemysqlhosting.net");
		dataSource.setDatabaseName("sql9170972");
		dataSource.setPortNumber(3306);
		return dataSource;
		
		
	}
	
	

}


