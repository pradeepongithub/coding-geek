import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static List<Integer> LIS(int[] A) {
        int[] m = new int[A.length];
        //Arrays.fill(m, 1);//not important here
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = A.length - 1; j > i; j--) {
                if (A[i] < A[j] && m[i] <= m[j]) {
                    m[i]++;//or use m[x] = m[y] + 1;
                }
            }
        }
        int max = m[0];
        for (int i = 1; i < m.length; i++) {
            if (max < m[i]) {
                max = m[i];
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < m.length; i++) {
            if (m[i] == max) {
                result.add(A[i]);
                max--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LIS(new int[]{5, 1, 22, 10, 4, 24, 41, 20}).stream().forEach(System.out::println);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    public static int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return list.get(start) >= target ? start : end;
    }
}
