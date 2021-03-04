package week12Factory;

import week12Classes.Vehicle;

public class VehicleClient {

	public static void main(String[] args) {
		
		Vehicle car = VehicleFactory.createVechile(VehicleTypes.CAR, "Tesla", "S", null);
		Vehicle truck = VehicleFactory.createVechile(VehicleTypes.TRUCK, "Ford", "F-150", "XL");
		
		car.moveDown();
		truck.moveRight();
		
		System.out.println(car);
		System.out.println(truck);

	}
}
