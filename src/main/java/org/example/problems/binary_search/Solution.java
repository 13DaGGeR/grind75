package org.example.problems.binary_search;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Binary Search";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/binary-search/";
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleValue = nums[middle];
            if (middleValue == target) {
                return middle;
            }
            if (middleValue > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
