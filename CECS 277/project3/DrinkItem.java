package project3;

/**
 * Models a drink item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19 
 * **/

public class DrinkItem extends Item {
	
	private String size;
	private String flavor;
	private String sweetness;
	private String milk;
	
	/**
	 * Default constructor
	 * **/
	public DrinkItem() {
		
		super();
		size = "N/A";
		flavor = "N/A";
		sweetness = "N/A";
		milk = "N/A";
	}
	
	/**
	 * Overloaded constructor
	 * @param drinkName - name of the drink
	 * @param size - size of the drink
	 * @param flavor - flavor of the drink
	 * @param sweetness - sweetness of the drink
	 * @param milk - type of milk to use
	 * **/
	public DrinkItem(String drinkName, String size, String flavor, String sweetness, String milk) {
		
		super(drinkName, 0.00);
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	
	/**
	 * Sets the size of the drink
	 * @param newSize - size to set
	 * **/
	public void setSize(String newSize) { size = newSize; }
	
	/**
	 * Sets the flavor of the drink
	 * @param newFlavor - flavor to set
	 * **/
	public void setFlavor(String newFlavor) { flavor = newFlavor; }
	
	/**
	 * Sets the sweetness of the drink
	 * @param newSweetness - sweetness to set
	 * **/
	public void setSweetness(String newSweetness) { sweetness = newSweetness; }
	
	/**
	 * Sets the milk type to use
	 * @param newMilk - milk to set
	 * **/
	public void setMilk(String newMilk) { milk = newMilk; }
	
	/**
	 * Gets the size of the drink
	 * @return size of the drink
	 * **/
	public String getSize() { return size; }
	
	/**
	 * Gets the flavor of the drink
	 * @return flavor of the drink
	 * **/
	public String getFlavor() { return flavor; }
	
	/**
	 * Gets the sweetness of the drink
	 * @return sweetness of the drink
	 * **/
	public String getSweetness() { return sweetness; }
	
	/**
	 * Gets the milk in the drink
	 * @return milk in the drink
	 * **/
	public String getMilk() { return milk; }
	
	/**
	 * Calculates the cost of a particular DrinkItem
	 * @return total cost of the DrinkItem
	 * **/
	public double calculateCost() { return 0; }
	
	/**
	 * Prints the DrinkItem
	 * @return formatted string of the DrinkItem
	 * **/
	public String toString() {
		
		return flavor + " " + getName() + " (" + size + ")\t\t$" + calculateCost() + "\n\t" + sweetness + "\n\t" + milk + "\n";
	}
}