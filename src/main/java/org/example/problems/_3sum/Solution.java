package org.example.problems._3sum;

import org.example.problems.SolutionInterface;

import java.util.*;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "3Sum";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/3sum/";
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            }
            int middleIndex = i + 1;
            int lastIndex = nums.length - 1;
            while (middleIndex < lastIndex) {
                int middle = nums[middleIndex];
                int last = nums[lastIndex];
                if (last < 0) {
                    break;
                }
                int sum = first + middle + last;
                if (sum == 0) {
                    set.add(List.of(first, middle, last));
                }
                if (sum > 0) {
                    lastIndex--;
                } else {
                    middleIndex++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
