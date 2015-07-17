package restart.source;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Selectionsort {
    public static int[] selectionsort(int[] a, int n) {
        for (int i = 0; i < n - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            swap(a, index, i);
            System.out.print("Hang tight, we are " + loading(i, n) + "% done. " + (i + 2) + "/" + n + "\r");
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static String loading(int i, int n) {
        float x = ((float) (i + 2) / (float) n) * 100f;
        NumberFormat numberformat = new DecimalFormat("#");
        return numberformat.format(x);
    }
}
