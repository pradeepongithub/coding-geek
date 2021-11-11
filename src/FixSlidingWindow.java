import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.*;

public class FixSlidingWindow {

    public static void main(String[] args) {

        //problem: Maximum Sum Subarray of size K

        int[] arr = {4, 10, 2, 18, 3, 12, 2, 6, 7, 1, 4, 8};
        int k = 4;
        int sum = 0, max = 0, n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            sum = sum + arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Integer.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }

        //System.out.println(max);

        int[] arr1 = {7, 9, -1, 2, 3, 4, -2, -3, -4};

        //getFirstNegativeNoInWindowSizeK(3, arr1);
        firstNegativeNumberSlidingWindow(3, arr1);

    }

    //Naive solution O(n^2), O(1)
    private static void getFirstNegativeNoInWindowSizeK(int k, int... arr) {

        for (int i = 0; i < arr.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    out.println(" " + arr[j]);
                    break;
                }
            }
        }
    }

    //optimum with sliding window O(n), O(1)
    private static void firstNegativeNumberSlidingWindow(int k, int... a) {

        int i = 0, j = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (j < a.length) {
            if (a[j] < 0) {
                queue.add(a[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (queue.isEmpty()) {
                    out.print(" " + "0");
                } else {
                    int num = queue.peek();
                    out.print(" " + num);
                    if (num == a[i]) {
                        queue.remove();
                    }
                }
                i++;
                j++;
            }
        }

    }

}
