package project2;

import java.util.Scanner;

public class BobaTeaLounge {
	
	public static boolean validateInput(String input) {
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		CashRegister myRegister = new CashRegister();
		
		Scanner in = new Scanner(System.in);
		String response;
		
		System.out.println("Welcome to Boba Tea Lounge\n1. Make purchase\n2. Print all sales\n3. Close register");
		System.out.print("SELECTION: ");
		response = in.nextLine();
		while (!validateInput(response)) {
			System.out.print("\nInvalid input! Please enter an integer: ");
			response = in.nextLine();
		}
		int decision = Integer.parseInt(response);
		
		while (decision != 3) {
			
			if (decision == 1) {
				
				Receipt myReceipt = new Receipt();
				double payment = 0.00;
				
				System.out.println("\nWhat would you like to purchase?\n1. Drink\n2. Pastry\n3. Done");
				System.out.print("SELECTION: ");
				response = in.nextLine();
				while (!validateInput(response)) {
					System.out.print("\nInvalid input! Please enter an integer: ");
					response = in.nextLine();
				}
				int purchase = Integer.parseInt(response);
				
				while (purchase != 3) {
					
					if (purchase == 1) {
						
						System.out.println("\nWhat drink would you like?\n1. Coffee\n2. Boba Drink");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						int drink = Integer.parseInt(response);
						
						while (true) {
							
							if (drink == 1) {
								
								CoffeeDrink myCoffee = new CoffeeDrink();
								myCoffee.setDrinkName("Coffee");
								
								System.out.println("\nSize of coffee:\n1. Small\n2. Medium\n3. Large");
								System.out.print("SIZE: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int coffeeSize = Integer.parseInt(response);
								
								while (true) {
									
									if (coffeeSize == 1) { myCoffee.setSize("Small"); break; }
									
									else if (coffeeSize == 2) { myCoffee.setSize("Medium"); break; }
									
									else if (coffeeSize == 3) { myCoffee.setSize("Large"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Small\n2. Medium\n3. Large");
										System.out.print("SIZE: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										coffeeSize = Integer.parseInt(response);
									}
								}
								
								System.out.println("\nCoffee base:\n1. Water\n2. Whole Milk\n3. Almond Milk");
								System.out.print("BASE: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int coffeeBase = Integer.parseInt(response);
								
								while (true) {
									
									if (coffeeBase == 1) { myCoffee.setCoffeeBase("Water"); break; }
									
									else if (coffeeBase == 2) { myCoffee.setCoffeeBase("Whole Milk"); break; }
									
									else if (coffeeBase == 3) { myCoffee.setCoffeeBase("Almond Milk"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Water\n2. Whole Milk\n3. Almond Milk");
										System.out.print("BASE: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										coffeeBase = Integer.parseInt(response);
									}
								}
								
								System.out.println("\nAmount of sugar (tsp)");
								System.out.print("SWEETNESS: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								myCoffee.setSweetness(response);
								
								String formatCoffeeCost = String.format("%.2f", myCoffee.getCost());
								
								String coffeeOrder = myCoffee.getSize() + " " + myCoffee.getDrinkName() + " w/ " + myCoffee.getCoffeeBase() + " and " + myCoffee.getSweetness() + " tsp of sugar\t$" + formatCoffeeCost;
								myCoffee.setDrinkOrder(coffeeOrder);
								System.out.println("\n" + myCoffee);
								
								myReceipt.addDrink(myCoffee);
								break;
							}
							
							else if (drink == 2) {
								
								BobaDrink myBoba = new BobaDrink();
								myBoba.setDrinkName("Boba");
								
								System.out.println("\nSize of boba drink:\n1. Small\n2. Medium\n3. Large");
								System.out.print("SIZE: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int bobaSize = Integer.parseInt(response);
								
								while (true) {
									
									if (bobaSize == 1) { myBoba.setSize("Small"); break; }
									
									else if (bobaSize == 2) { myBoba.setSize("Medium"); break; }
									
									else if (bobaSize == 3) { myBoba.setSize("Large"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Small\n2. Medium\n3. Large");
										System.out.print("SIZE: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										bobaSize = Integer.parseInt(response);
									}
								}
								
								System.out.println("\nBoba drink base tea:\n1. Green Tea\n2. Black Tea\n3. Jasmine Tea\n4. Rose Tea\n5. Oolong Tea");
								System.out.print("BASE: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int bobaBase = Integer.parseInt(response);
								
								while (true) {
									
									if (bobaBase == 1) { myBoba.setBaseTea("Green Tea"); break; }
									
									else if (bobaBase == 2) { myBoba.setBaseTea("Black Tea"); break; }
									
									else if (bobaBase == 3) { myBoba.setBaseTea("Jasmine Tea"); break; }
									
									else if (bobaBase == 4) { myBoba.setBaseTea("Rose Tea"); break; }
									
									else if (bobaBase == 5) { myBoba.setBaseTea("Oolong Tea"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Green Tea\n2. Black Tea\n3. Jasmine Tea\n4. Rose Tea\n5. Oolong Tea");
										System.out.print("BASE: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										bobaBase = Integer.parseInt(response);
									}
								}
								
								System.out.println("\nSweetness of boba drink:\n1. Full\n2. 3/4 Sweet\n3. 1/2 Sweet\n4. 1/4 Sweet\n5. Unsweetened");
								System.out.print("SWEETNESS: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int bobaSweetness = Integer.parseInt(response);
								
								while (true) {
									
									if (bobaSweetness == 1) { myBoba.setSweetness("Full"); break; }
									
									else if (bobaSweetness == 2) { myBoba.setSweetness("3/4 Sweet"); break; }
									
									else if (bobaSweetness == 3) { myBoba.setSweetness("1/2 Sweet"); break; }
									
									else if (bobaSweetness == 4) { myBoba.setSweetness("1/4 Sweet"); break; }
									
									else if (bobaSweetness == 5) { myBoba.setSweetness("Unsweetened"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Full\n2. 3/4 Sweet\n3. 1/2 Sweet\n4. 1/4 Sweet\n5. Unsweetened");
										System.out.print("SWEETNESS: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										bobaSweetness = Integer.parseInt(response);
									}
								}
								
								System.out.println("\nMilk type:\n1. Whole Milk\n2. Half-and-Half\n3. Almond Milk\n4. Coconut Milk\n5. No Milk");
								System.out.print("MILK: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int bobaMilk = Integer.parseInt(response);
								
								while (true) {
									
									if (bobaMilk == 1) { myBoba.setMilkType("Whole Milk"); break; }
									
									else if (bobaMilk == 2) { myBoba.setMilkType("Half-and-Half"); break; }
									
									else if (bobaMilk == 3) { myBoba.setMilkType("Almond Milk"); break; }
									
									else if (bobaMilk == 4) { myBoba.setMilkType("Coconut Milk"); break; }
									
									else if (bobaMilk == 5) { myBoba.setMilkType("No Milk"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Whole Milk\n2. Half-and-Half\n3. Almond Milk\n4. Coconut Milk\n5. No Milk");
										System.out.print("MILK: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										bobaSweetness = Integer.parseInt(response);
									}
								}
								
								System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
								System.out.print("TOPPING: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int bobaTopping = Integer.parseInt(response);
								
								while (bobaTopping != 8) {
									
									if (bobaTopping == 1) {
										
										myBoba.addTopping("Boba");
										System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine().trim();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine().trim();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									else if (bobaTopping == 2) {
										
										myBoba.addTopping("Popping Boba");
										System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine().trim();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine().trim();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									else if (bobaTopping == 3) {
										
										myBoba.addTopping("Grass Jelly");
										System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine().trim();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine().trim();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									else if (bobaTopping == 4) {
										
										myBoba.addTopping("Lychee Jelly");
										System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine().trim();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine().trim();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									else if (bobaTopping == 5) {
										
										myBoba.addTopping("Coconut Jelly");
										System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine().trim();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine().trim();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									else if (bobaTopping == 6) {
										
										myBoba.addTopping("Mini Mochi");
										System.out.println("\nToppings:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine().trim();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine().trim();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									else if (bobaTopping == 7) {
										
										myBoba.getToppingsList().clear();
										myBoba.addTopping("No Topping");
										bobaTopping = 8;
									}
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Boba\n2. Popping Boba\n3. Grass Jelly\n4. Lychee Jelly\n5. Coconut Jelly\n6. Mini Mochi\n7. No Topping\n8. Done");
										System.out.print("TOPPING: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										bobaTopping = Integer.parseInt(response);
									}
									
									String finalTopping[] = new String[myBoba.getToppingsList().size()];
									
									if (myBoba.getToppingsList().isEmpty()) { myBoba.setToppings("No Topping"); }
									
									if (myBoba.getToppingsList().size() >= 1) {
										
										for (int i = 0; i < finalTopping.length; i++) {
											finalTopping[i] = myBoba.getToppingsList().get(i);
										}
									}
									String joinTopping = String.join(", ", finalTopping);
									
									myBoba.setToppings(joinTopping);
								}
								String formatBobaCost = String.format("%.2f", myBoba.getCost());
								
								String bobaOrder = myBoba.getSize() + " " + myBoba.getBaseTea() + " " + myBoba.getDrinkName() + " " + myBoba.getSweetness() + " w/ " + myBoba.getMilkType() + " and " + myBoba.getToppings() + "\t$" + formatBobaCost;
								myBoba.setDrinkOrder(bobaOrder);
								System.out.println("\n" + myBoba);
								
								myReceipt.addDrink(myBoba);
								break;
							}
							
							else {
								
								System.out.println("\nInvalid selection! Please choose the following options:\n1. Coffee\n2. Boba Drink");
								System.out.print("SELECTION: ");
								response = in.nextLine();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine();
								}
								drink = Integer.parseInt(response);
							}
						}
						System.out.println("\nWhat would you like to purchase?\n1. Drink\n2. Pastry\n3. Done");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						purchase = Integer.parseInt(response);
					}
					
					else if (purchase == 2) {
						
						System.out.println("\nWhat dessert would you like?\n1. Croissant\n2. Danish\n3. Cookie\n4. Macaroon");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						int dessert = Integer.parseInt(response);
						
						while (true) {
							
							if (dessert == 1) {
								
								Pastry myCroissant = new Pastry();
								myCroissant.setDessertName("Croissant");
								
								System.out.println("\nHow many do you want?");
								System.out.print("QUANTITY: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								myCroissant.setQuantity(Integer.parseInt(response));
								
								System.out.println("\nWould you like to heat your pastry?\n1. Yes\n2. No");
								System.out.print("HEATING: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int hotCroissant = Integer.parseInt(response);
								
								while (true) {
									
									if (hotCroissant == 1) { myCroissant.setHeatingOption("Yes"); break; }
									
									else if (hotCroissant == 2) { myCroissant.setHeatingOption("No"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Yes\n2. No");
										System.out.print("HEATING: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										hotCroissant = Integer.parseInt(response);
									}
								}
								String formatCroissant = String.format("%.2f", myCroissant.getCost());
								
								String croissantOrder = myCroissant.getQuantity() + " " + myCroissant.getDessertName() + "(s), Heating: " + myCroissant.getHeatingOption() + "\t$" + formatCroissant;
								myCroissant.setDessertOrder(croissantOrder);
								System.out.println("\n" + myCroissant);
								
								myReceipt.addDessert(myCroissant);
								break;
							}
							
							else if (dessert == 2) {
								
								Pastry myDanish = new Pastry();
								myDanish.setDessertName("Danish");
								
								System.out.println("\nHow many do you want?");
								System.out.print("QUANTITY: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								myDanish.setQuantity(Integer.parseInt(response));
								
								System.out.println("\nWould you like to heat your pastry?\n1. Yes\n2. No");
								System.out.print("HEATING: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int hotDanish = Integer.parseInt(response);
								
								while (true) {
									
									if (hotDanish == 1) { myDanish.setHeatingOption("Yes"); break; }
									
									else if (hotDanish == 2) { myDanish.setHeatingOption("No"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Yes\n2. No");
										System.out.print("HEATING: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										hotDanish = Integer.parseInt(response);
									}
								}
								String formatDanish = String.format("%.2f", myDanish.getCost());
								
								String danishOrder = myDanish.getQuantity() + " " + myDanish.getDessertName() + "(s), Heating: " + myDanish.getHeatingOption() + "\t$" + formatDanish;
								myDanish.setDessertOrder(danishOrder);
								System.out.println("\n" + myDanish);
								
								myReceipt.addDessert(myDanish);
								break;
							}
							
							else if (dessert == 3) {
								
								Cookie myCookie = new Cookie();
								
								System.out.println("\nWhat type of cookie do you want?\n1. Chocolate\n2. Peanut Butter");
								System.out.print("TYPE: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int cookie = Integer.parseInt(response);
								
								while (true) {
									
									if (cookie == 1) { myCookie.setDessertName("Chocolate Cookie"); break; }
									
									else if (cookie == 2) { myCookie.setDessertName("Peanut Butter Cookie"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Chocolate\n2. Peanut Butter");
										System.out.print("TYPE: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										cookie = Integer.parseInt(response);
									}
								}
								System.out.println("\nHow many do you want?");
								System.out.print("QUANTITY: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								myCookie.setQuantity(Integer.parseInt(response));
								
								String formatCookie = String.format("%.2f", myCookie.getCost());
								
								String cookieOrder = myCookie.getQuantity() + " " + myCookie.getDessertName() + "(s)\t$" + formatCookie;
								myCookie.setDessertOrder(cookieOrder);
								System.out.println("\n" + myCookie);
								
								myReceipt.addDessert(myCookie);
								break;
							}
							
							else if (dessert == 4) {
								
								Macaroon myMacaroon = new Macaroon();
								
								System.out.println("\nWhat type of macaroon do you want?\n1. Chocolate\n2. Green Tea");
								System.out.print("TYPE: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								int macaroon = Integer.parseInt(response);
								
								while (true) {
									
									if (macaroon == 1) { myMacaroon.setDessertName("Chocolate Macaroon"); break; }
									
									else if (macaroon == 2) { myMacaroon.setDessertName("Green Tea Macaroon"); break; }
									
									else {
										
										System.out.println("\nInvalid selection! Please choose the following options:\n1. Chocolate\n2. Green Tea");
										System.out.print("TYPE: ");
										response = in.nextLine();
										while (!validateInput(response)) {
											System.out.print("\nInvalid input! Please enter an integer: ");
											response = in.nextLine();
										}
										macaroon = Integer.parseInt(response);
									}
								}
								System.out.println("\nHow many do you want?");
								System.out.print("QUANTITY: ");
								response = in.nextLine().trim();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine().trim();
								}
								myMacaroon.setMacQuant(Integer.parseInt(response));
								
								String formatMacaroon = String.format("%.2f", myMacaroon.getCost());
								
								String macaroonOrder = myMacaroon.getMacQuant() + " " + myMacaroon.getDessertName() + "(s)\t$" + formatMacaroon;
								myMacaroon.setDessertOrder(macaroonOrder);
								System.out.println("\n" + myMacaroon);
								
								myReceipt.addDessert(myMacaroon);
								break;
							}
							
							else {
								
								System.out.println("\nInvalid selection! Please choose the following options:\n1. Croissant\n2. Danish\n3. Cookie\n4. Macaroon");
								System.out.print("SELECTION: ");
								response = in.nextLine();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine();
								}
								dessert = Integer.parseInt(response);
							}
						}
						
						System.out.println("\nWhat would you like to purchase?\n1. Drink\n2. Pastry\n3. Done");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						purchase = Integer.parseInt(response);
					}
					
					else {
						
						System.out.println("\nInvalid selection! Please choose the following options:\n1. Drink\n2. Pastry\n3. Done");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						purchase = Integer.parseInt(response);
					}
				}
				System.out.println("\nWould you like to add a coupon?\n1. Yes\n2. No");
				System.out.print("SELECTION: ");
				response = in.nextLine();
				while (!validateInput(response)) {
					System.out.print("\nInvalid input! Please enter an integer: ");
					response = in.nextLine();
				}
				int coupon = Integer.parseInt(response);
				
				while (coupon != 2) {
					
					if (coupon == 1) {
						
						Coupon myCoupon = new Coupon();
						
						System.out.println("\nWhat is this coupon for?\n1. Drink\n2. Pastry");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						int apply = Integer.parseInt(response);
						
						while (true) {
							
							if (apply == 1) { myCoupon.setItemType("Drink"); break; }
							
							else if (apply == 2) { myCoupon.setItemType("Pastry"); break; }
							
							else {
								
								System.out.println("\nInvalid selection! Please choose the following options:\n1. Drink\n2. Pastry");
								System.out.print("SELECTION: ");
								response = in.nextLine();
								while (!validateInput(response)) {
									System.out.print("\nInvalid input! Please enter an integer: ");
									response = in.nextLine();
								}
								apply = Integer.parseInt(response);
							}
						}
						System.out.println("\nWhat is the percent discount?");
						System.out.print("DISCOUNT: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						myCoupon.setDiscount((double)Integer.parseInt(response)/100);
						
						System.out.println("\n" + myCoupon);
						myReceipt.addCoupon(myCoupon);
						coupon = 2;
					}
					
					else {
						
						System.out.println("\nInvalid selection! Please choose the following options:\n1. Yes\n2. No");
						System.out.print("SELECTION: ");
						response = in.nextLine();
						while (!validateInput(response)) {
							System.out.print("\nInvalid input! Please enter an integer: ");
							response = in.nextLine();
						}
						coupon = Integer.parseInt(response);
					}
				}
				myRegister.addReceipt(myReceipt);
				
				double gT = myReceipt.getGrandTotal();
				
				String formatGrandTotal = String.format("%.2f", gT);
				System.out.println("\nAmount due: $" + formatGrandTotal);
				System.out.print("PAY UP: ");
				response = in.nextLine();
				payment = Double.parseDouble(response);
				
				double change = payment - myReceipt.getGrandTotal();
				String formatChange = String.format("%.2f", change);
				System.out.print("\nHere is your change: $" + formatChange + "\n");
				
				System.out.println("\nWhat would you like to do?\n1. Make purchase\n2. Print all sales\n3. Close register");
				System.out.print("SELECTION: ");
				response = in.nextLine();
				while (!validateInput(response)) {
					System.out.print("\nInvalid input! Please enter an integer: ");
					response = in.nextLine();
				}
				decision = Integer.parseInt(response);
			}
			
			else if (decision == 2) {
				
				System.out.println("\nPRINTING SALES!");
				
				for (int i = 0; i < myRegister.getReceipts().size(); i++) {
					
					System.out.println(myRegister.getReceipts().get(i) + "\n");
				}
				
				
				System.out.println("What would you like to do?\n1. Make purchase\n2. Print all sales\n3. Close register");
				System.out.print("SELECTION: ");
				response = in.nextLine();
				while (!validateInput(response)) {
					System.out.print("\nInvalid input! Please enter an integer: ");
					response = in.nextLine();
				}
				decision = Integer.parseInt(response);
			}
			
			else {
				
				System.out.println("\nInvalid selection! Please choose the following options:\n1. Make purchase\n2. Print all sales\n3. Close register");
				System.out.print("SELECTION: ");
				response = in.nextLine();
				while (!validateInput(response)) {
					System.out.print("\nInvalid input! Please enter an integer: ");
					response = in.nextLine();
				}
				decision = Integer.parseInt(response);
			}
		}
		if (decision == 3) { System.out.println("\nThank you for visiting Boba Tea Lounge!"); }
		in.close();
	}
}
