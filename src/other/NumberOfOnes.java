/**
 * Given a number s in their binary representation. Return the number of steps to reduce it to 1 under the following rules:
 * <p>
 * If the current number is even, you have to divide it by 2.
 * <p>
 * If the current number is odd, you have to add 1 to it.
 * <p>
 * It's guaranteed that you can always reach to one for all testcases.
 */


public class NumberOfOnes {
    public static int numSteps(String s) {
        // if num is odd then last digit 1
        // no , is even then last digit 0

        if (s == null || s.length() <= 1) {
            return 0;
        }

        int res = 0;

        char[] charArr = s.toCharArray();

        for (int i = s.length() - 1; i > 0; i--) {

            if (charArr[i] != '0') {
                res++;
                while (charArr[i] == '1' && i > 0) {
                    res++;
                    i--;
                }
                if (i == 0) {
                    res++;
                }
                charArr[i] = '1';
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }
}
