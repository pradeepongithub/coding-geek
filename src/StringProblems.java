import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProblems {

    public static void main(String[] args) {
        //System.out.println("Check String s is permute of t : " + isPermutation("abc","cab"));
        //System.out.println(printLength("HellO world"));
        toCharArray("hello WorLD ");
        toCharArrayReflection("hello woRLD");
    }

    static boolean isPermutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[]s1 = s.toCharArray();
        char[]s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i=0;i<s.length();i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
    static boolean isPermute(String s, String t){
        
        return true;
    }

    static int printLength(String str){

        System.out.println(" String length: " + str.lastIndexOf(""));

        //Regex Pattern/Matcher to find String length
        Matcher m = Pattern.compile("$").matcher(str);
        m.find();
        System.out.println("Length " + m.end());

        //Recursion way to find the String length
        int l=0;
        if(str.equals("")){
            return 0;
        }
        int index=0;
        l= printLength(str.substring(index+1))+1;
        return l;
    }

    static void toCharArray(String str) {
        char[] chArr = new char[str.length()];
        int i = 0;
        while (i < str.length()) {
            chArr[i] = str.charAt(i);
            System.out.print("" + chArr[i]);
            i++;
        }

    }

    private static void toCharArrayReflection(String str) {
        Field field = null;
        try {
            field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] chArray = (char[]) field.get(str);
            System.out.println("\nChars : ");
            for(char c:chArray){
                System.out.println(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
