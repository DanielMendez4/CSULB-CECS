package project3;

/**
 * Models a coffee item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class CoffeeItem extends DrinkItem {
	
	private String temperature;
	private String specialInstructions;
	
	/**
	 * Default constructor
	 * **/
	public CoffeeItem() {
		
		super();
		temperature = "N/A";
		specialInstructions = "N/A";
	}
	
	/**
	 * Overloaded constructor
	 * @param size - S, M, or L
	 * @param flavor - regular, mocha, hazelnut, or vanilla
	 * @param sweetness - 0 to 10 tps of sugar
	 * @param milk - whole milk, half-and-half, no milk
	 * @param temperature - hot, iced, or blended
	 * @param specialInstructions - additional user input
	 * **/
	public CoffeeItem(String size, String flavor, String sweetness, String milk, String temperature, String specialInstructions) {
		
		super("Coffee" ,size, flavor, sweetness, milk);
		this.temperature = temperature;
		this.specialInstructions = specialInstructions;
	}
	
	/**
	 * Caculates the cost of a particular CoffeeItem
	 * @return total cost of the CoffeeItem
	 * **/
	public double calculateCost() {
		
		double totalCost = 0.00;
		
		switch(getSize()) {
		case "S": totalCost = 1.00; break;
		case "M": totalCost = 1.50; break;
		case "L": totalCost = 2.00; break;
		default: totalCost = 0.00; break;
		}
		
		if (temperature == "Blended") { totalCost += 0.25; }
		
		if (!getMilk().equals("No Milk")) { totalCost += 0.25; }
		
		return totalCost;
	}
	
	/**
	 * Prints the CoffeeItem
	 * @return formatted string of the CoffeeItem
	 * **/
	public String toString() {
		
		String formatCost = String.format("%.2f", calculateCost());
		return getFlavor() + " " + getName() + " (" + getSize() + ")\t\t$" + formatCost + "\n\tSweetness: " + getSweetness() + "\n\tMilk: " + getMilk() + "\n\tTemperature: " + temperature + "\n\tSpecial Instructions: " + specialInstructions + "\n";
	}
}
