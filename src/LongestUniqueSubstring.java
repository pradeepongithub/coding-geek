import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static void main(String[] args) {

        System.out.println("Longest Ditinct Substring in `aabmnaa` is : " + longestDistinctSubString("aabbmnaa"));
    }

    private static String longestDistinctSubString(String s) {
        Map<Character, Integer /* pos */> map = new HashMap<>();
        String longest = s.substring(0, 1); // first char so we don't have to worry about null
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Integer.max(start, map.get(s.charAt(i)) + 1);
            }
            if (i + 1 - start > longest.length()) {
                longest = s.substring(start, i + 1);
            }
            map.put(s.charAt(i), i);
        }
        return longest;
    }
}
