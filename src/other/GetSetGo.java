import java.util.Arrays;
import java.util.List;

public class GetSetGo {
    public static boolean isPossible(List<Integer> calCounts, int requiredCals) {
        return calCount(calCounts, calCounts.size(), requiredCals);
    }

    static boolean calCount(List<Integer> calCounts,
                            int size, int requiredCals) {

        if (requiredCals == 0) {
            return true;
        }

        if (size == 0) {
            return false;
        }

        if (calCounts.get(size - 1) > requiredCals) {
            return calCount(calCounts, size - 1, requiredCals);
        }
        return calCount(calCounts, size - 1, requiredCals) ||
                calCount(calCounts, size - 1, requiredCals - calCounts.get(size - 1));
    }

    public static void main(String[] args) {
        List<Integer> calorie1 = Arrays.asList(2, 9, 5, 1, 6);
        int required1 = 12;

        List<Integer> calorie2 = Arrays.asList(2, 3, 15, 1, 16);
        int required2 = 8;
        System.out.println(isPossible(calorie1, required1));
        System.out.println(isPossible(calorie2, required2));
    }

}
