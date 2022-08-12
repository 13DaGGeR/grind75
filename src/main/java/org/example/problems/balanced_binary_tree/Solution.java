package org.example.problems.balanced_binary_tree;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Balanced Binary Tree";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/balanced-binary-tree/";
    }

    public boolean isBalanced(TreeNode root) {
        return root == null || (
            Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right)
        );
    }

    private static int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        if (node.left != null) {
            max = Integer.max(max, getMaxDepth(node.left));
        }
        if (node.right != null) {
            max = Integer.max(max, getMaxDepth(node.right));
        }

        return max + 1;
    }
}
