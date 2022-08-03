package org.example.problems.invert_binary_tree;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Invert Binary Tree";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/invert-binary-tree/";
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode buffer = root.left == null ? null : invertTree(root.left);
        root.left = root.right == null ? null : invertTree(root.right);
        root.right = buffer;
        return root;
    }
}
