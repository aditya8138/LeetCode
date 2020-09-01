import java.util.*;

public class PermutationII_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> subList, boolean[] seen, List<List<Integer>> res) {
        if (subList.size() == nums.length) {
            res.add(new ArrayList<>(subList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (seen[i] || i > 0 && nums[i] == nums[i - 1] && !seen[i - 1]) {
                    continue;
                }
                subList.add(nums[i]);
                seen[i] = true;
                dfs(nums, subList, seen, res);
                seen[i] = false;
                subList.remove(subList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> sol : res) {
            for (Integer val : sol) {
                System.out.print(val + ", ");
            }
            System.out.println("--------");
        }
    }
}
