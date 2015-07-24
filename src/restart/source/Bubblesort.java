package restart.source;


public class Bubblesort {
	public static void BubbleSort(int[] a, int n) {
	boolean flag;											// Loop condition controller

		do {
			flag = false;									// Start with a flag of false
			for (int i = 0; i < n - 1; ++i) {
				if (a[i] < a[i + 1]) {
					swap(a, i, i + 1);
					flag = true;
				}
			}
		} while (flag);
	}

	private static void swap(int[] a, int i, int j) {		// Swaps the smallest number found in the array
		int temp = a[i];									// to where j was at in selectionsort()
		a[i] = a[j];
		a[j] = temp;
	}
}
