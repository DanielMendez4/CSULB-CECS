package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> originalProduct = new ArrayList<String>();
		ArrayList<String> originalSize = new ArrayList<String>();
		ArrayList<Double> originalPrice = new ArrayList<Double>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<String> receiptProduct = new ArrayList<String>();
		ArrayList<String> receiptSize = new ArrayList<String>();
		ArrayList<Double> receiptPrice = new ArrayList<Double>();
		
		File textFile = new File("C:\\Users\\Daniel\\Desktop\\Java Assignments\\CECS 274\\PriceList.txt");
		Scanner fileReader = new Scanner(textFile);
		Pattern p = Pattern.compile("([\\w|\\s|'|&|-|,|%|-|\\\"].+)\\s+([\\d|.|\\/]+\\s[\\w]+)\\s+([\\d|.]+)");
		Matcher m;
		
		while (fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			m = p.matcher(currentLine);
			if (m.find()) {
				String newProduct = m.group(1);
				newProduct = newProduct.replaceAll("\\s{1,}", " ").trim();
				String newSize = m.group(2);
				newSize = newSize.replaceAll("\\s{1,}", " ").trim();
				String editPrice = m.group(3);
				Double newPrice = Double.parseDouble(editPrice);
				originalProduct.add(newProduct);
				originalSize.add(newSize);
				originalPrice.add(newPrice);
			}
		}
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the name you wish to give the text file: ");
		String newFile = in.nextLine().trim();
		
		PrintWriter fileWriter = new PrintWriter("C:\\Users\\Daniel\\Desktop\\Receipts\\" + newFile);
		
		fileWriter.printf("Just Fooding%n123 E. Lechuga St.%nCarrotville, CA 99999%n");
		fileWriter.printf("%nItem%-50sSubtotal%n", "");
		
		System.out.println("Please enter the name and size/weight of the product followed by \"Enter\". Type \"Done\" when finished.");
		String product;
		String size;
		do {
			System.out.print("Product name: ");
			product = in.nextLine();
			if (!product.equals("Done")) {
				System.out.print("Product weight/size: ");
				size = in.nextLine();
				if (receiptProduct.contains(product) && receiptSize.contains(size)) {
					quantity.set(receiptSize.indexOf(size), quantity.get(receiptSize.indexOf(size)) + 1);
					System.out.println("Product added!");
				} else if (originalProduct.contains(product) && originalSize.contains(size)) {	
					quantity.add(1);
					receiptProduct.add(product);
					receiptSize.add(size);
					for (int i = 0; i < originalPrice.size(); i++) {
						if (product.equals(originalProduct.get(i)) && size.equals(originalSize.get(i))) {
							receiptPrice.add(originalPrice.get(i));
							System.out.println("Product added!");
						}
					}
				} else {
					System.out.println("Product not found!");
				}
			}
		} while (!product.equals("Done"));
		
		Double sum = 0.00;
		for (int i = 0; i < receiptProduct.size(); i++) {
			String finalProduct = receiptProduct.get(i);
			int finalQuantity = quantity.get(i);
			Double normalPrice = receiptPrice.get(i);
			Double finalPrice = finalQuantity * normalPrice;
			sum += finalPrice;
			if (finalQuantity > 1) {
				fileWriter.printf("%-41s %d(@%.2f) $%.2f%n", finalProduct, finalQuantity, normalPrice, finalPrice);
			} else {
				fileWriter.printf("%-50s $%.2f%n", finalProduct, finalPrice);
			}
		}
		
		fileWriter.printf("%n%nTotal: $%.2f", sum);
		fileReader.close();
		fileWriter.close();
		in.close();
		System.out.println("Receipt printed!");
	}
}
