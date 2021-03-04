package project3;

/**
 * Models a generic item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public abstract class Item {
	
	private String name;
	private double cost;
	
	/**
	 * Default constructor
	 * **/
	public Item() {
		
		name = "N/A";
		cost = 0.00;
	}
	
	/**
	 * Overloaded constructor
	 * @param name - name of the drink
	 * @param cost - cost of the drink
	 * **/
	public Item(String name, double cost) {
		
		this.name = name;
		this.cost = cost;
	}
	
	/**
	 * Sets the name of the item
	 * @param newName - name of the item
	 * **/
	public void setName(String newName) { name = newName; }
	
	/**
	 * Sets the cost of the item
	 * @param newCost - cost of the item
	 * **/
	public void setCost(double newCost) { cost = newCost; }
	
	/**
	 * Gets the name of the item
	 * @return name of the item
	 * **/
	public String getName() { return name; }
	
	/**
	 * Gets the cost of the item
	 * @return cost of the item
	 * **/
	public double getCost() { return cost; }
	
	/**
	 * Abstract method that calculates the cost of a particular item
	 * **/
	public abstract double calculateCost();
}