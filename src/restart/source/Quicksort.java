package restart.source;


public class Quicksort {
    int partition(int a[], int low, int high)
    {
        int pivot = a[(low + high) / 2];                // Finding the pivot

        while (low <= high) {
            while (a[low] < pivot)
                low++;
            while (a[high] > pivot)
                high--;
            if (low <= high) {
                int tmp = a[low];
                a[low] = a[high];
                a[high] = tmp;
                low++;
                high--;
            }
        }
        return low;
    }

    void quickSort(int a[], int low, int high) {
        int index = partition(a, low, high);
        if (low < index - 1)
            quickSort(a, low, index - 1);
        if (index < high)
            quickSort(a, index, high);
    }
}
