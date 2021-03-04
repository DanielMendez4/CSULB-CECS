package project2;

/**
 * Models a cookie
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class Cookie extends DessertItem {
	
	private int quantity;
	
	/**
	 * Default constructor
	 * **/
	public Cookie() {
		
		super();
		quantity = 0;
	}
	
	/**
	 * Overloaded constructor
	 * @param dessertName - name of the dessert
	 * @param quantity - how many dessert items
	 * **/
	public Cookie(String dessertName, int quantity) {
		
		super(dessertName);
		this.quantity = quantity;
	}
	
	/**
	 * Gets the quantity
	 * @return quantity as an Integer
	 * **/
	public int getQuantity() { return quantity; }
	
	/**
	 * Sets the quantity
	 * @param newQuantity - number of desserts
	 * **/
	public void setQuantity(int newQuantity) { quantity = newQuantity; }
	
	/**
	 * Gets the cost of the dessert
	 * @return totalCost as a Double
	 * **/
	public double getCost() {
		
		double unitPrice = 0;
		double perDozen = 6.00;
		double cost = 0;
		
		if (super.getDessertName() == "Chocolate Cookie") { unitPrice = 1.00; }
		
		if (super.getDessertName() == "Peanut Butter Cookie") { unitPrice = 1.25; }
		
		int dozens = quantity / 12;
		int leftover = quantity % 12;
		
		while (dozens >= 1) { cost += perDozen; dozens--; }
		
		return cost + (leftover * unitPrice);
		
	}
}