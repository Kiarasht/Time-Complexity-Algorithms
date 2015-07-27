package restart.source;

public class Insertionsort {
	private static int j = 0;

	public static void sort(int[] a, int n) {	// Insertion implementation
		for (int i = 1; i <= n - 1; ++i) {			// Find a number and moves it back until
			int x = a[i];													// it finds its perfect place
			j = i;

			while (j > 0 && a[j - 1] > x) {				// Move element one ahead to create space
				a[j] = a[j - 1];										// for the coming element
				j = j - 1;
			}
			a[j] = x;
		}
	}
}
