import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {

    public static void main(String[] args) {
        findPairArraySumBruteForce(10,new int[]{8,7,2,5,3,1});
        findPairArraySumHashMap(10, new int[]{8,7,2,5,3,1});
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
        for(int i=0;1<a.length-1;i++){
            if(map.containsKey(sum-a[i])){
                System.out.println("Pair found by hashmap at index: " + map.get(sum-a[i]) + " and " + i);
                return;
            }
            map.put(a[i],i);
        }

    }


}
