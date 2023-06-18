package org.example.problems.number_of_islands;

import org.example.problems.SolutionInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Number of Islands";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/number-of-islands/description/";
    }

    public int numIslands(char[][] grid) {
        Solver s = new Solver(grid);
        return s.count;
    }

    private static class Solver {
        private record Coordinates(int row, int col) {
        }

        public final int count;
        private final Set<Coordinates> processed = new HashSet<>();
        private final char[][] grid;
        private final int width;
        private final int height;

        Solver(char[][] grid) {
            this.grid = grid;
            height = grid.length;
            width = height > 0
                ? grid[0].length
                : 0;
            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Coordinates c = new Coordinates(i, j);
                    if (grid[i][j] == '1' && !processed.contains(c)) {
                        count++;
                        processIsland(c);
                    }
                }
            }
            this.count = count;
        }

        private void processIsland(Coordinates c) {
            if (processed.contains(c)) {
                return;
            }
            processed.add(c);
            for (Coordinates n: this.getLandNeighbours(c)) {
                processIsland(n);
            }
        }

        private Coordinates[] getLandNeighbours(Coordinates c) {
            List<Coordinates> list = new ArrayList<>();
            if (c.col > 0 && grid[c.row][c.col - 1] == '1') {
                list.add(new Coordinates(c.row, c.col - 1));
            }
            if (c.row > 0 && grid[c.row - 1][c.col] == '1') {
                list.add(new Coordinates(c.row - 1, c.col));
            }
            if (c.col < width - 1 && grid[c.row][c.col + 1] == '1') {
                list.add(new Coordinates(c.row, c.col + 1));
            }
            if (c.row < height - 1 && grid[c.row + 1][c.col] == '1') {
                list.add(new Coordinates(c.row + 1, c.col));
            }

            return list.toArray(new Coordinates[]{});
        }
    }
}
