package lab3;

public class Example {
	
public static void main(String[] args) {
		
		int n = 1000;
		
		boolean [] isPrime = new boolean[n];
		
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		
		for (int factor = 2; factor*factor < n; factor++) {
			if (isPrime[factor]) {
				for (int j = factor; factor*j < n; j++) {
					isPrime[factor*j] = false;
				}
			}
		}
		
		int prime = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				prime++;
			}
		}
		
		int [] list = new int[prime];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime[i]) {
				list[count++] = i;
			}
		}
		
		int left = 0;
		int right = count - 1;
		while (left <= right) {
			if (list[left] + list[right] == n) {
				break;
			} else if (list[left] + list[right] < n) {
				left++;
			} else {
				right--;
			}
		}
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		if (list[left] + list[right] == n) {
			System.out.println(n + " = " + list[left] + " + " + list[right]);
		} else {
			System.out.println(n + " not expressible as sum of two primes!");
		}
	}
}
