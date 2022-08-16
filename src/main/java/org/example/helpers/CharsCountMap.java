package org.example.helpers;

public final class CharsCountMap {
    private static final int MAP_SIZE = 52;

    private final int[] map = new int[MAP_SIZE];

    public Integer getOrDefault(char key, int defaultValue) {
        return map[normalizeKey(key)] > 0
            ? map[normalizeKey(key)]
            : defaultValue;
    }

    public void put(char key, int value) {
        map[normalizeKey(key)] = value;
    }

    private int normalizeKey(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }

        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 26;
        }

        throw new IllegalArgumentException("Unsupported character");
    }
}
