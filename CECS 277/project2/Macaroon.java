package project2;

/**
 * Models a macaroon
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class Macaroon extends Cookie {
	
	private int macQuant;
	
	/**
	 * Default constructor
	 * **/
	public Macaroon() {
		
		super();
	}
	
	/**
	 * Overloaded constructor
	 * @param dessertName - name of the dessert
	 * @param quantity - how many desserts
	 * **/
	public Macaroon(String dessertName, int quantity) {
		
		super(dessertName, quantity);
		macQuant = 0;
	}
	
	public void setMacQuant(int newMacQuant) { macQuant = newMacQuant; }
	
	public int getMacQuant() { return macQuant; }
	
	/**
	 * Gets the cost of the dessert
	 * @return totalCost as a Double
	 * **/
	public double getCost() {
		
		double unitPrice = 0;
		double perThree = 4.00;
		double cost = 0;
		
		if (super.getDessertName() == "Chocolate Macaroon") { unitPrice = 1.50; }
		
		if (super.getDessertName() == "Green Tea Macaroon") { unitPrice = 1.75; }
		
		int trio = macQuant / 3;
		int leftover = macQuant % 3;
		
		while (trio >= 1) { cost += perThree; trio--; }
		
		return cost + (leftover * unitPrice);
	}
}
