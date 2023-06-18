package org.example.problems.validate_binary_search_tree;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Validate Binary Search Tree";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/validate-binary-search-tree/";
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }

        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
            if (!isValidBST(root.left, min, root.val)) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
            return isValidBST(root.right, root.val, max);
        }

        return true;
    }
}
