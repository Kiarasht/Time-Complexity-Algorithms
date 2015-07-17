package restart.source;

public class Main {
    private static int size = 100;

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            int[] a = randomarray();
            long startTime = System.currentTimeMillis();
            //System.out.println(Arrays.toString(a));
            Selectionsort.selectionsort(a, a.length);
            //System.out.println(Arrays.toString(a));
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("\nTime for array of size " + size + ": " + totalTime + " milliseconds.");
            size = size * 10;
        }
    }

    static int[] randomarray() {
        int[] a = new int[size];

        for (int i = 0; i < a.length; ++i) {
            a[i] = randomnumber();
        }
        return a;
    }

    static int randomnumber() {
        return (int) (((Math.random() * 10) + 1) * size);
    }
}
