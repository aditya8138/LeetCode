package com.aditya.files.hard;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 **/

public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int[] temp = new int[matrix[0].length];
        int area = 0;
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    temp[j] += 1;
                } else {
                    temp[j] = 0;
                }
            }
            area = maxHistArea(temp);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public int maxHistArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i=0;
        while(i<arr.length){
            //push elements into the stack
            if(stack.isEmpty() || arr[stack.peek()]<=arr[i]){
                stack.push(i);
                i++;
            }else{
                //calculate area by popping the stack
                int currMax = stack.pop();
                area = arr[currMax]*(stack.isEmpty()?i:i-1-stack.peek());
                if(area>maxArea){
                    maxArea=area;
                }
            }
        }
        while(!stack.isEmpty()){
            int currMax = stack.pop();
            area = arr[currMax]*(stack.isEmpty()?i:i-1-stack.peek());
            if(area>maxArea){
                maxArea=area;
            }
        }


        return maxArea;
    }
}
