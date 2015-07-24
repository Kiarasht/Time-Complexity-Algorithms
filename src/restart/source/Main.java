package restart.source;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
	private static int size = 10;
	private static int loop = 5;
	private static int [][] a = new int[loop][];
	private static int [][] b = new int[loop][];

	public static void main(String[] args) throws InterruptedException {
		long totalTime;												// Used to calculate time at each sub section
		long endTime;
		long startTime;
		long Selection = 0;
		long Merge = 0;
		long Insertion = 0;

		for (int i = 0; i < loop; ++i) {							// Get a random array of arrays
			a[i] = randomarray();
			size *= 10;
		}

		for (int i = 0; i < loop; i++) {							// Keep a copy of the array a
			b[i] = new int[a[i].length];
			System.arraycopy(a[i], 0, b[i], 0, a[i].length);
		}

		System.out.println("First, Selection.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {							// Do the test on Selectionsort
			startTime = System.currentTimeMillis();
			Selectionsort.selectionsort(a[i], a[i].length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Selection += totalTime;
			System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
		}
		System.out.println("Total Time: " + Selection + " milliseconds.");

		System.out.println("\nSecond, Merge.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {							// Do the test on Mergesort
			startTime = System.currentTimeMillis();
			Mergesort.divide(a[i]);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Merge += totalTime;
			System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
		}
		System.out.println("Total Time: " + Merge + " milliseconds.");

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

		compare("Selection", Selection, "Merge", Merge);			// Compare all of them
		compare("Insertion", Insertion, "Merge", Merge);
		compare("Selection", Selection, "Insertion", Insertion);
	}

	private static void compare(String First, long first, String Second, long second) {
		float x = ((float) first / (float) second);
		NumberFormat numberformat = new DecimalFormat("##.##");
		String s = numberformat.format(x);

		if (first > second) {
			System.out.print("\n" + Second + " was " + s + " times faster than " + First + ".");
		} else {
			System.out.print("\n" + Second + " was " + s + " times slower than " + First + ".");
		}
	}

	static int[] randomarray() {									// Get a random array of specified size
		int[] a = new int[size];

		for (int i = 0; i < a.length; ++i) {						// Get random elements for it
			a[i] = randomnumber();
		}
		return a;
	}

	static int randomnumber() {
		return (int) (((Math.random() * 10) + 1) * size);
	}
}
