package project2;

/**
 * This class models a coupon object with a given item to which it can be applied and a percentage amount discount
 * @author Katherine Varela
 * @version 1.0.0
 * @since 2019-02-12
 * **/
public class Coupon {
	
	private String itemType;
	private double percentDiscount;
	
	/**
	 * Default constructor
	 * **/
	public Coupon() {
		itemType = "Not a valid coupon.";
		percentDiscount = 0;
	}
	
	/**
	 * Creates a coupon with type of item it is applicable to and a percent discount
	 * @param item - type of item
	 * @param discount - the discount as a decimal percent
	 * **/
	public Coupon(String item, double discount) {
		itemType = item;
		percentDiscount = discount;
	}
	
	/**
	 * Gets the itemType of this coupon
	 * @return itemType as a String
	 * **/
	public String getItemType() { return itemType; }
	
	/**
	 * Gets the discount of this coupon
	 * @return the discount as a percent decimal 
	 * **/
	public double getDiscount() { return percentDiscount; }
	
	/**
	 * Sets the itemType of the coupon
	 * @param newItemType - item that specifies what the coupon applies to
	 * **/
	public void setItemType(String newItemType) { itemType = newItemType; }
	
	/**
	 * Sets the discount of the coupon
	 * @param newDiscount - discount given to the coupon
	 * **/
	public void setDiscount(double newDiscount) { percentDiscount = newDiscount; }
	
	/**
	 * Returns a string representation of this coupon that reads
	 * 'This coupon is valid for <discount amount>% off the most <item type> item.'
	 * @return the Coupon object as a string
	 * **/
	public String toString() {
		
		return String.format("This coupon is valid for %1.0f%% off the most expensive %s item.", percentDiscount * 100, itemType);
	}
}
