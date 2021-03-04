package week3;

/**
 * Models a car that is able to move given number of units forward/backward and right/left
 */
public class Car {
	
	//Instance Variables: attributes of the CarDemo object
	//Make, model, year, current position
	
	private String makeModelYr;
	private int[] position;
	
	/**
	 * default constructor initializes the make, model, and year to "N/A"
	 * and the position to be the origin
	 */
	
	public Car() {
		makeModelYr = "N/A";
		position = new int[2];
	}
	
	/**
	 * moves the car in the given direction one unit
	 * acceptable directions are "U" for up, "D" for down, "R" for right, and "L" for left
	 * @param direction - a character 'U', 'D', 'R', or 'L'
	 */
	
	public void move(char direction) {
		if (direction == 'U') {
			position[1] += 1; //increment the second coordinate by one
		} else if (direction == 'D') {
			position[1] -= 1; //decrement the second coordinate
		} else if (direction == 'R') {
			position[0] += 1;
		} else if (direction == 'L') {
			position[0] -= 1;
		} else {
			System.out.println("ERROR: INVALID DIRECTION!");
		}
	}
	/**
	 * returns the current position of the car
	 */
	public int[] getPosition() {
		return position;
	}
	
	/**
	 * sets the make, model, and year of this car
	 * @param info - the make, model, and year of this car
	 */
	public void setMakeModelYr(String info) {
		makeModelYr = info;
	}
	/**
	 * returns make, model, and year of this car
	 */
	public String getMakeModelYr() {
		return makeModelYr;
	}
	
	public String toString() {
		String info = String.format("Car Info: %s%nPosition: (%d, %d)%n", this.makeModelYr, position[0], position[1]);
		return info;
	}
}