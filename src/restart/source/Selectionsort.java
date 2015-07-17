package restart.source;


public class Selectionsort {
    public static int[] selectionsort(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            swap(a, index, i);
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
