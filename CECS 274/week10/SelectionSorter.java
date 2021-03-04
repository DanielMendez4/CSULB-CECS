package week10;

public class SelectionSorter {
	
	/**
	 * Sorts the array of integers using the selection sort algorithm
	 * @param a - an array list of integers
	 * **/
	public static void Sort(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			int idxMIN = ArrayUtil.minElementPos(a, i);
			if (a[i] > a[idxMIN]) {
				ArrayUtil.swapElement(a, i, idxMIN);

			}
		}
	}

	public static void main(String[] args) {
		
		Stopwatch s = new Stopwatch();
		int[] a;
		for (int i = 1; i <= 6; i++) {
			a = ArrayUtil.generateIntArray(i*10000, i*10000);
			s.start();
			Sort(a);
			s.stop();
			System.out.println("Size: " + i*10000 + "\t\tTime: " + s.elapsedTime());
		}
	}
}
