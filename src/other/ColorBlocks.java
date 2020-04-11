import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorBlocks {
    public static int minPrice(List<List<Integer>> cost) {
        if (cost == null || cost.size() == 0) {
            return 0;
        }
        int row = cost.size();
        int col = cost.get(0).size();

        for (int i = 1; i < row; i++) {
            cost.get(i).set(0, cost.get(i).get(0) + Math.min(cost.get(i - 1).get(1), cost.get(i - 1).get(2)));
            cost.get(i).set(1, cost.get(i).get(1) + Math.min(cost.get(i - 1).get(0), cost.get(i - 1).get(2)));
            cost.get(i).set(2, cost.get(i).get(2) + Math.min(cost.get(i - 1).get(1), cost.get(i - 1).get(0)));
        }

        int min = Math.min(cost.get(row - 1).get(0), cost.get(col - 1).get(0));
        return Math.min(min, cost.get(row - 1).get(2));
    }

    public static void main(String[] args) {
        List<List<Integer>> cost = new ArrayList<>();
        List<Integer> sub1 = Arrays.asList(1, 2, 3);
        List<Integer> sub2 = Arrays.asList(1, 2, 3);
        List<Integer> sub3 = Arrays.asList(3, 3, 1);
        cost.add(sub1);
        cost.add(sub2);
        cost.add(sub3);
        System.out.println(minPrice(cost));
    }
}
