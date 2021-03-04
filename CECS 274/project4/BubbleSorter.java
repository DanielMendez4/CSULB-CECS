package project4;

public class BubbleSorter {
	
	/**
	 * Sorts the array of doubles using bubble sort algorithm
	 * @param a - an array of doubles
	 * **/
	public static void Sort(double[] a) {
		
		int n = a.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (a[j] > a[j+1]) {
					ArrayUtil.swapElement(a, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Stopwatch s = new Stopwatch();
		double[] a;
		for (int i = 1; i <= 6; i++) {
			a = ArrayUtil.generateDoubleArray(i*10000, i*10000);
			s.start();
			Sort(a);
			s.stop();
			System.out.println("Size: " + i*10000 + "\t\tTime: " + s.elapsedTime());
		}
	}
}