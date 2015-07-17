package restart.source;

import java.util.Arrays;

public class Main {
    private static int multiply = 1;                                        // At 1 array is 1-10, at 2 array is 2-20...
    private static int[] a = randomarray();
    private static int x = randomnumber(multiply);

    public static void main(String[] args) {

    }

    static int[] randomarray() {
        int[] a = new int[randomnumber(multiply)];                          // Set up array size by the random value

        for (int i = 0; i < a.length; ++i) {                                // Give the first array random values
            a[i] = randomnumber(multiply);
        }
        return a;
    }

    static int randomnumber(int size) {
        return (int) (((Math.random() * 10) + 1) * size);
    }
}
