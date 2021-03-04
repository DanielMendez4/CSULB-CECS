package labAssignment5;

public class Counter {
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	public void count() {
		value = value + 1;
	}
	
	public static void main(String[] args) {
		Counter points = new Counter();
		Counter passengers = new Counter();
		points.count();
		passengers.count();
		points.count();
		System.out.print(points.getValue() + " " + passengers.getValue());
	}
}

