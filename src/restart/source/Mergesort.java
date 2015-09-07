package restart.source;

import java.util.Arrays;

/**
 * One of the most complicated sorting algorithms, but also the fastest one. It recursively calls and divides
 * itself into sub arrays and sorts them as it starts to return to the caller. Mergesort is known as a divide
 * and conquer since it breaks down the problem into two or more sub-problems.
 */
public class Mergesort {

    /**
     * divide is the function where we will simply divide our problem into two or more sub-problems. We achieve
     * this by creating new arrays half of the size of the previous caller, appropriately copy them and recursively
     * call ourselves for more division.
     * @param a An array that is to be sorted at each recursion call.
     */
    public static void divide(int[] a) {                                // Divides a given array recursively
        if (a.length > 1) {                                             // Divide a into two sub arrays
            int[] u = Arrays.copyOfRange(a, 0, (int) Math.floor(a.length / 2));
            int[] v = Arrays.copyOfRange(a, (int) Math.ceil(a.length / 2), a.length);
            divide(u);                                                  // Recursively divide each array
            divide(v);
            merge(a, u, v);                                             // Start ordering them
        }
    }

    /**
     * merge is the second part of the mergesort that starts sorting arrays one that is double in size.
     * Remember that merge was also included in divide so this function can be also called many times
     * by the recursion.
     * @param a An array that has the size of u + v. We know this because in divide we did both u/2 and v/2
     *          So for an array of size 13,
     * @param u
     * @param v
     */
    public static void merge(int[] a, int[] u, int[] v) {               // merge will ignore duplicates
        int i, j, k;
        i = j = k = 0;
        while (i < u.length + v.length) {                               // If a array has space
            if (j < u.length && k < v.length) {                         // And both array have elements left
                if (u[j] < v[k]) {                                      // First array has the smaller element
                    a[i++] = u[j++];
                } else {                                                // Second array has the smaller element
                    a[i++] = v[k++];
                }
            } else {                                                    // One of the arrays is exhausted
                if (j >= u.length) {                                    // Array u is exhausted
                    while (k < v.length) {                              // Copy remaining v elements
                        a[i++] = v[k++];
                    }
                }
                if (k >= v.length) {                                    // Array v is exhausted
                    while (j < u.length) {                              // Copy remaining u elements
                        a[i++] = u[j++];
                    }
                }
            }
        }
    }
                                                                        // mergenoduplicate will now ignore duplicates
    public static void mergenoduplicate(int[] a, int[] u, int[] v) {
        int i, j, k;                                                    // It needs help from cleanup
        i = j = k = 0;
        while (j < u.length && k < v.length) {                          // If both arrays have elements left
            if (i > 0 && a[i - 1] == u[j]) {                            // Check for duplicates
                j++;
            } else if (i > 0 && a[i - 1] == v[k]) {
                k++;
            } else if (u[j] < v[k]) {                                   // See which is smaller
                a[i++] = u[j++];
            } else if (v[k] < u[j]) {
                a[i++] = v[k++];
            } else if (v[k] == u[j]) {                                  // If they both equal
                a[i++] = v[k++];
            }
        }
        if (j < u.length) {                                             // Array v is exhausted
            while (j < u.length) {                                      // Copy the rest of array u
                if (a[i - 1] != u[j]) {
                    a[i++] = u[j++];
                } else {
                    ++j;
                }
            }
        } else {                                                        // Array u is exhausted
            while (k < v.length) {                                      // Copy the rest of array v
                if (a[i - 1] != v[k]) {
                    a[i++] = v[k++];
                } else {
                    ++k;
                }
            }
        }
        if (i < u.length + v.length) {                                  // If a has still placeholders,
            while (i < u.length + v.length) {                           // must have been for duplicates.
                a[i++] = 0;                                             // Put 0 in those positions.
            }
        }
    }

    public int[] cleanup(int[] c) {                                     // Removes 0s from passed in arrays
        if (c != null && c.length > 0) {
            int[] temp = new int[c.length];                             // Temp array with same size
            int loop = 1;
            temp[0] = c[0];                                             // Copy the first element
            for (int i = 1; i < c.length; ++i) {                        // Copy the rest
                if (c[i] != 0) {                                        // Check for 0s
                    temp[loop++] = c[i];
                }
            }
            int[] temp2 = new int[loop];                                // Temp array with the appropriate size
            System.arraycopy(temp, 0, temp2, 0, loop);                  // Copy from first temp to the second one
            return temp2;
        } else {
            return null;
        }
    }
}
