package week12Classes;

public class Car implements Vehicle {
	
	private String make;
	private String model;
	private int x;
	private int y;
	
	public Car() {
		this.make = "?";
		this.model = "?";
		this.x = 0;
		this.y = 0;
	}
	
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void moveLeft() {
		this.x -= 1;
	}

	@Override
	public void moveRight() {
		this.x += 1;
	}

	@Override
	public void moveUp() {
		this.y += 1;
	}

	@Override
	public void moveDown() {
		this.y -= 1;
	}
	
	public String toString() {
		return "Vehicle: Car" + "\nMake: " + this.make + "\nModel: " + this.model + "\nPosition: (" + this.x + ", " + this.y + ")\n";
	}
}
