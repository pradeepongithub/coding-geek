import java.util.Arrays;

public class smallestPair {

    public static void main(String[] args) {
        getSmallestPair(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});
    }

    public static void getSmallestPair(int[] a, int[] b) {

        int smallest = Integer.MAX_VALUE;
        String smallestPair = new String();
        int i = 0, j = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (i < a.length && j < b.length) {
            int currentDiff = Math.abs(a[i]-b[j]);

            if (currentDiff < smallest) {
                smallest = currentDiff;
                smallestPair = a[i] + " , " + b[j];
            } else if (a[i] < b[j]) {
               i++;
            } else {
                j++;
            }
        }
        System.out.println("Smallest Pair: " + smallestPair);
    }

}
