package org.example.problems.diameter_of_binary_tree;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Diameter of Binary Tree";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/diameter-of-binary-tree/";
    }

    public int diameterOfBinaryTree(TreeNode root) {
        DiameterSearch s = new DiameterSearch(root);
        return s.maxSumDepth;
    }

    private static class DiameterSearch {
        private int maxSumDepth = 0;

        private DiameterSearch(TreeNode root) {
            processNodeAndGetMaxDepth(root);
        }

        private int processNodeAndGetMaxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = processNodeAndGetMaxDepth(node.left);
            int right = processNodeAndGetMaxDepth(node.right);

            maxSumDepth = Math.max(left + right, maxSumDepth);
            return Math.max(left, right) + 1;
        }
    }
}
