package org.example.problems.k_closest_points_to_origin;

import org.example.problems.SolutionInterface;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "K Closest Points to Origin";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/k-closest-points-to-origin/";
    }
    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }

        Queue<PointWithDistance> queue = new PriorityQueue<>();
        for (int[] c : points) {
            double distance = Math.sqrt(c[0] * c[0] + c[1] * c[1]);
            queue.add(new PointWithDistance(c, distance));
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            result[i] = queue.poll().points;
        }

        return result;
    }

    private record PointWithDistance(int[] points, double distance) implements Comparable<PointWithDistance> {
        @Override
        public int compareTo(PointWithDistance o) {
            return -Double.compare(o.distance, this.distance);
        }
    }
}
