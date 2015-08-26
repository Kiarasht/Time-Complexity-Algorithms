package test;

import java.util.Arrays;
import org.junit.Test;
import restart.source.Insertionsort;
import restart.source.Bubblesort;
import restart.source.Mergesort;
import restart.source.Selectionsort;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void checkInsertion() {
        int size = 100;
        int k = 0;
        int a[][] = new int[4][];

        for (int i = 0; i < a.length; ++i) {        //Initialize all arrays to size of 100, 4 of them
            a[i] = new int[100];
        }
        for (int i = 0; i < a[0].length; ++i) {     // This array is already sorted
            a[0][i] = i;
        }
        for (int i = 100; i > 0; --i) {             // This array is in reverse
            a[1][k++] = i;
        }
        for (int i = 0; i < a[2].length; ++i) {     // This array is random
            a[2][i] = (int) (((Math.random() * 10) + 1) * size);
        }
        for (int i = 0; i < a[3].length; ++i) {     // This array is random with many alike values
            a[3][i] = (int) ((Math.random() * 10) + 1) * size;
        }

        for (int i = 0; i < a[0].length; ++i) {
            int [] sorta = new int[100];            // Get the same amount of arrays
            int [] sortb = new int[100];
            int [] sortc = new int[100];
            int [] sortd = new int[100];            // Copy values to new arrays
            System.arraycopy(a[0], 0, sorta, 0, a[0].length);
            System.arraycopy(a[1], 0, sortb, 0, a[1].length);
            System.arraycopy(a[2], 0, sortc, 0, a[2].length);
            System.arraycopy(a[3], 0, sortd, 0, a[3].length);
            Insertionsort.sort(a[0], a[0].length);  // Sort using our code
            Insertionsort.sort(a[1], a[1].length);
            Insertionsort.sort(a[2], a[2].length);
            Insertionsort.sort(a[3], a[3].length);
            Arrays.sort(sorta);                     // Sort using java provided sort
            Arrays.sort(sortb);
            Arrays.sort(sortc);
            Arrays.sort(sortd);                     // Compare to see if our algorithm works
            assertTrue(Arrays.equals(a[0], sorta));
            assertTrue(Arrays.equals(a[1], sortb));
            assertTrue(Arrays.equals(a[2], sortc));
            assertTrue(Arrays.equals(a[3], sortd));
        }
    }

    @Test
    public void chechBubble() {
        int size = 100;
        int k = 0;
        int a[][] = new int[4][];

        for (int i = 0; i < a.length; ++i) {        //Initialize all arrays to size of 100, 4 of them
            a[i] = new int[100];
        }
        for (int i = 0; i < a[0].length; ++i) {     // This array is already sorted
            a[0][i] = i;
        }
        for (int i = 100; i > 0; --i) {             // This array is in reverse
            a[1][k++] = i;
        }
        for (int i = 0; i < a[2].length; ++i) {     // This array is random
            a[2][i] = (int) (((Math.random() * 10) + 1) * size);
        }
        for (int i = 0; i < a[3].length; ++i) {     // This array is random with many alike values
            a[3][i] = (int) ((Math.random() * 10) + 1) * size;
        }

        for (int i = 0; i < a[0].length; ++i) {
            int [] sorta = new int[100];            // Get the same amount of arrays
            int [] sortb = new int[100];
            int [] sortc = new int[100];
            int [] sortd = new int[100];            // Copy values to new arrays
            System.arraycopy(a[0], 0, sorta, 0, a[0].length);
            System.arraycopy(a[1], 0, sortb, 0, a[1].length);
            System.arraycopy(a[2], 0, sortc, 0, a[2].length);
            System.arraycopy(a[3], 0, sortd, 0, a[3].length);
            Bubblesort.BubbleSort(a[0], a[0].length);// Sort using our code
            Bubblesort.BubbleSort(a[1], a[1].length);
            Bubblesort.BubbleSort(a[2], a[2].length);
            Bubblesort.BubbleSort(a[3], a[3].length);
            Arrays.sort(sorta);                     // Sort using java provided sort
            Arrays.sort(sortb);
            Arrays.sort(sortc);
            Arrays.sort(sortd);                     // Compare to see if our algorithm works
            assertTrue(Arrays.equals(a[0], sorta));
            assertTrue(Arrays.equals(a[1], sortb));
            assertTrue(Arrays.equals(a[2], sortc));
            assertTrue(Arrays.equals(a[3], sortd));
        }
    }

    @Test
    public void chechMerge() {
        int size = 100;
        int k = 0;
        int a[][] = new int[4][];

        for (int i = 0; i < a.length; ++i) {        //Initialize all arrays to size of 100, 4 of them
            a[i] = new int[100];
        }
        for (int i = 0; i < a[0].length; ++i) {     // This array is already sorted
            a[0][i] = i;
        }
        for (int i = 100; i > 0; --i) {             // This array is in reverse
            a[1][k++] = i;
        }
        for (int i = 0; i < a[2].length; ++i) {     // This array is random. * by size then casts
            a[2][i] = (int) (((Math.random() * 10) + 1) * size);
        }
        for (int i = 0; i < a[3].length; ++i) {     // This array is random with many alike values. Casts then * by size
            a[3][i] = (int) ((Math.random() * 10) + 1) * size;
        }

        for (int i = 0; i < a[0].length; ++i) {
            int [] sorta = new int[100];            // Get the same amount of arrays
            int [] sortb = new int[100];
            int [] sortc = new int[100];
            int [] sortd = new int[100];            // Copy values to new arrays
            System.arraycopy(a[0], 0, sorta, 0, a[0].length);
            System.arraycopy(a[1], 0, sortb, 0, a[1].length);
            System.arraycopy(a[2], 0, sortc, 0, a[2].length);
            System.arraycopy(a[3], 0, sortd, 0, a[3].length);
            Mergesort.divide(a[0]);                 // Sort using our code
            Mergesort.divide(a[1]);
            Mergesort.divide(a[2]);
            Mergesort.divide(a[3]);
            Arrays.sort(sorta);                     // Sort using java provided sort
            Arrays.sort(sortb);
            Arrays.sort(sortc);
            Arrays.sort(sortd);                     // Compare to see if our algorithm works
            assertTrue(Arrays.equals(a[0], sorta));
            assertTrue(Arrays.equals(a[1], sortb));
            assertTrue(Arrays.equals(a[2], sortc));
            assertTrue(Arrays.equals(a[3], sortd));
        }
    }

    @Test
    public void chechSelection() {
        int size = 100;
        int k = 0;
        int a[][] = new int[4][];

        for (int i = 0; i < a.length; ++i) {        //Initialize all arrays to size of 100, 4 of them
            a[i] = new int[100];
        }
        for (int i = 0; i < a[0].length; ++i) {     // This array is already sorted
            a[0][i] = i;
        }
        for (int i = 100; i > 0; --i) {             // This array is in reverse
            a[1][k++] = i;
        }
        for (int i = 0; i < a[2].length; ++i) {     // This array is random. * by size then casts
            a[2][i] = (int) (((Math.random() * 10) + 1) * size);
        }
        for (int i = 0; i < a[3].length; ++i) {     // This array is random with many alike values. Casts then * by size
            a[3][i] = (int) ((Math.random() * 10) + 1) * size;
        }

        for (int i = 0; i < a[0].length; ++i) {
            int [] sorta = new int[100];            // Get the same amount of arrays
            int [] sortb = new int[100];
            int [] sortc = new int[100];
            int [] sortd = new int[100];            // Copy values to new arrays
            System.arraycopy(a[0], 0, sorta, 0, a[0].length);
            System.arraycopy(a[1], 0, sortb, 0, a[1].length);
            System.arraycopy(a[2], 0, sortc, 0, a[2].length);
            System.arraycopy(a[3], 0, sortd, 0, a[3].length);
            Selectionsort.selectionsort(a[0], a[0].length);// Sort using our code
            Selectionsort.selectionsort(a[1], a[1].length);
            Selectionsort.selectionsort(a[2], a[2].length);
            Selectionsort.selectionsort(a[3], a[3].length);
            Arrays.sort(sorta);                     // Sort using java provided sort
            Arrays.sort(sortb);
            Arrays.sort(sortc);
            Arrays.sort(sortd);                     // Compare to see if our algorithm works
            assertTrue(Arrays.equals(a[0], sorta));
            assertTrue(Arrays.equals(a[1], sortb));
            assertTrue(Arrays.equals(a[2], sortc));
            assertTrue(Arrays.equals(a[3], sortd));
        }
    }
}
