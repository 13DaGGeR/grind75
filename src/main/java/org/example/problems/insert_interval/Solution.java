package org.example.problems.insert_interval;

import org.example.problems.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Insert Interval";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/insert-interval/";
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval[1] < intervals[0][0]) {
            int[][] result = new int[intervals.length + 1][2];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, intervals.length);
            return result;
        }

        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int finish = newInterval[1];
        boolean added = false;
        for (int[] current : intervals) {
            if (!added && finish < current[0]) {
                list.add(new int[]{start, finish});
                added = true;
            }
            if (start > current[1] || finish < current[0]) {
                list.add(current);
                continue;
            }
            start = Math.min(start, current[0]);
            finish = Math.max(finish, current[1]);
        }
        if (!added) {
            list.add(new int[]{start, finish});
        }

        return list.toArray(new int[][]{});
    }
}
