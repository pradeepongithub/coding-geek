import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {
        int[] arr = {8, 10, 2};
        System.out.println("Max number : " + getMaxInArray(arr.length, arr));
        System.out.println("Min number : " + getMinInArray(arr.length, arr));
        System.out.println("Print Array in original : " + Arrays.toString(arr));
        System.out.print("Print Array in reverse : " );
        printInArrayReverse(arr.length, arr);

        System.out.println("\nLength of a string : " + getLengthOfString("pradeep"));

    }

    private static int getMaxInArray(int size, int... a) {
        if (size == 1) {
            return a[0];
        }
        int max = getMaxInArray(size - 1, a);
        return Integer.max(a[size - 1], max);
    }

    private static int getMinInArray(int size, int... a) {
        if (size == 1) {
            return a[0];
        }
        int min = getMinInArray(size - 1, a);
        return Integer.min(a[size - 1], min);
    }

    private static void printInArrayReverse(int size, int...a){
        if(size == 1){
            System.out.print(" " + a[0]);
            return;
        }
        System.out.print(" " + a[size-1]);
        printInArrayReverse(size-1, a);
    }

    private static int getLengthOfString(String str){
        if(str.equals("")){
            return 0;
        }
        return 1+ getLengthOfString(str.substring(1));
    }



}
