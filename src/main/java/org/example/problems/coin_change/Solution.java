package org.example.problems.coin_change;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Coin Change";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/coin-change/";
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] sums = new int[amount + 1];
        int minimalCoin = Integer.MAX_VALUE;

        for (int c: coins) {
            if (c < minimalCoin) {
                minimalCoin = c;
            }
            if (c <= amount) {
                sums[c] = 1;
            }
        }

        for (int i = minimalCoin; i <= amount; i++) {
            int min = sums[i];
            for (int c: coins) {
                int prev = i > c
                    ? sums[i - c]
                    : 0;
                if (prev != 0 && (prev + 1 < min || min == 0)) {
                    min = prev + 1;
                }
            }
            sums[i] = min;
        }

        return sums[amount] == 0 ? -1 : sums[amount];
    }
}
