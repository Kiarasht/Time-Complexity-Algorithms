package restart.source;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
	private static int size = 10;
	private static int loop = 5;
	private static int[][] a = new int[loop][];
	private static int[][] b = new int[loop][];

	public static void main(String[] args) throws InterruptedException {
		long totalTime;                                             // Used to calculate time at each sub section
		long endTime;
		long startTime;
		long Selection = 0;
		long Merge = 0;
		long Insertion = 0;
		long Bubble = 0;

		for (int i = 0; i < loop; ++i) {                            // Get a random array of arrays
			a[i] = randomarray();
			size *= 10;
		}

		for (int i = 0; i < loop; i++) {                            // Keep a copy of the array a
			b[i] = new int[a[i].length];
			System.arraycopy(a[i], 0, b[i], 0, a[i].length);
		}

		System.out.println("First, Selection.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {                            // Do the test on Selection
			startTime = System.currentTimeMillis();
			Selectionsort.selectionsort(a[i], a[i].length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Selection += totalTime;
			System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
		}
		System.out.println("Total Time: " + Selection + " milliseconds.");
																	// Now that a is sorted, we copy
		for (int i = 0; i < loop; i++) {							// back the random array in it again
			System.arraycopy(b[i], 0, a[i], 0, a[i].length);
		}															// This way, the same array will be used
																	// for each sorting algorithm
		System.out.println("\nSecond, Merge.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {							// Do the test on Merge
			startTime = System.currentTimeMillis();
			Mergesort.divide(a[i]);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Merge += totalTime;
			System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
		}
		System.out.println("Total Time: " + Merge + " milliseconds.");

		for (int i = 0; i < loop; i++) {
			System.arraycopy(b[i], 0, a[i], 0, a[i].length);
		}

		System.out.println("\nThird, Insertion.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {							// Do the test on Insertion
			startTime = System.currentTimeMillis();
			Insertionsort.sort(a[i], a[i].length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Insertion += totalTime;
			System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
		}
		System.out.println("Total Time: " + Insertion + " milliseconds.");

		for (int i = 0; i < loop; i++) {
			System.arraycopy(b[i], 0, a[i], 0, a[i].length);
		}

		System.out.println("\nFourth, Bubble.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {							// Do the test on Bubble
			startTime = System.currentTimeMillis();
			Bubblesort.BubbleSort(a[i], a[i].length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Bubble += totalTime;
			System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
		}
		System.out.println("Total Time: " + Bubble + " milliseconds.");
																	// Compare all of them
		compare("Selection", Selection, "Merge", Merge);
		compare("Insertion", Insertion, "Merge", Merge);
		compare("Bubblesort", Bubble, "Merge", Merge);
		System.out.println();
		compare("Selection", Selection, "Bubblesort", Bubble);
		compare("Insertion", Insertion, "Bubblesort", Bubble);
		compare("Merge", Merge, "Bubblesort", Bubble);
		System.out.println();
		compare("Insertion", Insertion, "Selection", Selection);
		compare("Bubblesort", Bubble, "Selection", Selection);
		compare("Merge", Merge, "Selection", Selection);
		System.out.println();
		compare("Selection", Selection, "Insertion", Insertion);
		compare("Bubblesort", Bubble, "Insertion", Insertion);
		compare("Merge", Merge, "Insertion", Insertion);

	}

	private static void compare(String First, long first, String Second, long second) {
		float x = ((float) first / (float) second);
		NumberFormat numberformat = new DecimalFormat("##.####");
		String s = numberformat.format(x);

		if (first > second) {
			System.out.print("\n" + Second + " was " + s + " times faster than " + First + ".");
		} else {
			System.out.print("\n" + Second + " was " + s + " the speed of " + First + ".");
		}
	}

	static int[] randomarray() {								// Get a random array of specified size
		int[] a = new int[size];

		for (int i = 0; i < a.length; ++i) {					// Get random elements for it
			a[i] = randomnumber();
		}
		return a;
	}

	static int randomnumber() {										// Throw a random number
		return (int) (((Math.random() * 10) + 1) * size);
	}
}
