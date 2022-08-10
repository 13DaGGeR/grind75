package org.example.problems.lowest_common_ancestor_of_a_binary_search_tree;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Lowest Common Ancestor of a Binary Search Tree";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/";
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        if ((root.val - p.val) * (root.val - q.val) < 0) {
            return root;
        }

        return lowestCommonAncestor(root.val > p.val ? root.left : root.right, p, q);
    }
}
