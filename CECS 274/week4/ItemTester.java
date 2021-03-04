package week4;

public class ItemTester {
	
	public static void main(String[] args) {
		
		Item item1 = new Item("Shampoo", 2, 1.99);
		Item item2 = new Item();
		
		item2.setName("Banana");
		item2.setPrice(0.50);
		item2.updateQty();
		
		//System.out.println("Name: " + item1.getItemName() + "\t\tSubtotal: $" + item1.getSubtotal());
		//System.out.printf("Name: %-25sQty: %-5dPrice: $%.2f%n", item2.getItemName(), item2.getQty(), item2.getPrice());
		System.out.println(item1);
		System.out.println(item2);
	}	
}
