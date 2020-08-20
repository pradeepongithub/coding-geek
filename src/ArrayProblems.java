import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {

    public static void main(String[] args) {
        //findPairArraySumBruteForce(10,new int[]{8,7,2,5,3,1});
        //findPairArraySumHashMap(10, new int[]{8,7,2,5,3,1});

        //moveZeroes(new int[]{0,8,7,0,0,3,1,0});
        int[] arr ={0,0,1,0,1,1,1,0,1};
        //sortZerosAndOnes(arr);
        int[] arr1 ={0,0,3,4,4,7,8,9,9};
        removeDuplicateInSortedArray(arr1);
        getIndicesOfElementsSum(7, arr1)
    }

    private static void findPairArraySumBruteForce(int sum, int ...a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length-1;j++)
            if(sum-a[i]==a[j]){
                System.out.println("Pair found at index: " + i + " " + j);
                return;
            }
        }
    }

    private static void findPairArraySumHashMap(int sum, int ...a){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length-1;i++){
            if(map.containsKey(sum-a[i])){
                System.out.println("Pair found by hashmap at index: " + map.get(sum-a[i]) + " and " + i);
                return;
            }
            map.put(a[i],i);
        }

    }

    public static void moveZeroes(int... nums) {
        System.out.println("Input Array: ");
        for (int i : nums) {
            System.out.print("\t" + i);
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println("\nAfter shifting all zeros to end : ");
        for (int i : nums) {
            System.out.print("\t" + i);
        }
    }

    private static void sortZerosAndOnes(int... nums) {
        System.out.print("\nBefore Sort: ");
        Arrays.stream(nums).forEach(i -> System.out.print("\t" + i));
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 1;
        }
        System.out.print("\nAfter Sort: ");
        Arrays.stream(nums).forEach(i -> System.out.print("\t" + i));
    }

    private static void removeDuplicateInSortedArray(int... nums) {
        System.out.println("Original Array:");
        for (int i : nums) {
            System.out.print("\t" + i);
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        System.out.println("\nSorted Array:");
        for (int i = 0; i < k; i++) {
            System.out.print("\t" + nums[i]);
        }
    }

    private static int[] getIndicesOfElementsSum(int targetsum, int... nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length;i++){
            int temp = targetsum-nums[i]
            if(map.containsKey(temp)){
            return new int[]{map.get(i),i}
            }
        }
        return new int[]{};
    }

 }