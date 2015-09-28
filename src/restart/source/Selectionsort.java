package restart.source;


import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * The algorithm divides the input list into two parts: the sub-list of items already sorted, which is built up
 * from left to right at the front (left) of the list, and the sub-list of items remaining to be sorted that
 * occupy the rest of the list. Initially, the sorted sub-list is empty and the unsorted sub-list is the entire
 * input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element
 * in the unsorted sub-list, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order),
 * and moving the sub-list boundaries one element to the right.
 */
public class Selectionsort {

	/**
	 * Main functions where selection sort is performed. Goes through the array constantly checking if an
	 * index is smaller that the one started with. The index could be replaced n times if the array is reversed.
	 *
	 * @param a An array that is needed to be sorted
	 * @param n Holds the size of the array
	 * @return Returns the array to the caller.
	 */
	public static int[] selectionsort(int[] a, int n) {
		for (int i = 0; i < n - 1; ++i) {                       // First loop
			int index = i;
			for (int j = i + 1; j < n; j++) {                   // While holding on i, go through the array
				if (a[j] < a[index]) {
					index = j;
				}
			}
			swap(a, index, i);                                  // Swap in the smaller number
			//System.out.print("Hang tight, we are " + loading(i, n) + "% done. " + (i + 2) + "/" + n + "\r");
		}                                                       // Loading commented since it slowed the
		return a;                                               // algorithm down too much
	}

	/**
	 * Swap is a basic function that exchanges the value of two array indexes. This is done by the
	 * help of a temporary variable holding the value of one while they get exchanged.
	 *
	 * @param a An array that we are sorting
	 * @param i The position that should hold a smaller int but doesn't at the moment
	 * @param j The position that should hold a bigger  int but doesn't at the moment
	 */
	private static void swap(int[] a, int i, int j) {           // Swaps the smallest number found in the array
		int temp = a[i];                                        // to where j was at in selectionsort()
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Prints a percentage based on the size of the array and how much have the program has calculated. Removed
	 * since it can mess up the timing.
	 *
	 * @param i Array index currently at
	 * @param n The size of the array
	 * @return Returns a percentage using numberformat to only be in an int format.
	 */
	private static String loading(int i, int n) {               // Selectionsort can take a long time
		float x = ((float) (i + 2) / (float) n) * 100f;         // Progress bar wouldn't hurt.
		NumberFormat numberformat = new DecimalFormat("#");
		return numberformat.format(x);
	}
}
