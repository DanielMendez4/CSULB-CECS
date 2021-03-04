package project3;

/**
 * Models a pastry item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-03-19
 * **/

public class PastryItem extends Item {
	
	private String flavor;
	private boolean isHeated;
	private final static double HEAT_PRICE = .25;
	
	/**
	 * Overloaded constructor
	 * @param pastryName - muffin, cheesecake slice, cookie, danish
	 * @param flavor -
	 * muffin: banana nut, blueberry, chocolate chip, coffee cake
	 * cheesecake slice: regular, cherry, blueberry
	 * cookie: oatmeal, white choo & macadamias, chocolate chip, double fudge
	 * danish: apple cinnamon, strawberry & cheese, double cheese
	 * @param isHeated - true if the pastry is heated, false otherwise
	 * **/
	public PastryItem(String pastryName, String flavor, boolean isHeated) {
		
		super(pastryName, 0.00);
		this.flavor = flavor;
		this.isHeated = isHeated;
	}
	
	/**
	 * Calculates the cost of a particular PastryItem
	 * @return total cost of the PastryItem
	 * **/
	public double calculateCost() {
		
		double totalCost = 0.00;
		
		switch(getName()) {
		case "Muffin": totalCost = 2.00; break;
		case "Cheesecake Slice": switch(flavor) {
								 case "Regular": totalCost = 4.00; break;
								 case "Cherry": totalCost = 4.50; break;
								 case "Blueberry": totalCost = 4.50; break;
								 default: totalCost = 0.00; break;
								 } break;
		case "Cookie": totalCost = 1.50; break;
		case "Danish": totalCost = 2.50; break;
		default: totalCost = 0.00; break;
		}
		
		if (isHeated) { totalCost += HEAT_PRICE; }
		
		return totalCost;
	}
	
	/**
	 * Prints the PastryItem
	 * @return formatted string of the PastryItem
	 * **/
	public String toString() {
		
		String formatCost = String.format("%.2f", calculateCost());
		
		String heating;
		
		if (isHeated) {
			heating = "Heated";
			return getName() + " (" + heating + ")\t\t$" + formatCost + "\n\t" + flavor + "\n"; 
		} else {
			return getName() + "\t\t$" + formatCost + "\n\t" + flavor + "\n";
		}	
	}
}
