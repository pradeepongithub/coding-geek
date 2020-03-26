import java.util.Set;
import java.util.TreeSet;

public class findIndicesOfPalindromSubstrings {

    public static void main(String[] args) {

        getIndicesOfPalindromSubstrings("abcba");
    }

    private static void getIndicesOfPalindromSubstrings(String s) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new TreeSet<>();
        //odd and even length of palindrome
        for(int i=0;i<s.length();i++){
            //even length palindrom
            getIndicesInPalindrome(s, i, i, set);
            //even odd palindrom
            getIndicesInPalindrome(s, i,i+1, set);
        }
        System.out.println("substrings : " + set.toString());
    }

    private static void getIndicesInPalindrome(String s, int left, int right, Set<String> set) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            System.out.println("index: " + left + "," + right);
            left--;
            right++;
            set.add(s.substring(left+1, right));
        }
    }



}
