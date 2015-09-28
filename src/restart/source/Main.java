package restart.source;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class holds the functions and variables that are needed to use and test the different sorting algorithms.
 * Also creates arrays of sizes 10, 100, 1000, 10000, and 100000 to test the performance of each algorithm. Before
 * you begin using or reading this program you should know where some of the stuffs here came from:
 * https://en.wikipedia.org/wiki/Main_Page
 * http://www.sorting-algorithms.com/
 * http://bigocheatsheet.com/
 */
public class Main {
	private static Map<Integer, String> data = new HashMap<>();
	private final static int SORT_IMPLEMENTED = 5;
	private static int leaderinsertion = 0;
	private static int leaderselection = 0;
	private static int leaderbubble = 0;
	private static int leadermerge = 0;
	private static int leaderquick = 0;
	private static int size = 10;
	private static int loop = 5;
	private static int current = 0;
	private static int[][] a = new int[loop][];
	private static int[][] b = new int[loop][];

	/**
	 * Bread and butter of the program starts right here at main. We start by declaring long values that will
	 * be used for comparing the sorting algorithms. Here we will be only comparing them using randomly generated
	 * arrays and later on using sorted, inverted, and same values arrays.
	 *
	 * @param args Nothing, this program does not except args
	 */
	public static void main(String[] args) {
		try {
			if (args.length != 0) {
				throw new Exception("Program can not accept additional arguments.");
			}

			for (int arraytype = 0; arraytype < 4; ++arraytype) {
				size = 10;
				long totalTime;
				long endTime;
				long startTime;
				long Selection = 0;
				long Merge = 0;
				long Insertion = 0;
				long Bubble = 0;
				long Quick = 0;

				if (arraytype == 0) {
					for (int i = 0; i < loop; ++i) {
						a[i] = randomarray();
						size *= 10;
					}
				} else if (arraytype == 1) {
					for (int i = 0; i < loop; ++i) {
						a[i] = inorderarray();
						size *= 10;
					}
				} else if (arraytype == 2) {
					for (int i = 0; i < loop; ++i) {
						a[i] = reversearray();
						size *= 10;
					}
				} else if (arraytype == 3) {
					for (int i = 0; i < loop; ++i) {
						a[i] = similararray();
						size *= 10;
					}
				}

				for (int i = 0; i < loop; i++) {
					b[i] = new int[a[i].length];
					System.arraycopy(a[i], 0, b[i], 0, a[i].length);
				}

				ready("First", "Selection");

				for (int i = 0; i < loop; ++i) {
					startTime = System.currentTimeMillis();
					Selectionsort.selectionsort(a[i], a[i].length);
					endTime = System.currentTimeMillis();
					totalTime = endTime - startTime;
					Selection += totalTime;
					System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
				}
				System.out.println("Total Time: " + Selection + " milliseconds.");

				recopy();
				ready("Second", "Mergesort");

				for (int i = 0; i < loop; ++i) {
					startTime = System.currentTimeMillis();
					Mergesort.divide(a[i]);
					endTime = System.currentTimeMillis();
					totalTime = endTime - startTime;
					Merge += totalTime;
					System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
				}
				System.out.println("Total Time: " + Merge + " milliseconds.");

				recopy();
				ready("Third", "Insertion");

				for (int i = 0; i < loop; ++i) {
					startTime = System.currentTimeMillis();
					Insertionsort.sort(a[i], a[i].length);
					endTime = System.currentTimeMillis();
					totalTime = endTime - startTime;
					Insertion += totalTime;
					System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
				}
				System.out.println("Total Time: " + Insertion + " milliseconds.");

				recopy();
				ready("Fourth", "Bubble");

				for (int i = 0; i < loop; ++i) {
					startTime = System.currentTimeMillis();
					Bubblesort.BubbleSort(a[i], a[i].length);
					endTime = System.currentTimeMillis();
					totalTime = endTime - startTime;
					Bubble += totalTime;
					System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
				}
				System.out.println("Total Time: " + Bubble + " milliseconds.");

				recopy();
				ready("Fifth", "Quick");

				for (int i = 0; i < loop; ++i) {
					startTime = System.currentTimeMillis();
					Quicksort.quickSort(a[i], 0, a[i].length - 1);
					endTime = System.currentTimeMillis();
					totalTime = endTime - startTime;
					Quick += totalTime;
					System.out.println("Time for array of size " + a[i].length + ": " + totalTime + " milliseconds.");
				}
				System.out.println("Total Time: " + Quick + " milliseconds.");

				compare("Selection", Selection, "Merge", Merge);
				compare("Insertion", Insertion, "Merge", Merge);
				compare("Bubblesort", Bubble, "Merge", Merge);
				compare("Quick", Quick, "Merge", Merge);
				System.out.println();
				compare("Selection", Selection, "Bubblesort", Bubble);
				compare("Insertion", Insertion, "Bubblesort", Bubble);
				compare("Merge", Merge, "Bubblesort", Bubble);
				compare("Quick", Quick, "Bubblesort", Bubble);
				System.out.println();
				compare("Insertion", Insertion, "Selection", Selection);
				compare("Bubblesort", Bubble, "Selection", Selection);
				compare("Merge", Merge, "Selection", Selection);
				compare("Quick", Quick, "Selection", Selection);
				System.out.println();
				compare("Selection", Selection, "Insertion", Insertion);
				compare("Bubblesort", Bubble, "Insertion", Insertion);
				compare("Merge", Merge, "Insertion", Insertion);
				compare("Quick", Quick, "Insertion", Insertion);
				System.out.println();
				compare("Selection", Selection, "Quick", Quick);
				compare("Insertion", Insertion, "Quick", Quick);
				compare("Bubblesort", Bubble, "Quick", Quick);
				compare("Merge", Merge, "Quick", Quick);

				data.put(leaderinsertion, "Insertion");
				data.put(leaderselection, "Selection");
				data.put(leaderbubble, "Bubble");
				data.put(leadermerge, "Merge");
				data.put(leaderquick, "Quick");

				leaderboard();
			}
		} catch (InterruptedException e) {
			System.out.println("I had trouble using the sleep function. Here is what happened:");
			System.out.println(e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("I had trouble running the main function. Here is what happened:");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Sorts and prints algorithms based on which ever performed the best to which ever performed
	 * the worse. Uses the map data type to link an Integer value to its String.
	 */
	private static void leaderboard() {
		int order = 1;
		System.out.println("\n");
		System.out.println("Leaderboard:\n");

		for (int i = 0; i < SORT_IMPLEMENTED; ++i) {
			String result = data.get(i);
			System.out.println(order + ") " + result);
			++order;
		}
	}

	/**
	 * Compares two sorting algorithms using their specific recorded timings. A specific
	 * print out is done depending which is bigger or smaller than the other. A number
	 * formatter is used to force only to the 4th zero position if more were available.
	 *
	 * @param First  The name of the first sorting algorithm.
	 * @param first  The time it took to finish the first sorting algorithm.
	 * @param Second The name of the second sorting algorithm.
	 * @param second The time it took to finish the second sorting algorithm.
	 */
	private static void compare(String First, long first, String Second, long second) {
		float x = ((float) first / (float) second);
		NumberFormat numberformat = new DecimalFormat("##.####");
		String s = numberformat.format(x);

		if (first > second) {
			System.out.print("\n" + Second + " was " + s + " times faster than " + First + ".");
			switch (First) {
				case "Selection":
					++leaderselection;
					break;
				case "Insertion":
					++leaderinsertion;
					break;
				case "Bubblesort":
					++leaderbubble;
					break;
				case "Merge":
					++leadermerge;
					break;
				case "Quick":
					++leaderquick;
			}
		} else {
			System.out.print("\n" + Second + " was " + s + " the speed of " + First + ".");
		}
	}

	/**
	 * Creates a random array using the current size which should be multiples of 10.
	 *
	 * @return Returns a pointer to the newly created array.
	 */
	static int[] randomarray() {
		int[] a = new int[size];

		for (int i = 0; i < a.length; ++i) {
			a[i] = randomnumber();
		}
		return a;
	}

	static int[] inorderarray() {
		int[] a = new int[size];

		for (int i = 0; i < size; ++i) {
			a[i] = i;
		}
		return a;
	}

	static int[] reversearray() {
		int[] a = new int[size];
		int k = 0;

		for (int i = size; i > 0; --i) {
			a[k++] = i;
		}

		return a;
	}

	static int[] similararray() {
		int[] a = new int[size];

		for (int i = 0; i < size; ++i) {
			a[i] = (int) ((Math.random() * 10) + 1) * size;
		}
		
		return a;
	}

	/**
	 * randomnumber returns an int proportional to the size of an array. If size is 10 for example, the range
	 * is within 10 to 109 and 100 to 1099 and etc...
	 *
	 * @return An int that is randomly generated and returned to the caller
	 */
	static int randomnumber() {
		return (int) (((Math.random() * 10) + 1) * size);
	}

	/**
	 * Ready is a setup function that only deals with print outs and nothing else. It has a feeling of a
	 * "ready, set, go" just for a more user friendly print out.
	 *
	 * @param position The rank it is being applied. ex: First, Second, Third, Fourth, Fifth, etc...
	 * @param sort     The name of the sorting algorithm that will be applied in a moment
	 * @throws InterruptedException If there are any issues with sleep, function will throw its exceptions
	 */
	static void ready(String position, String sort) throws InterruptedException {
		if (current == 0) {
			++current;
		} else {
			System.out.println();
		}

		System.out.print(position + ", " + sort + ".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".\n");
		Thread.sleep(1000);
	}

	/**
	 * Recopy takes array b that holds an array of arrays that was randomly generated and
	 * copies it back into array a after each sorting algorithm been applied. This way the same
	 * array is applied to each sorting algorithm.
	 */
	static void recopy() {
		for (int i = 0; i < loop; i++) {
			System.arraycopy(b[i], 0, a[i], 0, a[i].length);
		}
	}
}
