import java.util.ArrayList;
import java.util.List;

public class KLA {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(-6);
        arr.add(5);
        arr.add(-2);
        arr.add(1);
        System.out.println(minStart(arr));
    }

    public static long minStart(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        int minNum = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            minNum = Math.min(sum, minNum);
        }
        return 1 - minNum;
    }
}
