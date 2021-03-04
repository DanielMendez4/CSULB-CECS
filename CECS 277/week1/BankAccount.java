package week1;

/**
 * Models a bank account with functionality to deposit, withdraw, and get balance
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-01-24
 * **/

public class BankAccount {
	
	// Instance variables
	private String acctNum;
	private double balance;
	private static int lastAcctNum = 0;
	
	/**
	 * Default constructor that creates a bank account with $0 balance
	 * **/
	public BankAccount() {
		lastAcctNum++;
		acctNum = Integer.toString(lastAcctNum);
		balance = 0;
	}
	
	/**
	 * Deposits a given amount into this account
	 * @param amt - the amount deposited as a double
	 * **/
	public void deposit(double amt) {
		balance += amt;
	}
	
	/**
	 * Withdraws a given amount from this account
	 * @param amt - the amount to be withdrawn as a double
	 * @return boolean - true if sufficient funds cover the withdraw, false otherwise
	 * **/
	public boolean withdraw(double amt) {
		balance -= amt;
		if (balance > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the current balance of this account
	 * @return double - the current balance
	 * **/
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Creates a String representation of this BankAccount object
	 * @return String with the account number and balance
	 * **/
	public String toString() {
		String s = String.format("Account #: " +"%s%nBalance: $%.2f", acctNum, balance);
		return s;
	}

}
