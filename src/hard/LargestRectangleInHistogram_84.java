package hard;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i = 0;
        while (i < heights.length) {
            //push elements into the stack
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                //calculate area by popping the stack
                int currMax = stack.pop();
                area = heights[currMax] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int currMax = stack.pop();
            area = heights[currMax] * (stack.isEmpty() ? i : i - 1 - stack.peek());
            if (area > maxArea) {
                maxArea = area;
            }
        }


        return maxArea;
    }
}
