package org.example.problems.climbing_stairs;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Climbing Stairs";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/climbing-stairs/";
    }

    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prev = 2, prev2 = 1, res = 0;
        for (int i = 3; i <= n; i++) {
            res = prev + prev2;
            prev2 = prev;
            prev = res;
        }
        return res;
    }
}
