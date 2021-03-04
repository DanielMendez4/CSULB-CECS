package project4;

public class DogTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// Original
		Husky myHusky = new Husky("Koa", "37.5 lbs", "Bronze", "Female", "Has blue eyes");
		Poodle myPoodle = new Poodle("Princess", "7.9 lbs", "White", "Female", "Brown streak on her back");
		Retriever myRetriever = new Retriever("Clifford", "87 tons", "Red", "Male", "Is 25 feet tall");
		Labrador myLabrador = new Labrador("Fido", "70.65 lbs", "Chocolate", "Male", "N/A");
		
		System.out.println("-----Original Dogs-----");
		System.out.println(myHusky + "\n");
		System.out.println(myPoodle + "\n");
		System.out.println(myRetriever + "\n");
		System.out.println(myLabrador + "\n");
		
		// Clones
		Husky newHusky = (Husky) myHusky.Clone();
		newHusky.setName("Spitz");
		newHusky.setWeight("40 lbs");
		newHusky.setGender("Male");
		newHusky.setInfo("Has heterochromia in the eyes");
		
		Poodle newPoodle = (Poodle) myPoodle.Clone();
		newPoodle.setName("Paloma");
		newPoodle.setInfo("Crys a lot");
		
		System.out.println("-----Clones-----");
		System.out.println(newHusky + "\n");
		System.out.println(newPoodle + "\n");
	}
}