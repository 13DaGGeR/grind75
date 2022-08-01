package org.example.problems.valid_palindrome;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Valid Palindrome";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/valid-palindrome/";
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z\\d]", "");

        int l = s.length();
        if (l < 2) {
            return true;
        }

        for (int i = 0, middle = l / 2; i < middle; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
