package org.example.problems.valid_anagram;

import org.example.problems.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Valid Anagram";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/valid-anagram/";
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charmap = new HashMap<>();
        for (char c: s.toCharArray()) {
            int currentNum = charmap.getOrDefault(c, 0);
            charmap.put(c, currentNum + 1);
        }

        for (char c: t.toCharArray()) {
            int currentNum = charmap.getOrDefault(c, 0);
            if (currentNum < 1) {
                return false;
            }
            charmap.put(c, currentNum - 1);
        }

        return true;
    }
}
