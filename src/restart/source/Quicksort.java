package restart.source;


public class Quicksort {
    static int partition(int a[], int low, int high) {
        int pivot = a[(low + high) / 2];                // Finding the pivot

        while (low <= high) {
            while (a[low] < pivot)
                low++;
            while (a[high] > pivot)
                high--;
            if (low <= high) {
                swap(a, low++, high--);
            }
        }
        return low;
    }

    static void quickSort(int a[], int low, int high) {
        int index = partition(a, low, high);
        if (low < index - 1)
            quickSort(a, low, index - 1);
        if (index < high)
            quickSort(a, index, high);
    }

    /**
     * Swap is a basic function that exchanges the value of two array indexes. This is done by the
     * help of a temporary variable holding the value of one while they get exchanged.
     *
     * @param a    An array that we are sorting
     * @param low  The position that should hold a smaller int but doesn't at the moment
     * @param high The position that should hold a bigger  int but doesn't at the moment
     */
    private static void swap(int[] a, int low, int high) {        // Swaps the smallest number found in the array
        int temp = a[low];                                        // to where j was
        a[low] = a[high];
        a[high] = temp;
    }
}
