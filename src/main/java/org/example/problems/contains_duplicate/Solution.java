package org.example.problems.contains_duplicate;

import org.example.problems.SolutionInterface;

import java.util.HashSet;
import java.util.Set;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Contains Duplicate";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/contains-duplicate/";
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }

        return false;
    }
}
