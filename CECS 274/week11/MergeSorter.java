package week11;

public class MergeSorter {
	
	/**
	 * Sorts an array of integers using the merge sort algorithm
	 * @param a - an array of integers
	 * **/
	public static void sort(int[] a) {
		
		if (a.length <= 1) { // An array size 0 or 1 is already sorted
			return;
		} else {
			int[] first = new int[a.length/2];
			int[] second = new int[a.length - first.length];
			
			// Copy elements into first and second half
			
			for (int i = 0; i < first.length; i++) {
				first[i] = a[i];
			}
			
			for (int j = 0; j < second.length; j++) {
				second[j] = a[j + first.length];
			}
			
			sort(first); // Recursive call
			sort(second); // Recursive call
			merge(first, second, a); // Merge first and second halves into array
		}
	}
	
	/**
	 * Merges two smaller arrays in order into one larger array
	 * @param fh - first half of the array
	 * @param sh - second half of the array
	 * @param a - whole array which is to be overwritten with result of merging the two halves
	 * **/
	public static void merge(int[] fh, int[] sh, int[] a) {
		
		int iFirst = 0; // Index to iterate through the first half
		int iSecond = 0; // Index to iterate through the second half
		int i = 0; // Index of the current location in array
		
		while (iFirst < fh.length && iSecond < sh.length) {
			if (fh[iFirst] < sh[iSecond]) {
				a[i] = fh[iFirst]; // Element in first half is smaller
				iFirst++; // Increment the index for the first half array
			} else {
				a[i] = sh[iSecond]; // Element in second half is smaller
				iSecond++; // Increment the index for the second array
			}
			i++; // Increment the current position of a
		}
		
		// Account for leftover elements
		while (iFirst < fh.length) { // Leftover elements in the first half
			a[i] = fh[iFirst];
			iFirst++;
			i++;
		}
		
		while (iSecond < sh.length) { // Leftover elements in the second half
			a[i] = sh[iSecond];
			iSecond++;
			i++;
		}
	}
	
	public static void main(String[] args) {
		Stopwatch s = new Stopwatch();
		int[] a;
		for (int i = 1; i <= 6; i++) {
			a = ArrayUtil.generateIntArray(i*10000, i*30000);
			s.start();
			sort(a);
			s.stop();
			System.out.println("Size: " + i*10000 + "\t\tTime: " + s.elapsedTime());
		}
	}
}
