package project4;

public class Husky extends Dog {
	
	/**
	 * Default Constructor
	 * **/
	public Husky() {
		super();
	}
	/**
	 * Overloaded Constructor
	 * @param name - name of the dog
	 * @param weight - weight of the dog
	 * @param color - color of the dog
	 * @param gender - gender of the dog
	 * @param info - any additional info
	 * **/
	public Husky(String name, String weight, String color, String gender, String info) {
		super(name, weight, color, gender, info);
	}
	/**
	 * Allows for the cloning of an existing Husky
	 * @return a clone of the original Husky
	 * **/
	@Override
	public Dog Clone() throws CloneNotSupportedException {
		return new Husky(this.getName(), this.getWeight(), this.getColor(), this.getGender(), this.getInfo()); 
	}
	/**
	 * Prints the Husky
	 * @return formatted string of the Husky
	 * **/
	public String toString() { return getGender() + " Husky\nName: " + getName() + "\nWeight: " + getWeight() + "\nColor: " + getColor() + "\nAdditional Info: " + getInfo(); }
}