package lab3;

import java.util.ArrayList;

public class GoldbachConjecture {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		int n = 1000;		
		int index = 4;

		for (int i = 2; i < n; i++) {
			boolean isPrime = true;
			
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				primeList.add(i);
			}
		}
		
		for (int i = 1; i < n/2; i++) {
			int left = 0;
			int right = primeList.size() - 1;
			while (left <= right) {
				if (primeList.get(left) + primeList.get(right) == index) {
					break;
				} else if (primeList.get(left) + primeList.get(right) < index) {
					left++;
				} else {
					right--;
				}
			}
			System.out.println(index + " = " + primeList.get(left) + " + " + primeList.get(right));
			index += 2;
		}
	}
}
