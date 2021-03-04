package week5;

public class BankAccountTester {

	public static void main(String[] args) {
		BankAccount acct1 = new BankAccount();
		BankAccount acct2 = new BankAccount(25.50);
		BankAccount acct3 = new BankAccount(4.25);
		
		acct1.deposit(500);
		acct2.withdraw(3.50);
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3.getBalance());
		
		double p = BankAccount.projectSavings(acct1.getBalance(), 0.05, 12, 3);
		System.out.printf("Projected Balance: $%.2f", p);
	}
}
