package org.example.problems.search_in_rotated_sorted_array;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Search in Rotated Sorted Array";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/search-in-rotated-sorted-array/";
    }

    public int search(int[] nums, int target) {
        int start = nums[0];
        if (start == target) {
            return 0;
        }

        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        int leftKey = 0;
        int rightKey = nums.length - 1;

        int shiftKey = getShiftKey(nums);
        if (shiftKey >= 0) {
            if (target < start) { // search in shifted part
                leftKey = shiftKey + 1;
            } else {
                rightKey = shiftKey;
            }
        }

        while (leftKey < rightKey) {
            int key = leftKey + (rightKey - leftKey) / 2;
            if (nums[key] < target) {
                leftKey = key + 1;
            } else {
                rightKey = key;
            }
        }

        if (nums[leftKey] == target) {
            return leftKey;
        }

        return -1;
    }

    public int getShiftKey(int[] nums)
    {
        int start = nums[0];
        int end = nums[nums.length - 1];
        if (end > start || nums.length < 2) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (right - left == 1 && nums[left] > nums[right]) {
                return left;
            }
            int middle = left + (right - left) / 2;
            if (nums[middle] > start) {
                left = middle;
            } else if (nums[middle] < end) {
                right = middle;
            }
        }
        throw new RuntimeException("array not sorted or shifter more then once");
    }
}
