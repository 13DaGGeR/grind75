package org.example.problems.ransom_note;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {

    @Override
    public String getName() {
        return "Ransom Note";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/ransom-note/";
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        CharsCountMap map = new CharsCountMap();
        int letters = 0;
        for (char c: ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            letters++;
        }

        for (char c: magazine.toCharArray()) {
            int current = map.getOrDefault(c, 0);
            if (current > 0) {
                map.put(c, current - 1);
                letters--;
                if (letters == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private static class CharsCountMap {
        private static final int MAP_SIZE = 52;

        private final int[] map = new int[MAP_SIZE];

        public Integer getOrDefault(char key, int defaultValue) {
            return map[normalizeKey(key)] > 0
                ? map[normalizeKey(key)]
                : defaultValue;
        }

        public void put(char key, int value) {
            map[normalizeKey(key)] = value;
        }

        private int normalizeKey(char c) {
            if (c >= 'a' && c <= 'z') {
                return c - 'a';
            }

            if (c >= 'A' && c <= 'Z') {
                return c - 'A' + 26;
            }

            throw new IllegalArgumentException("Unsupported character");
        }
    }
}
