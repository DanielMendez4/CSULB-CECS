package project4;

public abstract class Dog {
	
	private String name;
	private String weight;
	private String color;
	private String gender;
	private String info;
	/**
	 * Default Constructor
	 * **/
	public Dog() {
		name = "";
		weight = "";
		color = "";
		gender = "";
		info = "";
	}
	/**
	 * Overloaded Constructor
	 * @param name - name of the dog
	 * @param weight - weight of the dog
	 * @param color - color of the dog
	 * @param gender - gender of the dog
	 * @param info - any info regarding the dog
	 * **/
	public Dog(String name, String weight, String color, String gender, String info) {
		this.name = name;
		this.weight = weight;
		this.color = color;
		this.gender = gender;
		this.info = info;
	}
	/**
	 * Abstract method
	 * Allows for cloning of Dog objects
	 * **/
	public abstract Dog Clone() throws CloneNotSupportedException;
	/**
	 * Gets the name of the dog
	 * @return name of the dog
	 * **/
	public String getName() { return name; }
	/**
	 * Gets the weight of the dog
	 * @return weight of the dog
	 * **/
	public String getWeight() { return weight; }
	/**
	 * Gets the color of the dog
	 * @return color of the dog
	 * **/
	public String getColor() { return color; }
	/**
	 * Gets the gender of the dog
	 * @return gender of the dog
	 * **/
	public String getGender() { return gender; }
	/**
	 * Gets the info regarding the dog
	 * @return info regarding the dog
	 * **/
	public String getInfo() { return info; }
	/**
	 * Sets the name of the dog
	 * @param newName - name of the dog
	 * **/
	public void setName(String newName) { name = newName; }
	/**
	 * Sets the weight of the dog
	 * @param newWeight - weight of the dog
	 * **/
	public void setWeight(String newWeight) { weight = newWeight; }
	/**
	 * Sets the color of the dog
	 * @param newColor - color of the dog
	 * **/
	public void setColor(String newColor) { color = newColor; }
	/**
	 * Sets the gender of the dog
	 * @param newGender - gender of the dog
	 * **/
	public void setGender(String newGender) { gender = newGender; }
	/**
	 * Sets the info regarding the dog
	 * @param newInfo - any additional info
	 * **/
	public void setInfo(String newInfo) { info = newInfo; }
	/**
	 * Prints the Dog
	 * @return formatted string of the Dog
	 * **/
	public String toString() { return getGender() + " Dog\nName: " + getName() + "\tWeight: " + getWeight() + "\tColor: " + getColor(); }
}