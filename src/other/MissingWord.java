package other;

import java.util.ArrayList;
import java.util.List;

public class MissingWord {

    public static List<String> missingWords(String s, String t) {
        String[] word1 = s.split(" ");
        String[] word2 = t.split(" ");
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < word1.length; i++) {
            int flag = 0;
            for (int j = 0; j < word2.length; j++) {
                if (word1[i].equals(word2[j])) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println(word1[i]);
                result.add(word1[i]);
            }

        }
        System.out.println(result.toString());
        return result;

    }
}
