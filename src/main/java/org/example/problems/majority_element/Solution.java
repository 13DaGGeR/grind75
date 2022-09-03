package org.example.problems.majority_element;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Majority Element";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/majority-element/";
    }

    public int majorityElement(int[] nums) {
        int majority = 0, count = 0, minLength = nums.length / 2;
        for (int n : nums) {
            if (count == 0 || majority == n) {
                majority = n;
                count++;
            } else {
                count--;
            }
            if (count > minLength) {
                return majority;
            }
        }
        return majority;
    }
}
