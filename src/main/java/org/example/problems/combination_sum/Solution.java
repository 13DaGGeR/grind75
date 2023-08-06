package org.example.problems.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Combination Sum";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/combination-sum/";
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] combinationsPerSum = new List[target + 1];

        for (int i = 0; i <= target; i++) {
            combinationsPerSum[i] = new LinkedList<>();
            if (i < 1) {
                continue;
            }

            for (int j = 0; j < candidates.length; j++) {
                int candidate = candidates[j];
                if (candidate == i) {
                    List<Integer> combination = new LinkedList<>();
                    combination.add(candidate);
                    combinationsPerSum[i].add(combination);
                    continue;
                }
                if (candidate > i) {
                    break;
                }

                List<List<Integer>> previousCombinations = combinationsPerSum[i - candidate];
                for (int k = 0; k < previousCombinations.size(); k++) {
                    List<Integer> combination = previousCombinations.get(k);
                    if (candidate > combination.get(combination.size() - 1)) {
                        continue;
                    }

                    List<Integer> newCombination = new ArrayList<Integer>(combination);
                    newCombination.add(candidate);
                    combinationsPerSum[i].add(newCombination);
                }
            }
        }

        return combinationsPerSum[target];
    }
}
