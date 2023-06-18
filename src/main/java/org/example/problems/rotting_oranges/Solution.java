package org.example.problems.rotting_oranges;

import org.example.problems.SolutionInterface;

import java.util.*;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Rotting Oranges";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/rotting-oranges/";
    }

    private record Coordinates(int row, int column) {}
    private int[][] grid;
    private int width;
    private int height;
    private Set<Coordinates> rottenInLastMinute = new HashSet<>();
    private int freshOrangesLeft = 0;

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        height = grid.length;
        width = grid[0].length;
        freshOrangesLeft = 0;

        fillInitialState();

        int minutesPassed = 0;
        while (freshOrangesLeft > 0 && !rottenInLastMinute.isEmpty()) {
            Set<Coordinates> rottenInCurrentMinute = new HashSet<>();
            for (Coordinates rotten: rottenInLastMinute.toArray(new Coordinates[]{})) {
                Collections.addAll(rottenInCurrentMinute, getFreshNeighbours(rotten));
            }

            for (Coordinates rotten: rottenInCurrentMinute.toArray(new Coordinates[]{})) {
                grid[rotten.row][rotten.column] = 2;
                freshOrangesLeft--;
            }
            rottenInLastMinute = rottenInCurrentMinute;

            minutesPassed++;
        }

        return freshOrangesLeft > 0 ? -1 : minutesPassed;
    }

    private void fillInitialState() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int value = grid[i][j];

                if (value == 2) {
                    rottenInLastMinute.add(new Coordinates(i, j));
                } else if (value == 1) {
                    freshOrangesLeft++;
                }
            }
        }
    }

    private Coordinates[] getFreshNeighbours(Coordinates c) {
        List<Coordinates> list = new ArrayList<>();
        if (c.column > 0 && grid[c.row][c.column - 1] == 1) {
            list.add(new Coordinates(c.row, c.column - 1));
        }
        if (c.row > 0 && grid[c.row - 1][c.column] == 1) {
            list.add(new Coordinates(c.row - 1, c.column));
        }
        if (c.column < width - 1 && grid[c.row][c.column + 1] == 1) {
            list.add(new Coordinates(c.row, c.column + 1));
        }
        if (c.row < height - 1 && grid[c.row + 1][c.column] == 1) {
            list.add(new Coordinates(c.row + 1, c.column));
        }

        return list.toArray(new Coordinates[]{});
    }
}
