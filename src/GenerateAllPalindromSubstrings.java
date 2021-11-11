import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class GenerateAllPalindromSubstrings {

    public static void main(String[] args) {
        generatePalindromSubStrings("abcba");
    }

    private static void generatePalindromSubStrings(String s) {
        Set<String> subStrings = new HashSet<>();

        for(int i=0;i<s.length();i++){
            expand(s, i, i, subStrings); //even length palindrom
            expand(s,i,i+1, subStrings); //odd length palindrom
        }
        System.out.println("Palindrom substring: " + subStrings);

    }

    private static void expand(String s, int left, int right, Set<String> subStrings) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
              //expend
                left--;
                right++;
                subStrings.add(s.substring(left+1, right));
        }
    }
}
