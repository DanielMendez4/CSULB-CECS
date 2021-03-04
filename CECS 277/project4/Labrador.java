package project4;

public class Labrador extends Dog {
	
	/**
	 * Default Constructor
	 * **/
	public Labrador() {
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
	public Labrador(String name, String weight, String color, String gender, String info) {
		super(name, weight, color, gender, info);
	}
	/**
	 * Allows for the cloning of an existing Labrador
	 * @return a clone of the original Labrador
	 * **/
	@Override
	public Dog Clone() throws CloneNotSupportedException {
		return new Labrador(this.getName(), this.getWeight(), this.getColor(), this.getGender(), this.getInfo()); 
	}
	/**
	 * Prints the Labrador
	 * @return formatted string of the Labrador
	 * **/
	public String toString() { return getGender() + " Labrador\nName: " + getName() + "\nWeight: " + getWeight() + "\nColor: " + getColor() + "\nAdditional Info: " + getInfo(); }
}