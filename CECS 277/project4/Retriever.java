package project4;

public class Retriever extends Dog {
	
	/**
	 * Default Constructor
	 * **/
	public Retriever() {
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
	public Retriever(String name, String weight, String color, String gender, String info) {
		super(name, weight, color, gender, info);
	}
	/**
	 * Allows for the cloning of an existing Retriever
	 * @return a clone of the original Retriever
	 * **/
	@Override
	public Dog Clone() throws CloneNotSupportedException {
		return new Retriever(this.getName(), this.getWeight(), this.getColor(), this.getGender(), this.getInfo()); 
	}
	/**
	 * Prints the Retriever
	 * @return formatted string of the Retriever
	 * **/
	public String toString() { return getGender() + " Retriever\nName: " + getName() + "\nWeight: " + getWeight() + "\nColor: " + getColor() + "\nAdditional Info: " + getInfo(); }	
}