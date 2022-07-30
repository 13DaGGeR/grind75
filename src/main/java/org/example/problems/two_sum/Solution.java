package org.example.problems.two_sum;

import org.example.problems.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Solution implements SolutionInterface {

    @Override
    public String getName() {
        return "Two Sum";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/two-sum/";
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberPositions = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int secondKey = numberPositions.getOrDefault(target - current, -1);
            if (secondKey != -1) {
                return new int[]{secondKey, i};
            }
            if (!numberPositions.containsKey(current)) {
                numberPositions.put(current, i);
            }
        }

        return new int[]{-1, -1};
    }
}
