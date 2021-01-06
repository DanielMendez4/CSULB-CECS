package project5_FinalProject;

public class MealTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		BasicPlan myBasic = new BasicPlan();
		myBasic.getPizzas().get(0).addTop("None");
		myBasic.getPizzas().get(1).addTop("Ham");
		myBasic.getPizzas().get(2).addTop("Jalapeno");
		myBasic.getSodas().get(0).setSoda("Root Beer");
		myBasic.getSodas().get(1).setSoda("Canada Dry");
		myBasic.getSodas().get(2).setSoda("Orange Crush");
		System.out.println(myBasic);
		
		myBasic.setPlan(myBasic.toString());
		System.out.println(myBasic.getPlan());
		
		BronzePlan myBronze = new BronzePlan();
		myBronze.getPizzas().get(0).addTop("None");
		myBronze.getPizzas().get(0).addTop("None");
		
		myBronze.getPizzas().get(1).addTop("Cheese");
		myBronze.getPizzas().get(1).addTop("None");
		
		myBronze.getPizzas().get(2).addTop("None");
		myBronze.getPizzas().get(2).addTop("Ham");
		
		myBronze.setAddon("Breadsticks");
		System.out.println(myBronze);
		
		SilverPlan mySilver = new SilverPlan();
		System.out.println(mySilver);
		*/
		
		GoldPlan myGold = new GoldPlan();
		
		myGold.getPizzas().get(0).addTop("None");
		myGold.getPizzas().get(0).addTop("Jalapeno");
		myGold.getPizzas().get(0).addTop("None");
		
		myGold.getWings().get(0).setWings("Diablo", true);
		myGold.getWings().get(1).setWings("BBQ", false);
		System.out.println(myGold);
		
		
		PlatinumPlan myPlat = new PlatinumPlan();
		
		myPlat.getPizzas().get(0).addTop("None");
		myPlat.getPizzas().get(0).addTop("None");
		myPlat.getPizzas().get(0).addTop("None");
		myPlat.getPizzas().get(0).addTop("Ham");

		myPlat.getIce().get(0).setIceCream("Vanilla Bean");
		myPlat.getIce().get(1).setIceCream("Choco-mint");
		System.out.println(myPlat);
	}
}