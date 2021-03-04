package project2;

/**
 * Models a generic dessert item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public abstract class DessertItem implements Comparable {
	
	private String dessertName;
	
	private String dessertOrder;
	private double subtotal;
	
	/**
	 * Default constructor
	 * **/
	public DessertItem() {
		
		dessertName = "N/A";
	}
	
	/**
	 * Overloaded constructor
	 * @param dessertName - name of the dessert
	 * **/
	public DessertItem(String dessertName) {
		
		this.dessertName = dessertName;
	}
	
	/**
	 * Gets the dessert name
	 * @return dessertName as a String
	 * **/
	public String getDessertName() { return dessertName; }
	
	/**
	 * Sets the dessert name
	 * @param newDessertName - name of the dessert
	 * **/
	public void setDessertName(String newDessertName) { dessertName = newDessertName; }
	
	/**
	 * Sets the dessert order
	 * @param dessertOrder - the full order of the dessert
	 * **/
	public void setDessertOrder(String newDessertOrder) { dessertOrder = newDessertOrder; }
	
	/**
	 * Returns a string representation of this DessertItem
	 * @return dessertOrder as a String
	 * **/
	public String toString() { return dessertOrder; }
	
	/**
	 * Abstract method that gets the cost of the drink
	 * **/
	public abstract double getCost();
	
	/**
	 * Compares two DrinkItem objects to see which one is larger
	 * @return temp as an Integer
	 * **/
	public int compareTo(Object arg0) {
			
			DessertItem otherDessert = (DessertItem) arg0;
			int temp;
			
			if (subtotal < otherDessert.subtotal) { temp = -1; } 
			
			else if (subtotal > otherDessert.subtotal) { temp = 1; } 
			
			else { temp = 0; }
			
			return temp;
	}
}
