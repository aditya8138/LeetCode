import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultAdd {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 1, 1, 2, 3};
        int[] res = distance(input);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] distance(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        int[] res = new int[input.length];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (!map.containsKey(input[i])) {
                map.put(input[i], new ArrayList<>());
            }
            map.get(input[i]).add(i);
        }

        for (int i = 0; i < input.length; i++) {
            res[i] = calculateDiff(i, map.get(input[i]));
        }
        return res;
    }

    private static int calculateDiff(int current, List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += Math.abs(i - current);
        }
        return sum;
    }

}


// aaabbcca -> a3b2c2a1