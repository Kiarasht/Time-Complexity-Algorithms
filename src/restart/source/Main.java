package restart.source;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
	private static int size = 10;
	private static int loop = 5;

	public static void main(String[] args) throws InterruptedException {
		long totalTime;                                                     // Used to calculate time at each sub section
		long endTime;
		long startTime;
		long Selection = 0;
		long Merge = 0;
		long Insertion = 0;

		int[] b = randomarray();                                            // This is a redundant call but it helps
		Selectionsort.selectionsort(b, b.length);                           // the class be loaded before starting

		System.out.println("First, Selection.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {                                    // Do the test on Selectionsort
			int[] a = randomarray();
			startTime = System.currentTimeMillis();
			Selectionsort.selectionsort(a, a.length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Selection += totalTime;
			System.out.println("Time for array of size " + size + ": " + totalTime + " milliseconds.");
			size = size * 10;
		}
		System.out.println("Total Time: " + Selection + " milliseconds.");
		size = 10;

		System.out.println("\nSecond, Merge.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {                                   // Do the test on Mergesort
			int[] a = randomarray();
			startTime = System.currentTimeMillis();
			Mergesort.divide(a);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Merge += totalTime;
			System.out.println("Time for array of size " + size + ": " + totalTime + " milliseconds.");
			size = size * 10;
		}
		System.out.println("Total Time: " + Merge + " milliseconds.");
		size = 10;

		System.out.println("\nThird, Insertion.\n");
		Thread.sleep(4000);

		for (int i = 0; i < loop; ++i) {                                   // Do the test on Insertion
			int[] a = randomarray();
			startTime = System.currentTimeMillis();
			Insertionsort.sort(a, a.length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Insertion += totalTime;
			System.out.println("Time for array of size " + size + ": " + totalTime + " milliseconds.");
			size = size * 10;
		}
		System.out.println("Total Time: " + Insertion + " milliseconds.");
		size = 10;

		compare("Selection", Selection, "Merge", Merge);                    // Compare all of them
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

	static int[] randomarray() {                                            // Get a random array of specified size
		int[] a = new int[size];

		for (int i = 0; i < a.length; ++i) {                                // Get random elements for it
			a[i] = randomnumber();
		}
		return a;
	}

	static int randomnumber() {
		return (int) (((Math.random() * 10) + 1) * size);
	}
}
