import java.util.ArrayList;
import java.util.List;

public class PrintArraySubSequence {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        printSubSequences(new int[]{1,4,3}, 0, list);
    }

    static void printSubSequences(int[] arr, int start, List<Integer> chosen) {

        if(start > arr.length) {
            return;
        }
        else {
            for (int i = start; i < arr.length; i++) {
                //choose
                chosen.add(arr[i]);
                System.out.println(chosen);
                //explore
                printSubSequences(arr, i + 1, chosen);
                //un-choose
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}
