package labAssignment6;

public class RentalCar {
	
	private boolean rented;
	private static int numAvailable = 0;
	private static int numRented = 0;
	
	public RentalCar() {
		rented = false;
		numAvailable++;
	}
	
	public static int numAvailable() {
		return numAvailable;
	}
	
	public static int numRented() {
		return numRented;
	}
	
	public boolean rentCar() {
		if (rented == false) {
			numAvailable--;
			numRented++;
			rented = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean returnCar() {
		if (rented == true) {
			numAvailable++;
			numRented--;
			rented = false;
			return false;
		} else {
			return true;
		}
	}
}
