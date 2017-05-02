package logic;

public class AccountModel{
	
	String username; // declaring string objects
	String password; 
	int accountID; 
	
	public void Account (String userN, String pwd, int acntID){ // constructor
		username =userN;
		password = pwd;
		accountID = acntID; 
	}
	
	/*
	 * 
	 * 
	 * getters and setters for account objects
	 * 
	 * 
	 */
		
	public String getUsername(){ 
		return username; 
	}
	
	public void setUsername(String userN){
		this.username = userN; 
	}
	
	public String getPassword(){
		return password; 
	}
	
	public void setPassword(String pwd){
		this.password = pwd; 
	}
	
	public int getAccountIDs(){
		return accountID; 
	}
	
	public void setAccountIDs(int acntID){
		this.accountID = acntID; 
	}
	
	public double setSpending(){	
		return 0.00;
	}
}
	