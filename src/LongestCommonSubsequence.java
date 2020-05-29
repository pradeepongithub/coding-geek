import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    static String s1 = "ABFGHKL";
    static String s2 = "ANMABGK";

    public static void main(String[] args) {
        String result = lcsSubStringDP(s1, s2);
        System.out.println("LCS Substring: " + result + " Length: " + result.length());
    }

    private static int lcs(int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + lcs(i - 1, j - 1);
        } else {
            return Integer.max(lcs(i, j - 1), lcs(i - 1, j));
        }
    }

    private static int lcsDP(int i, int j) {
        int[][] lcs = new int[i + 1][j + 1];
        for (int r = 0; r <= i; r++) {
            for (int c = 0; c <= j; c++) {
                if (r == 0 || c == 0) {
                    lcs[r][c] = 0;
                } else if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    lcs[r][c] = 1 + lcs[r - 1][c - 1];
                } else {
                    lcs[r][c] = Integer.max(lcs[r - 1][c], lcs[r][c - 1]);
                }
            }
        }
        return lcs[i][j];
    }

    private static int lcsMap(int i, int j) {
        Map<String, Integer> map = new HashMap<>();
        if (i == 0 || j == 0) {
            return 0;
        }
        String key = i + "|" + j;
        if (!map.containsKey(key)) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                map.put(key, 1 + lcsMap(i - 1, j - 1));
            } else {
                map.put(key, Integer.max(lcsMap(i - 1, j), lcsMap(i, j - 1)));
            }
        }
        return map.get(key);
    }

    private static String lcsSubString(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (l1 == 0 || l2 == 0) {
            return "";
        }
        if (s.charAt(l1 - 1) == t.charAt(l2 - 1)) {
            return s.charAt(l1 - 1) + lcsSubString(s.substring(0, l1 - 1), t.substring(0, l2 - 1));
        } else {
            String a = lcsSubString(s, t.substring(0, l2 - 1));
            String b = lcsSubString(s.substring(0, l1 - 1), t);
            return a.length() > b.length() ? a : b;
        }
    }

    private static String lcsSubStringDP(String a, String b) {
        int[][] lookup = new int[a.length() + 1][b.length() + 1];
        // row 0 and column 0 are initialized to 0 already
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    lookup[i + 1][j + 1] = lookup[i][j] + 1;
                } else {
                    lookup[i + 1][j + 1] = Integer.max(lookup[i + 1][j], lookup[i][j + 1]);
                }
            }
        }
        // read the substring out from the matrix
        StringBuffer sb = new StringBuffer();
        int x = a.length(), y = b.length();
        while (x > 0 && y > 0) {
            // last row,col eq previous row, col then jump in to previous row
            if (lookup[x][y] == lookup[x - 1][y]) {
                x--;
            }
            // last row,col eq row, previous col then jump in to previous col
            else if (lookup[x][y] == lookup[x][y - 1]) {
                y--;
            }
            // char at last row and col matches in both strings jump in to previous row/col
            else if (a.charAt(x - 1) == b.charAt(y - 1)) {
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }
        return sb.reverse().toString();
    }
}
