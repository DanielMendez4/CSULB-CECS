package project5_FinalProject;

import java.util.ArrayList;

public class Pizza extends MealPlanDecorator {
	
	private String myPizza;
	private ArrayList<String> myTop;
	
	String[] toppings = new String[] {"None", "Cheese", "Pepperoni", "Ham", "Jalapeno", "Sausage", "Mushroom", "Pineapple", "Bell Pepper", "Onion", "Garlic Chicken"};
	
	public Pizza() {
		myPizza = "N/A";
		myTop = new ArrayList<String>();
	}
	
	public void addTop(String newTop) {
		
		switch(newTop) {
		case "None": myTop.add(toppings[0]); break;
		case "Cheese": myTop.add(toppings[1]); break;
		case "Pepperoni": myTop.add(toppings[2]); break;
		case "Ham": myTop.add(toppings[3]); break;
		case "Jalapeno": myTop.add(toppings[4]); break;
		case "Sausage": myTop.add(toppings[5]); break;
		case "Mushroom": myTop.add(toppings[6]); break;
		case "Pineapple": myTop.add(toppings[7]); break;
		case "Bell Pepper": myTop.add(toppings[8]); break;
		case "Onion": myTop.add(toppings[9]); break;
		case "Garlic Chicken": myTop.add(toppings[10]); break;
		default: myTop.add(toppings[0]); break;
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		
		ArrayList<String> tempTop = new ArrayList<String>();

		for (int i = 0; i < myTop.size(); i++) {
			if (!myTop.get(i).equals("None")) {
				tempTop.add(myTop.get(i));
			}
		}
		
		if (tempTop.size() == 0) {
			myPizza = "XL Gourmet Pizza w/ No Toppings";
		} else {
			String finalTop[] = new String[tempTop.size()];
			for (int i = 0; i < finalTop.length; i++) {
				finalTop[i] = tempTop.get(i);
			}
			String joinTop = String.join(", ", finalTop);
			myPizza = "XL Gourmet Pizza w/ " + joinTop;
		}
		return myPizza;
	}
}
