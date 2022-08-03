package org.example.helpers;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean equals(TreeNode tree) {
        if (tree == null) {
            return false;
        }

        if (tree.val != val) {
            return false;
        }

        return isBranchEquals(left, tree.left) && isBranchEquals(right, tree.right);
    }

    private static boolean isBranchEquals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null) {
            return t1.equals(t2);
        }
        return false;
    }
}
