package project2;

import java.util.ArrayList;

/**
 * Models a cash register
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class CashRegister {
	
	private ArrayList<Receipt> totalSales;
	
	/**
	 * Default constructor
	 * **/
	public CashRegister() {
		
		totalSales = new ArrayList<Receipt>();
	}
	
	/**
	 * Adds a receipt the total sales
	 * @param newReceipt - Receipt to be added
	 * **/
	public void addReceipt(Receipt newReceipt) {
		
		totalSales.add(newReceipt);
	}
	
	/**
	 * Gets the ArrayList totalSales
	 * @return totalSales as an ArrayList<Receipt>
	 * **/
	public ArrayList<Receipt> getReceipts() {
		
		return totalSales;
	}
}
