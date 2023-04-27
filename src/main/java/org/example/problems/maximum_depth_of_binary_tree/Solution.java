package org.example.problems.maximum_depth_of_binary_tree;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Maximum Depth of Binary Tree";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/maximum-depth-of-binary-tree/";
    }

    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root.left != null) {
            max = Math.max(max, maxDepth(root.left));
        }

        if (root.right != null) {
            max = Math.max(max, maxDepth(root.right));
        }

        return max + 1;
    }
}
