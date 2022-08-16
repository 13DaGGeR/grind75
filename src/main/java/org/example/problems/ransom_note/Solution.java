package org.example.problems.ransom_note;

import org.example.helpers.CharsCountMap;
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
}
