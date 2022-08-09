package org.example.problems.flood_fill;

import org.example.problems.SolutionInterface;

import java.util.LinkedList;
import java.util.Queue;

public class Solution implements SolutionInterface {
    private Queue<Integer[]> q;
    private int oldColor;
    private int rows;
    private int cols;
    private int[][] matrix;

    @Override
    public String getName() {
        return "Flood Fill";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/flood-fill/";
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        matrix = image;
        oldColor = image[sr][sc];
        rows = image.length;
        cols = image[0].length;
        if (oldColor == newColor || rows * cols == 0) {
            return image;
        }
        q = new LinkedList<>();
        q.add(new Integer[]{sr,sc});

        while (q.size() > 0) {
            Integer[] coords = q.poll();
            int currentRow = coords[0];
            int currentCol = coords[1];

            image[currentRow][currentCol] = newColor;
            enqueue(currentRow - 1, currentCol);
            enqueue(currentRow + 1, currentCol);
            enqueue(currentRow, currentCol + 1);
            enqueue(currentRow, currentCol - 1);
        }
        return image;
    }

    private void enqueue(int r, int c) {
        if (r < 0 || r >= rows) {
            return;
        }

        if (c < 0 || c >= cols) {
            return;
        }

        if (matrix[r][c] != oldColor) {
            return;
        }

        q.add(new Integer[]{r, c});
    }
}
