package project2;

/**
 * Models a coffee drink
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class CoffeeDrink extends DrinkItem {
	
	private String coffeeBase;
	private double totalCost;
	
	/**
	 * Default constructor
	 * **/
	public CoffeeDrink() {
		
		super();
		coffeeBase = "N/A";
		totalCost = 0.00;
	}
	
	/**
	 * Overloaded constructor
	 * @param drinkName - name of the drink
	 * @param sweetness - how sweet the drink is
	 * @param size - size of the drink
	 * @param coffeeBase - base of the coffee
	 * **/
	public CoffeeDrink(String drinkName, String sweetness, String size, String coffeeBase) {
		
		super(drinkName, sweetness, size);
		this.coffeeBase = coffeeBase;
		totalCost = 0.00;
	}
	
	/**
	 * Gets the coffeeBase
	 * @return coffeeBase as a String
	 * **/
	public String getCoffeeBase() { return coffeeBase; }
	
	/**
	 * Sets the coffeBase
	 * @param newCoffeeBase - base of the coffee
	 * **/
	public void setCoffeeBase(String newCoffeeBase) { coffeeBase = newCoffeeBase; }
	
	/**
	 * Gets the cost of the drink
	 * @return totalCost as a Double
	 * **/
	public double getCost() {
		
		if (super.getSize() == "Small") { totalCost = 2.00; }
		
		if (super.getSize() == "Medium") { totalCost = 2.50; }
		
		if (super.getSize() == "Large") { totalCost = 3.00; }
		
		return totalCost;
	}
}
