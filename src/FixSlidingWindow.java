import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static java.lang.System.*;

public class FixSlidingWindow {

    public static void main(String[] args) {

        //problem: Maximum Sum Sub array of size K

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

        int[] arr1 = {7, 9, -1, 2, 3, 4, -2, -3, -4};

        //getFirstNegativeNoInWindowSizeK(3, arr1);
        //firstNegativeNumberSlidingWindow(3, arr1);
        //countNumberOfAnagramBruteForce("abc", "abccbabcazb");
        countAllAnagramSlidingWindow("abc", "abcvbacbacab");


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

    public static int countNumberOfAnagramBruteForce(String p, String s) {

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = p.toCharArray();
        char[] sChars = s.toCharArray();
        int count = 0;
        int anagramCount = 0;
        int k = p.length();

        for (int i = 0; i < k; i++) {
            if (map.containsKey(chars[i])) {
                int n = map.get(chars[i]);
                map.put(chars[i], ++n);
            } else {
                map.put(chars[i], 1);
            }
        }

        for (int i = 0; i < (s.length() - k); i++) {
            if (map.size() == count) {
                anagramCount++;
            }
            count = 0;
            for (int j = i; j < i + k; j++) {
                if (map.containsKey(sChars[j])) {
                    count++;
                } else {
                    break;
                }
            }

        }
        return anagramCount;

    }

    public static void countAllAnagramSlidingWindow(String p, String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, count = map.size(), ans = 0, k = p.length(), n = s.length();

        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            if (map.containsKey(c) && map.get(c) == 0) {
                count--;
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                if (count == 0) {
                    ans++;
                }
                c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
                if (map.containsKey(c) && map.get(c) > 0) {
                    count++;
                }
                i++;
                j++;

            }
        }
        out.println(ans);

    }

}
