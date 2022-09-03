package org.example.problems.add_binary;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Add Binary";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/add-binary/";
    }

    public String addBinary(String a, String b) {
        boolean[] aBits = stringToBits(a);
        boolean[] bBits = stringToBits(b);
        int maxLength = Math.max(aBits.length, bBits.length) + 1; // add 1 bit for overflow
        boolean[] sumBits = new boolean[maxLength];
        boolean overflow = false;
        for (int i = 0, registerSum = 0; i < maxLength; i++, registerSum = 0) {
            if (i < aBits.length && aBits[i]) {
                registerSum++;
            }
            if (i < bBits.length && bBits[i]) {
                registerSum++;
            }
            if (overflow) {
                registerSum++;
            }
            sumBits[i] = registerSum % 2 != 0;
            overflow = registerSum > 1;
        }
        return bitsToString(sumBits);
    }

    private String bitsToString(boolean[] sumBits) {
        StringBuilder result = new StringBuilder();
        boolean isLeadingZero = true;
        for (int i = sumBits.length - 1; i >= 0; i--) {
            boolean bit = sumBits[i];
            if (!bit && isLeadingZero && i > 0) {
                continue;
            }
            if (bit) {
                isLeadingZero = false;
            }

            result.append(bit ? '1' : '0');
        }

        return result.toString();
    }

    private boolean[] stringToBits(String s) {
        boolean[] res = new boolean[s.length()];
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            res[chars.length - 1 - i] = chars[i] == '1';
        }

        return res;
    }
}
