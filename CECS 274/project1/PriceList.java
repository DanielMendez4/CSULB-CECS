package project1;
/**
 * This program simulates an on going shopping list until the user types "Done"
 * User can input items found on PriceList.txt
 * Depending on what the user inputs beforehand, the next input may result in "Product not found" even if the product is found on PriceList.txt
 * Also, there are instances where misspelling a product causes the whole program to break unless "Done" is typed
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class PriceList {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> productList = new ArrayList<String>();
		ArrayList<String> weightOrSizeList = new ArrayList<String>();
		ArrayList<Float> normalPriceList = new ArrayList<Float>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<Float> totalPrice = new ArrayList<Float>();
		
		File textfile = new File("C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\PriceList.txt");
		Scanner fileReader = new Scanner(textfile);
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the name you wish to give the text file: ");
		String newFile = in.nextLine().trim();
		PrintWriter fileWriter = new PrintWriter("C:\\Users\\Daniel\\Desktop\\Receipts\\" + newFile);
		Pattern p = Pattern.compile("([\\w|\\s|'|&|-|,|%|-|\\\"].+)\\s+([\\d|.|\\/]+\\s[\\w]+)\\s+([\\d|.]+)");
		Matcher m;
		
		// Sets the heading for the receipt
		fileWriter.println("Just Fooding");
		fileWriter.println("123 E. Lechuga St.");
		fileWriter.println("Carrotville, CA 99999");
		fileWriter.println();
		String header1 = "Item";
		String header2 = "Subtotal";
		fileWriter.printf("%-50s %s", header1, header2);
		fileWriter.println();
		
		System.out.println("Please enter the name and size/weight of the product followed by \"Enter\". Type \"Done\" when finished.");
		String product;
		String weightOrSize;
		// Initializes the do/while loop with user input as the product and the weight/size of that product
		do {
			System.out.print("Product name: ");
			product = in.nextLine();
			if (!product.equals("Done")) {
				System.out.print("Product weight/size: ");
				weightOrSize = in.nextLine();
				while (fileReader.hasNextLine()) {
					String currentline = fileReader.nextLine();
					m = p.matcher(currentline);
					if (m.find()) {
						// Fixes the spacing found in PriceList.txt so user can type products separated by one space
						String newProduct = m.group(1);
						newProduct = newProduct.replaceAll("\\s{2,}", " ");
						String newWeightOrSize = m.group(2);
						newWeightOrSize = newWeightOrSize.replaceAll("\\s{2,}", " ");
						String editPrice = m.group(3);
						Float newPrice = Float.parseFloat(editPrice);
						currentline = String.format("%s %s %.2f", newProduct, newWeightOrSize, newPrice);
						if (productList.contains(product) && weightOrSizeList.contains(weightOrSize)) {
							// Adds 1 to the quantity of a particular item if it is repeated
							quantity.set(productList.indexOf(product), quantity.get(productList.indexOf(product)) + 1);
							System.out.println("Product added!");
							break;
						} else {
							if (currentline.contains(product) && currentline.contains(weightOrSize)) {
								// Adds a new item to the product list along with a quantity of 1
								quantity.add(1);
								productList.add(product);
								weightOrSizeList.add(weightOrSize);
								normalPriceList.add(newPrice);
								System.out.println("Product added!");
								break;
							}
						}
					} else {
						if (!currentline.contains(product) && !currentline.contains(weightOrSize)) {
							// Checks to see if the item is not in the product list
							System.out.println("Product not found!");
							break;
						}
					}
				}
			}	
		} while (!product.equals("Done"));
		
		// Formats the receipt to contain the item, quantity, and price
		for (int j = 0; j < productList.size(); j++) {
			String finalProduct = productList.get(j);
			int finalQuantity = quantity.get(j);
			float normalPrice = normalPriceList.get(j);
			float finalPrice = finalQuantity * normalPriceList.get(j);
			totalPrice.add(finalPrice);
			if (finalQuantity > 1) {
				fileWriter.printf("%-41s %d(@%.2f) $%.2f", finalProduct, finalQuantity, normalPrice, finalPrice);
				fileWriter.println();
			} else {
				fileWriter.printf("%-50s $%.2f", finalProduct, finalPrice);
				fileWriter.println();
			}
		}
		fileWriter.println();
		fileWriter.println();
		// This for loop with come up with the total cost of the items
		float sum = 0;
		for (int i = 0; i < totalPrice.size(); i++) {
			sum += totalPrice.get(i);
		}
		fileWriter.printf("Total: $%.2f", sum);
		fileReader.close();
		in.close();
		fileWriter.close();
		System.out.println("Receipt printed!");
	}
}