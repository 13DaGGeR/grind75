package org.example.problems.best_time_to_buy_and_sell_stock;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Best Time to Buy and Sell Stock";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/";
    }

    public int maxProfit(int[] prices) {
        int minimalPrice = Integer.MAX_VALUE;
        int maximalProfit = 0;
        for (int price: prices) {
            if (price > minimalPrice) {
                maximalProfit = Math.max(maximalProfit, price - minimalPrice);
            } else {
                minimalPrice = price;
            }
        }

        return maximalProfit;
    }
}
