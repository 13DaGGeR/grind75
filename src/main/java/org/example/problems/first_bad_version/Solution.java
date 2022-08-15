package org.example.problems.first_bad_version;

import org.example.problems.SolutionInterface;

import java.util.function.Function;

public class Solution implements SolutionInterface {
    public final Function<Integer, Boolean> isBadVersion;

    public Solution(Function<Integer, Boolean> isBadVersion) {
        this.isBadVersion = isBadVersion;
    }

    @Override
    public String getName() {
        return "First Bad Version";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/first-bad-version/";
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int mid) {
        return isBadVersion.apply(mid);
    }
}
