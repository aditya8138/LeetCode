/*
Given an array A of positive integers, call a (contiguous, not necessarily distinct)
subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.
*/


import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers_992 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2};
        System.out.println(new SubarraysWithKDifferentIntegers_992().subarraysWithKDistinct(A, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int res = 0;
        int left1 = 0;
        int left2 = 0;

        Window window1 = new Window();
        Window window2 = new Window();

        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            window1.add(x);
            window2.add(x);

            while (window1.different() > K) {
                window1.remove(A[left1++]);
            }
            while (window2.different() >= K) {
                window2.remove(A[left2++]);
            }

            res += left2 - left1;
        }

        return res;
    }

    private class Window {
        Map<Integer, Integer> count;
        int unique;

        public Window() {
            count = new HashMap<>();
            unique = 0;
        }

        public void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1) {
                unique++;
            }
        }

        public void remove(int x) {
            count.put(x, count.getOrDefault(x, 0) - 1);
            if (count.get(x) == 0) {
                unique--;
            }
        }

        public int different() {
            return unique;
        }
    }
}

