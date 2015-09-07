package restart.source;

/**
 * Bubblesort repeatedly steps through the list to be sorted, compares each pair of adjacent items and
 * swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are
 * needed, which indicates that the list is sorted.
 */
public class Bubblesort {

    /**
     * Bubblesort is the main function that follows the Bubble sort algorithm. It starts with a flag of
     * false and will it set it to true if it ever had to swap to values. If no swaps were done, the loop
     * will then exit.
     * @param a An array that needs to be sorted
     * @param n The size of the array
     */
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

    /**
     * Swap is a basic function that exchanges the value of two array indexes. This is done by the
     * help of a temporary variable holding the value of one while they get exchanged.
     * @param a An array that we are sorting
     * @param i The position that should hold a smaller int but doesn't at the moment
     * @param j The position that should hold a bigger  int but doesn't at the moment
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
