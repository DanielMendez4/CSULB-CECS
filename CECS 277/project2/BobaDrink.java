package project2;

import java.util.ArrayList;

/**
 * Models a boba drink
 * @author Daniel Menedez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class BobaDrink extends DrinkItem {
	
	private String baseTea;
	private String toppings;
	private String milkType;
	private ArrayList<String> toppingsList;
	private double totalCost;
	
	/**
	 * Default constructor
	 * **/
	public BobaDrink() {
		
		super();
		baseTea = "N/A";
		toppings = "N/A";
		milkType = "N/A";
		totalCost = 0.00;
		toppingsList = new ArrayList<String>();
	}
	
	/**
	 * Overloaded constructor
	 * @param drinkName - name of the drink
	 * @param sweetness - how sweet the drink is
	 * @param size - size of the drink
	 * @param baseTea - base tea of the drink
	 * @param toppings - toppings to be added
	 * @param milkType - type of milk for the drink
	 * **/
	public BobaDrink(String drinkName, String sweetness, String size, String baseTea, String toppings, String milkType) {
		
		super(drinkName, sweetness, size);
		this.baseTea = baseTea;
		this.toppings = toppings;
		this.milkType = milkType;
		toppingsList = new ArrayList<String>();
		totalCost = 0.00;
	}
	
	/**
	 * Gets the baseTea
	 * @return baseTea as a String
	 * **/
	public String getBaseTea() { return baseTea; }
	
	/**
	 * Gets the toppings
	 * @return toppings as a String
	 * **/
	public String getToppings() { return toppings; }
	
	/**
	 * Gets the milkType
	 * @return milkType as a String
	 * **/
	public String getMilkType() { return milkType; }
	
	/**
	 * Sets the baseTea
	 * @param newBaseTea - base tea of the boba
	 * **/
	public void setBaseTea(String newBaseTea) { baseTea = newBaseTea; }
	
	/**
	 * Sets the toppings
	 * @param newToppings - toppings for the boba
	 * **/
	public void setToppings(String newToppings) { toppings = newToppings; }
	
	/**
	 * Sets the milkType
	 * @param newMilkType - milk type for the boba
	 * **/
	public void setMilkType(String newMilkType) { milkType = newMilkType; }
	
	/**
	 * Adds a topping to a toppings list
	 * @param moreTopping - topping to be added
	 * **/
	public void addTopping(String moreTopping) { toppingsList.add(moreTopping); }
	
	/**
	 * Gets the toppings list
	 * @return toppingsList as an ArrayList<String>
	 * **/
	public ArrayList<String> getToppingsList()  { return toppingsList; }
	
	/**
	 * Gets the cost of the drink
	 * @return totalCost as a Double
	 * **/
	public double getCost() {
			
			if (super.getSize() == "Small") { totalCost = 2.00; }
			
			if (super.getSize() == "Medium") { totalCost = 2.50; }
			
			if (super.getSize() == "Large") { totalCost = 3.00; }
			
			if (toppingsList.get(0) == "No Topping") {
				
				totalCost += 0.00;
				
			} else {
				
				for (int i = 0; i < toppingsList.size(); i++) { totalCost += .50; }
			}
			return totalCost;
	}
}