package org.example.problems._01_matrix;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "01 Matrix";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/01-matrix/";
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    int left = j > 0 ? result[i][j - 1] : Integer.MAX_VALUE / 2;
                    int top = i > 0 ? result[i - 1][j] : Integer.MAX_VALUE / 2;
                    result[i][j] = Math.min(left, top) + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    int right = j < m - 1 ? result[i][j + 1] : Integer.MAX_VALUE / 2;
                    int bottom = i < n - 1 ? result[i + 1][j] : Integer.MAX_VALUE / 2;
                    result[i][j] = Math.min(Math.min(right, bottom) + 1, result[i][j]);
                }
            }
        }

        return result;
    }
}
