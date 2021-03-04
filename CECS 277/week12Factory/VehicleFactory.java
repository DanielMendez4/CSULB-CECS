package week12Factory;

import week12Classes.Car;
import week12Classes.Truck;
import week12Classes.Vehicle;

public class VehicleFactory {
	
	public static Vehicle createVechile(VehicleTypes v, String make, String model, String attr) {
		
		Vehicle vehicle = null;
		
		switch(v) {
		case CAR:
			vehicle = new Car(make, model);
			break;
		case TRUCK:
			vehicle = new Truck(make, model, attr);
			break;
		}	
		return vehicle;
	}
}