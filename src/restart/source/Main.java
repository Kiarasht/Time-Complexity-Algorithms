package restart.source;

public class Main {
	private static int size = 10;

	public static void main(String[] args) throws InterruptedException {
		long totalTime;                                                     // Used to calculate time at each sub section
		long endTime;
		long startTime;
		long Selection = 0;
		long Merge = 0;

		int[] b = randomarray();                                            // This is a redundant call but it helps
		Selectionsort.selectionsort(b, b.length);                           // the class be loaded before starting
		System.out.println("Lets sort arrays with 10, 100, 1000, 10000, and 100000 elements.");
		Thread.sleep(3000);
		System.out.println("First, Selection.\n");
		Thread.sleep(3000);

		for (int i = 0; i < 5; ++i) {                                       // Do the test on Selectionsort
			int[] a = randomarray();
			startTime = System.currentTimeMillis();
			Selectionsort.selectionsort(a, a.length);
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			Selection += totalTime;
			System.out.println("\nTime for array of size " + size + ": " + totalTime + " milliseconds.");
			size = size * 10;
		}
		System.out.println("Total Time: " + Selection + " milliseconds.");
		size = 10;

		System.out.println("\nSelection is by far one of the slowest sorting algorithms. Now lets try a faster one.");
		Thread.sleep(3000);
		System.out.println("Second, Merge.\n");
		Thread.sleep(3000);

		for (int i = 0; i < 5; ++i) {                                       // Do the test on Mergesort
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

		compare("Selection", Selection, "Merge", Merge);
	}

	private static void compare(String First, long first, String Second, long second) {
		if (first > second) {
			System.out.println("\n" + Second + " was " + first / second + " times faster than " + First + ".");
		} else {
			System.out.println("\n" + Second + " was " + second / first + " times slower than " + First + ".");
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
