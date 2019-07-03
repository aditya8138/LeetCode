package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static String[] uncommonFromSentences(String A, String B) {
        StringTokenizer stA = new StringTokenizer(A);
        StringTokenizer stB = new StringTokenizer(B);

        HashSet<String> set = new HashSet<>();
        if (stA.hasMoreTokens()) {
            set.add(stA.nextToken());
        }
        if (stB.hasMoreTokens()) {
            String bString = stB.nextToken();
            if (!set.add(bString)) {
                set.remove(bString);
            }
        }
        List<String> list = new ArrayList<>(set);
        System.out.println(list);
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }
}
