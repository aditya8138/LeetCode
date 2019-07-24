package easy;


/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element always exist in the array.

        Example 1:

        Input: [3,2,3]
        Output: 3
        Example 2:

        Input: [2,2,1,1,1,2,2]
        Output: 2
*/

public class MajorityElement_169 {

    public static int majorityElement(int[] nums) {

        /********** O(1) space ********/


        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    /*

    O(n) time & space

    public static int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int majority = nums.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.get(num) == null) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey();
            }
        }
        return 0;
    }
    */
}
