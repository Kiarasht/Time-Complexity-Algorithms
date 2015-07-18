package restart.source;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Selectionsort {
	public static int[] selectionsort(int[] a, int n) {                     // Selection has big-O of n^2. Using nested loops
		for (int i = 0; i < n - 1; ++i) {                                   // it finds its best candidate
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[index]) {
					index = j;
				}
			}
			swap(a, index, i);                                              // Swap in the smaller number
			//System.out.print("Hang tight, we are " + loading(i, n) + "% done. " + (i + 2) + "/" + n + "\r");
		}                                                                   // Percentage commented since it slowed it
		return a;                                                           // down too much
	}

	private static void swap(int[] a, int i, int j) {                       // Swaps the smallest number found in the array
		int temp = a[i];                                                    // to where j was at in selectionsort()
		a[i] = a[j];
		a[j] = temp;
	}

	private static String loading(int i, int n) {                           // Selectionsort can take a long time
		float x = ((float) (i + 2) / (float) n) * 100f;                     // Progress bar wouldn't hurt.
		NumberFormat numberformat = new DecimalFormat("#");
		return numberformat.format(x);
	}
}
