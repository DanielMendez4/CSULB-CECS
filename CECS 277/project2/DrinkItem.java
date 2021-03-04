package project2;

/**
 * Models a generic drink item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public abstract class DrinkItem implements Comparable {
	
	private String drinkName;
	private String sweetness;
	private String size;
	
	private String drinkOrder;
	private double subtotal;
	
	/**
	 * Default constructor
	 * **/
	public DrinkItem() {
		
		drinkName = "N/A";
		sweetness = "N/A";
		size = "N/A";
	}
	
	/**
	 * Overloaded constructor
	 * @param drinkName - name of the drink
	 * @param sweetness - how sweet the drink is
	 * @param size - size of the drink
	 * **/
	public DrinkItem(String drinkName, String sweetness, String size) {
		
		this.drinkName = drinkName;
		this.sweetness = sweetness;
		this.size = size;
	}
	
	/**
	 * Gets the drinkName
	 * @return drinkName as a String
	 * **/
	public String getDrinkName() { return drinkName; }
	
	/**
	 * Gets the sweetness
	 * @return sweetness as a String
	 * **/
	public String getSweetness() { return sweetness; }
	
	/**
	 * Gets the size
	 * @return size as a String
	 * **/
	public String getSize() { return size; }
	
	/**
	 * Sets the drinkName
	 * @param newDrinkName - name of the drink
	 * **/
	public void setDrinkName(String newDrinkName) { drinkName = newDrinkName; }
	
	/**
	 * Sets the sweetness
	 * @param newSweetness - sweetness of the drink
	 * **/
	public void setSweetness(String newSweetness) { sweetness = newSweetness; }
	
	/**
	 * Sets the size
	 * @param newSize - size of the drink
	 * **/
	public void setSize(String newSize) { size = newSize; }
	
	/**
	 * Sets the drinkOrder
	 * @param newDrinkOrder - the full order of the drink
	 * **/
	public void setDrinkOrder(String newDrinkOrder) { drinkOrder = newDrinkOrder; }
	
	/**
	 * Returns a string representation of this DrinkItem
	 * @return drinkOrder as a String
	 * **/
	public String toString() { return drinkOrder; }
	
	/**
	 * Abstract method that gets the cost of the drink
	 * **/
	public abstract double getCost();
	
	/**
	 * Compares two DrinkItem objects to see which one is larger
	 * @return temp as an Integer
	 * **/
	public int compareTo(Object arg0) {
		
		DrinkItem otherDrink = (DrinkItem) arg0;
		int temp;
		
		if (subtotal < otherDrink.subtotal) { temp = -1; } 
		
		else if (subtotal > otherDrink.subtotal) { temp = 1; } 
		
		else { temp = 0; }
		
		return temp;
	}
}
