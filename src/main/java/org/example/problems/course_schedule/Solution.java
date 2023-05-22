package org.example.problems.course_schedule;

import org.example.problems.SolutionInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Course Schedule";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/course-schedule/";
    }

    private static class Solver {
        ArrayList<HashSet<Integer>> dependencies;
        int[][] prerequisites;
        int numCourses;
        private final HashSet<Integer> checked = new HashSet<>();

        Solver(int numCourses, int[][] prerequisites) {
            dependencies = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                dependencies.add(new HashSet<>());
            }
            this.prerequisites = prerequisites;
            this.numCourses = numCourses;
        }

        public boolean hasCycle() {
            for (int[] dep : prerequisites) {
                if (dep[0] == dep[1]) {
                    return true;
                }
                dependencies.get(dep[0]).add(dep[1]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (checked.contains(i)) {
                    continue;
                }
                for (int d : dependencies.get(i)) {
                    if (isCycled(i, d, new HashSet<>())) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isCycled(int root, int node, Set<Integer> diveCheck) {
            if (root == node || diveCheck.contains(node)) {
                return true;
            }
            if (checked.contains(node)) {
                return false;
            }

            checked.add(node);
            diveCheck.add(node);

            for (int dep : dependencies.get(node)) {
                if (isCycled(root, dep, diveCheck)) {
                    return true;
                }
            }
            diveCheck.remove(node);

            return false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Solver s = new Solver(numCourses, prerequisites);
        return !s.hasCycle();
    }
}
