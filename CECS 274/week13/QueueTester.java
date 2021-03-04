package week13;

public class QueueTester {

	public static void main(String[] args) {
		
		Queue q = new Queue();
		for (int i = 1; i <= 10; i++) {
			q.add(i);
		}
		
		System.out.println("Peek: " + q.peek());
		
		for (int i = 1; i <= 10; i++) {
			System.out.print(q.peek() + " ");
			System.out.print(q.remove() + " ");
		}
	}

}
