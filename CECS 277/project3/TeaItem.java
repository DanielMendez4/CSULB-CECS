package project3;

import java.util.ArrayList;

/**
 * Models a tea item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class TeaItem extends DrinkItem {
	
	private ArrayList<String> toppings;
	
	/**
	 * Default constructor
	 * **/
	public TeaItem() {
		
		super();
	}
	
	/**
	 * Overloaded constructor
	 * @param size - S, M, or L
	 * @param flavor - green tea, black tea, jasmine green tea, rose tea, oolong tea
	 * @param sweetness - full, 3/4, 1/2, 1/4, unsweetened
	 * @param milk - whole milk, half-and-half, no milk
	 * **/
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		
		super("Boba Tea", size, flavor, sweetness, milk);
		toppings = new ArrayList<String>();
	}
	
	/**
	 * Adds topping to the tea order
	 * **/
	public void addTopping(String newTopping) {
		
		toppings.add(newTopping);
	}
	
	/**
	 * Gets the toppings
	 * @return toppings as an ArrayList
	 * **/
	public ArrayList<String> getToppings() { return toppings; }
	
	/**
	 * Calculates the cost of a particular TeaItem
	 * @return total cost of TeaItem
	 * **/
	public double calculateCost() {
		
		double totalCost = 0.00;
		
		switch(getSize()) {
		case "S": totalCost = 2.50; break;
		case "M": totalCost = 3.00; break;
		case "L": totalCost = 3.50; break;
		default: totalCost = 0.00; break;
		}
		
		if (!getMilk().equals("No Milk")) { totalCost += 0.25; }
		
		for (int i = 0; i < toppings.size(); i++) {
			totalCost += 0.25;
		}
		return totalCost;
	}
	
	/**
	 * Prints the TeaItem
	 * @return formatted string of the TeaItem
	 * **/
	public String toString() {
		
		String formatCost = String.format("%.2f", calculateCost());
		
		String allToppings[] = new String[getToppings().size()];
		
		for (int i = 0; i < allToppings.length; i++) { allToppings[i] = getToppings().get(i); }
		
		String joinToppings = String.join(", ", allToppings);
		
		return getFlavor() + " " + getName() + " (" + getSize() + ")\t\t$" + formatCost + "\n\tSweetness: " + getSweetness() + "\n\tMilk: " + getMilk() + "\n\tToppings: " + joinToppings + "\n";
	}

}
