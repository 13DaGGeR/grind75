package org.example.problems.longest_substring_without_repeating_characters;

import org.example.problems.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Longest Substring Without Repeating Characters";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/longest-substring-without-repeating-characters/";
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>(100);
        int maxLength = 1;
        char[] chars = s.toCharArray();
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            if (map.containsKey(c)) {
                maxLength = Math.max(maxLength, right - left);
                int previousIndex = map.get(c);
                for (int j = left; j <= previousIndex; j++) {
                    map.remove(chars[j]);
                }
                left = previousIndex + 1;
            }
            map.put(c, right);
        }

        return Math.max(maxLength, chars.length - left);
    }
}
