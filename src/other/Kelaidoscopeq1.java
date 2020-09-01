import java.util.*;

public class Kelaidoscopeq1 {
    public static void main(String[] args) {
        List<String> upRight = new ArrayList<>();
        upRight.add("2 3");
        upRight.add("3 7");
        upRight.add("4 1");
        System.out.println(countMax(upRight));
    }

    public static long countMax(List<String> upRight) {
        if (upRight == null || upRight.size() == 0) {
            return 0L;
        }

        long minA = (long) 1e7;
        long minB = (long) 1e7;


        for (String val : upRight) {
            String[] arr = val.split(" ");
            minA = Math.min(minA, Long.parseLong(arr[0]));
            minB = Math.min(minB, Long.parseLong(arr[1]));
        }
        return minA * minB;

    }
}
