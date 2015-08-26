package restart.source;


public class Bubblesort {
	public static void BubbleSort(int[] a, int n) {
	boolean flag;                                               // Loop condition controller

		do {
			flag = false;                                       // Start with a flag of false
			for (int i = 0; i < n - 1; ++i) {
				if (a[i] > a[i + 1]) {                          // Array is still not sorted
					swap(a, i, i + 1);                          // will have to loop again
					flag = true;
				}
			}
		} while (flag);
	}

	private static void swap(int[] a, int i, int j) {           // Swaps the two index values that are
		int temp = a[i];                                        // next to each other
		a[i] = a[j];
		a[j] = temp;
	}
}
