package restart.source;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time.
 * It will go through the list and move an index back until it finds a suitable place for it.
 */
public class Insertionsort {

    /**
     * The main function where the Insertionsort algorithm is defined.
     *
     * @param a An array that needs to be sorted
     * @param n The size of the array being passed from Main
     */
    public static void sort(int[] a, int n) {                       // Insertion implementation
        for (int i = 1; i <= n - 1; ++i) {                          // Find a number and moves it back until
            int x = a[i];                                           // it finds its perfect place
            int j = i;

            while (j > 0 && a[j - 1] > x) {                         // Move element one ahead to create space
                a[j] = a[j - 1];                                    // for the coming element
                j = j - 1;
            }
            a[j] = x;
        }
    }
}
