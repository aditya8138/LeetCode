package easy;

import java.util.HashSet;

public class JewelsAndStones_771 {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> jewelSet = new HashSet<>();
        for (char j : J.toCharArray()) {
            jewelSet.add(j);
        }

        for (char s : S.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
