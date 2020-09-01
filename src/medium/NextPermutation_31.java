public class NextPermutation_31 {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int idx) {
        int last = nums.length - 1;
        while (last >= idx) {
            int temp = nums[idx];
            nums[idx] = nums[last];
            nums[last] = temp;
            last--;
            idx++;
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3};
        nextPermutation(nums);
    }
}
