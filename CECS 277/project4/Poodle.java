package project4;

public class Poodle extends Dog {
	
	/**
	 * Default Constructor
	 * **/
	public Poodle() {
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
	public Poodle(String name, String weight, String color, String gender, String info) {
		super(name, weight, color, gender, info);
	}
	/**
	 * Allows for the cloning of an existing Poodle
	 * @return a clone of the original Poodle
	 * **/
	@Override
	public Dog Clone() throws CloneNotSupportedException {
		return new Poodle(this.getName(), this.getWeight(), this.getColor(), this.getGender(), this.getInfo()); 
	}
	/**
	 * Prints the Poodle
	 * @return formatted string of the Poodle
	 * **/
	public String toString() { return getGender() + " Poodle\nName: " + getName() + "\nWeight: " + getWeight() + "\nColor: " + getColor() + "\nAdditional Info: " + getInfo(); }
}