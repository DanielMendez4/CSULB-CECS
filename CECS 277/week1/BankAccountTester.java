package week1;

public class BankAccountTester {

	public static void main(String[] args) {
		
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		
		a.deposit(500);
		a.deposit(400);
		
		b.deposit(1000);
		System.out.printf("Balance: $%.2f%n", a.getBalance());
		System.out.println(a.withdraw(300.50));
		System.out.printf("Balance: $%.2f%n", a.getBalance());
		System.out.println(a.withdraw(600));
		System.out.printf("Balance: $%.2f%n", a.getBalance());
		System.out.println();
		System.out.println(a);
		System.out.println();
		System.out.println(b);
	}
}
