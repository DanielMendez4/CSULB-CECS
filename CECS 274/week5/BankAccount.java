package week5;

public class BankAccount implements Comparable<Object> {
	
	private int acctNum;
	private double bal;
	public static int lastAssignedNum = 100;
	public static double OVERDRAFT_FEE = 29.50;
	
	public BankAccount() {
		lastAssignedNum++;
		acctNum = lastAssignedNum;
		bal = 0;
	}
	
	public BankAccount(double initBal) {
		lastAssignedNum++;
		acctNum = lastAssignedNum;
		bal = initBal;
	}
	
	public void deposit(double amount) {
		bal += amount + computeTax(bal);
	}
	
	public void withdraw(double amount) {
		bal -= amount;
	}
	
	public double getBalance() {
		return bal;
	}
	
	public String toString() {
		return "Acct #: " + acctNum + "\t\tBalance: $" + bal;
	}

	public int compareTo(Object o) {
		BankAccount otherAccount = (BankAccount) o;
		
		if (this.bal < otherAccount.bal ) {
			return -1;
		} else if (this.bal == otherAccount.bal) {
			return 0;
		} else {
			return 0;
		}
	}
	
	/**
	 * projects savings of some account with given initial amount, interest rate, and compounding periods
	 * A static method acts on the class (can NOT modify the instance variables of an object
	 * Kept within the same class because its function is relevant to what the class represents
	 * **/
	public static double projectSavings(double initAmt, double rate, int compounding, int time) {
		return initAmt * Math.pow((1 + rate/compounding), time);
	}
	
	/**
	 * when static method declared private, called helper method
	 * its usage is restricted within class only
	 * Private static methods usually compute some data necessary for instance methods to fulfill their responsibilities
	 * this static method can NOT use/modify instance variables
	 * **/
	private static double computeTax(double amount) {
		return amount * 1.15;
	}
}
