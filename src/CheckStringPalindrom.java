public class CheckStringPalindrom {

    public static void main(String[] args) {
        System.out.print(checkStringPalindrom("abcncba"));
    }

    private static boolean checkStringPalindrom(String s) {
        int start=0;
        int end=s.length()-1;
        while(start <= end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
