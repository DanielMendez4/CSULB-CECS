package week12Classes;

public class Truck implements Vehicle {

	private String make;
	private String model;
	private String cabin;
	private int x;
	private int y;
	
	public Truck() {
		this.make = "?";
		this.model = "?";
		this.cabin = "?";
		this.x = 0;
		this.y = 0;
	}
	
	public Truck(String make, String model, String cabin) {
		this.make = make;
		this.model = model;
		this.cabin = cabin;
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void moveLeft() {
		this.x -= 2;
	}

	@Override
	public void moveRight() {
		this.x += 2;
	}

	@Override
	public void moveUp() {
		this.y += 2;
	}

	@Override
	public void moveDown() {
		this.y -= 2;
	}
	
	public String toString() {
		return "Vehicle: Truck" + "\nMake: " + this.make + "\nModel: " + this.model + "\nCabin: " + this.cabin + "\nPosition: (" + this.x + ", " + this.y + ")\n";
	}
}
