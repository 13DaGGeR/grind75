package org.example.problems.product_of_array_except_self;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Product of Array Except Self";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/product-of-array-except-self/";
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int productOfRightSide = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= productOfRightSide;
            productOfRightSide *= nums[i];
        }

        return res;
    }
}
