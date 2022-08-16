package org.example.problems.longest_palindrome;

import org.example.helpers.CharsCountMap;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Longest Palindrome";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/longest-palindrome/";
    }

    public int longestPalindrome(String s) {
        CharsCountMap map = new CharsCountMap();
        int result = 0;
        for (char c: s.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                result += 2;
                map.put(c, 0);
            } else {
                map.put(c, 1);
            }
        }
        if (result < s.length()) {
            result++; // middle character
        }

        return result;
    }
}
