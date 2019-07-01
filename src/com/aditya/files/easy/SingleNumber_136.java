package com.aditya.files.easy;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
*/

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_136 {

    // with extra memory:

    public static int singleNumber(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 1);
            } else {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
            }
        }
        return res;
    }


    // without extra memory:


}
