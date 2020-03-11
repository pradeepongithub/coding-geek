import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintSubArraySum {


    public static void main(String[] args) {
        printSubArraySumToZero(new int[] { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 });

        List<String> pairs = printSubArraySumToZeroHashMap(new int[] { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 });

        for(int i=0; i<pairs.size();i++){
            System.out.println("Pairs:  " + pairs.get(i));
        }
    }

    private static void printSubArraySumToZero(int... arr){
        for (int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==0){
                    System.out.println("Subarray[" + i + ".." + j + "]");
                }
            }
        }
    }

    private static List<String> printSubArraySumToZeroHashMap(int... arr){
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> pairs =new ArrayList<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
            pairs.add("0, " + i);
            }
            if(map.containsKey(sum)){
                for(int j=0;i<pairs.size();j++){
                    pairs.add(" " + map.get(j)+1 + " , " + i);
                }
            }
            pairs.add(" " + i);
            map.put(sum,pairs);
        }
        return pairs;
    }

}
