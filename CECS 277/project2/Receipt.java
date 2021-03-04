package project2;

import java.util.ArrayList;

/**
 * Models a receipt for an individual item
 * @author Daniel Mendez
 * @version 1.0.0
 * @since 2019-02-27
 * **/
public class Receipt {
	
	private ArrayList<DrinkItem> myDrinks;
	private ArrayList<DessertItem> myDesserts;
	private ArrayList<Coupon> myCoupons;
	
	private static double taxRate = .10;
	
	/**
	 * Default constructor
	 * **/
	public Receipt() {
		
		myDrinks = new ArrayList<DrinkItem>();
		myDesserts = new ArrayList<DessertItem>();
		myCoupons = new ArrayList<Coupon>();
	}
	
	/**
	 * Adds a drink item to ArrayList<DrinkItem>
	 * @param newDrink - DrinkItem to be added
	 * **/
	public void addDrink(DrinkItem newDrink) { myDrinks.add(newDrink); }
	
	/**
	 * Adds a dessert item to ArrayList<DessertItem>
	 * @param newDessert - DessertItem to be added
	 * **/
	public void addDessert(DessertItem newDessert) { myDesserts.add(newDessert); }
	
	/**
	 * Adds a coupon to ArrayList<Coupon>
	 * @param newCoupon - Coupon to be added
	 * **/
	public void addCoupon(Coupon newCoupon) { myCoupons.add(newCoupon); }
	
	/**
	 * Gets the ArrayList myDrinks
	 * @return myDrinks as an ArrayList<DrinkItem>
	 * **/
	public ArrayList<DrinkItem> getDrinks() { return myDrinks; }
	
	/**
	 * Gets the ArrayList myDesserts
	 * @return myDesserts as an ArrayList<DessertItem>
	 * **/
	public ArrayList<DessertItem> getDesserts() { return myDesserts; }
	
	/**
	 * Gets the myCoupons
	 * @return myCoupons as an ArrayList<Coupons>
	 * **/
	public ArrayList<Coupon> getCoupons() { return myCoupons; }
	
	/**
	 * Gets the discount drink price
	 * @return discountDrink as a Double
	 * **/
	public double applyDrinkCoupon() {
		
		double discountDrink;
		
		if (getCoupons().isEmpty()) { discountDrink = 0.00; }
		
		else if (getCoupons().get(0).getItemType() == "Drink") {
			
			double maxDrink = getDrinks().get(0).getCost();
			
			for (int i = 1; i < getDrinks().size(); i++) {
				
				if (getDrinks().get(i).getCost() > maxDrink) {
					
					maxDrink = getDrinks().get(i).getCost();
				}
			}
			discountDrink = maxDrink * getCoupons().get(0).getDiscount();
		}
		
		else { discountDrink = 0.00; }
		
		return discountDrink;
	}
	
	/**
	 * Gets the discount dessert price
	 * @return discountDessert as a Double
	 * **/
	public double applyDessertCoupon() {
		
		double discountDessert;
			
		if (getCoupons().isEmpty()) { discountDessert = 0.00; }
			
		else if (getCoupons().get(0).getItemType() == "Pastry") {
				
			double maxDessert = getDesserts().get(0).getCost();
				
			for (int i = 1; i < getDesserts().size(); i++) {
					
				if (getDesserts().get(i).getCost() > maxDessert) {
						
					maxDessert = getDesserts().get(i).getCost();
				}
			}
			discountDessert = maxDessert * getCoupons().get(0).getDiscount();
		}
			
		else { discountDessert = 0.00; }
		
		return discountDessert;
	}
	
	/**
	 * Gets the total cost of all the drinks
	 * @return drinkTotal as a Double
	 * **/
	public double getDrinkTotal() {
		
		double drinkTotal = 0.00;
		
		for (int i = 0; i < getDrinks().size(); i++) { drinkTotal += getDrinks().get(i).getCost(); }
		
		return drinkTotal - applyDrinkCoupon();
	}
	
	/**
	 * Gets the total cost of all the desserts
	 * @return dessertTotal as a Double
	 * **/
	public double getDessertTotal() {
		
		double dessertTotal = 0.00;
		
		for (int i = 0; i < getDesserts().size(); i++) { dessertTotal += getDesserts().get(i).getCost(); }
		
		return dessertTotal - applyDessertCoupon();
	}
	
	/**
	 * Gets the subtotal
	 * @return subtotal as a Double
	 * **/
	public double getSubtotal() {
		
		double subtotal = 0.00;
		
		subtotal = getDrinkTotal() + getDessertTotal();
		
		return subtotal;
	}
	
	/**
	 * Gets the grandTotal
	 * @return grandTotal as a Double
	 * **/
	public double getGrandTotal() {
		
		double grandTotal = 0.00;
		
		grandTotal = getSubtotal() + (getSubtotal() * taxRate);
		
		return grandTotal;
	}
	
	/**
	 * Formats the receipt
	 * @return the formated receipt as String
	 * **/
	public String formatReceipt() {
		
		String formatDrink = String.format("%.2f", getDrinkTotal());
		String formatDessert = String.format("%.2f", getDessertTotal());
		String formatSubtotal = String.format("%.2f", getSubtotal());
		String formatGrandTotal = String.format("%.2f", getGrandTotal());
		
		return getDrinks().size() + " drink(s)\t\t$" + formatDrink + "\n" + getDesserts().size() + " dessert(s)\t\t$" + formatDessert + "\nSubtotal (w/o Tax):\t$" + formatSubtotal + "\nGrand Total (w/ Tax):\t$" + formatGrandTotal;
	}
	
	/**
	 * Returns a string representation of this receipt
	 * @return formatReceipt() as a String
	 * **/
	public String toString() {
		
		return formatReceipt();
	}
}
