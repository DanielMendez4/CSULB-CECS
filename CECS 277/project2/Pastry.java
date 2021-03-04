package project2;

/**
 * Models a pastry
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class Pastry extends DessertItem {
	
	private int quantity;
	private double unitPrice;
	private String heatingOption;
	private double totalCost;
	
	/**
	 * Default constructor
	 * **/
	public Pastry() {
		
		super();
		quantity = 0;
		unitPrice = 0.00;
		heatingOption = "N/A";
		totalCost = 0.00;
	}
	
	/**
	 * Overloaded constructor
	 * @param dessertName - name of the dessert name
	 * @param quantity - number of dessert items
	 * @param heatingOption - option to heat the dessert
	 * **/
	public Pastry(String dessertName, int quantity, String heatingOption) {
		
		super(dessertName);
		this.quantity = quantity;
		this.heatingOption = heatingOption;
		totalCost = 0.00;
	}
	
	/**
	 * Gets the quantity
	 * @return quantity as an Integer
	 * **/
	public int getQuantity() { return quantity; }
	
	/**
	 * Gets the unitPrice
	 * @return unitPrice as a Double
	 * **/
	public double getUnitPrice() { return unitPrice; }
	
	/**
	 * Gets the heatingOption
	 * @return heatingOption as a String
	 * **/
	public String getHeatingOption() { return heatingOption; }
	
	/**
	 * Sets the quantity
	 * @param newQuantity - number of desserts
	 * **/
	public void setQuantity(int newQuantity) { quantity = newQuantity; }
	
	/**
	 * Sets the unit price
	 * @param newUnitPrice - unit price of the dessert
	 * **/
	public void setUnitPrice(double newUnitPrice) { unitPrice = newUnitPrice; }
	
	/**
	 * Sets the heating option
	 * @param newHeatingOption - option to heat the dessert
	 * **/
	public void setHeatingOption(String newHeatingOption) { heatingOption = newHeatingOption; }
	
	/**
	 * Gets the cost of the dessert
	 * @return totalCost as a Double
	 * **/
	public double getCost() {
		
		if (super.getDessertName() == "Croissant") { unitPrice = 1.50; }
		
		if (super.getDessertName() == "Danish") { unitPrice = 1.75; }
		
		if (heatingOption == "Yes") { totalCost = .50; }
		
		totalCost = totalCost + (unitPrice * quantity);
		
		return totalCost;
	}
}