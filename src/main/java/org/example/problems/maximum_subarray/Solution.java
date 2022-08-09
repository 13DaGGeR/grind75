package org.example.problems.maximum_subarray;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Maximum Subarray";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/maximum-subarray/";
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        int rightBorder = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (num > sum) {
                sum = num;
            }
            if (sum > maxSum) {
                maxSum = sum;
                rightBorder = i;
            }
        }

        sum = 0;
        for (int i = rightBorder; i >= 0; i--) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
