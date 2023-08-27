package org.example.problems.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Permutations";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/permutations/|";
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();

        Set<Integer> numbersLeft = new HashSet<>();
        for (int i: nums) {
            numbersLeft.add(i);
        }
        process(new int[]{}, numbersLeft);

        return result;
    }


    private List<List<Integer>> result = new ArrayList<>();

    private void process(int[] mutation, Set<Integer> numbersLeft) {
        if (numbersLeft.isEmpty()) {
            result.add(Arrays.stream(mutation)
                .boxed()
                .toList());
            return;
        }

        for (int i: numbersLeft) {
            int[] newMutation = new int[mutation.length + 1];
            System.arraycopy(mutation, 0, newMutation, 0, mutation.length);
            newMutation[mutation.length] = i;
            Set<Integer> newSet = new HashSet<>(numbersLeft);
            newSet.remove(i);
            process(newMutation, newSet);
        }
    }
}
