package org.example.problems.binary_tree_level_order_traversal;

import org.example.helpers.TreeNode;
import org.example.problems.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Binary Tree Level Order Traversal";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/binary-tree-level-order-traversal/";
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        fillLists(lists, root, 0);
        return new ArrayList<>(lists);
    }

    private void fillLists(ArrayList<ArrayList<Integer>> lists, TreeNode n, int depth) {
        if (n == null) {
            return;
        }
        ArrayList<Integer> list;
        if (lists.size() <= depth) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(depth);
        }
        list.add(n.val);
        fillLists(lists, n.left, depth + 1);
        fillLists(lists, n.right, depth + 1);
    }
}
