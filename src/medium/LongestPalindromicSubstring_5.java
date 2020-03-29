package medium;

/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
*
* */

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabbaac"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        if (s == null || n == 0) {
            return "";
        }

        int maxLen = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandByCenter(s, i, i);
            int len2 = expandByCenter(s, i - 1, i);

            if (maxLen < len1) {
                maxLen = len1;
                start = i - len1 / 2;
                end = i + len1 / 2;
            }

            if (maxLen < len2) {
                maxLen = len2;
                start = i - len2 / 2;
                end = i - 1 + len2 / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    public static int expandByCenter(String s, int lo, int hi) {
        int max = 1;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            max = hi - lo + 1;
            hi++;
            lo--;
        }
        return max;
    }
}