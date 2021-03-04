package week4;
/**
 * this models an item on grocery store receipt
 * Every item object can be updated if more products of the same type are scanned
 * 
 * RESPONSIBILITES:
 * 1. Get the name of the item
 * 2. Get/Update the quantity of this item
 * 3. Get/Update the unit price of this item
 * 4. Get/Update the sub total
 * **/
public class Item {
	
	private String itemName;
	private double unitPrice;
	private int qty;
	
	/* Every class should have at least a default constructor
	 * However, if one is not supplied, the compiler will simply initialize all instance variables to default values
	 * String or any other object - null; double - 0.0; int - 0; boolean - false
	 * ALLOWING THIS TO HAPPEN IS DANGEROUS
	 * THE PROGRAM USING OBJECTS FROM SUCH A CLASS CAN MISBEHAVE
	 * */
	
	/**
	 * default constructor, initializes name to be "N\A", and all other values to 0
	 * **/
	public Item() {
		itemName = "N\\A";
		unitPrice = 0;
		qty = 0;
	}
	
	/**
	 * overloaded constructor initializes the object with present data
	 * @param itemName - name of this item as a String
	 * @param qty - the quantity of this item as an int
	 * @param unitPrice - the unit price of this item as a double
	 * **/
	public Item(String itemName, int qty, double unitPrice) {
		this.itemName = itemName;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}
	
	/**
	 * gets the name of this item 
	 * @return the name as a String object
	 * **/
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * sets the name of this item
	 * @param itemName - the new name
	 * **/
	public void setName(String itemName) {
		this.itemName = itemName;
	}
		
	/**
	 * gets the number of items of this product that have been scanned
	 * @return the quantity as an integer
	 * **/
	public int getQty() {
		return qty;
	}
	
	/**
	 * increments the quantity of this item by 1
	 * **/
	public void updateQty() {
		qty++;
	}
	
	/**
	 * gets the unit price of this product
	 * @return the unit price as a double
	 * **/
	public double getPrice() {
		return unitPrice;
	}
	
	/**
	 * sets the unit price of this item
	 * @param unitPrice - the price of this item as a double
	 * **/
	public void setPrice(double unitPrice) {
		// instance var = parameter
		this.unitPrice = unitPrice; // this is a special keyword that stands in for the current object
		// by typing "this.unitPrice" we are accessing/modifying the instance variable "unitPrice" of the current object
	}
	
	/**
	 * returns the sub total due for this item
	 * @return the sub total as a double
	 * **/
	public double getSubtotal() {
		return qty * unitPrice;
	}
	
	/**
	 * this method tells the compiler what to print instead of the object address when the object of this class is printed
	 * @return formatted string with the information associated to this current object
	 * **/
	public String toString() {
		String info = String.format("%-50s%d@(%.2f)%25s$%.2f", this.itemName, this.qty, this.unitPrice, "", this.getSubtotal());
		return info;
	}
}
