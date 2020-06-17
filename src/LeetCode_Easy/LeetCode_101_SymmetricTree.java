package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_101_SymmetricTree {

    public boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode left = treeNodes.pop();
            TreeNode right = treeNodes.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) {
                return false;
            }
            treeNodes.add(left.left);
            treeNodes.add(right.right);
            treeNodes.add(left.right);
            treeNodes.add(right.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root.left);
        treeNodes.add(root.right);
        while (!treeNodes.isEmpty()) {
            TreeNode left = treeNodes.pop();
            TreeNode right = treeNodes.pop();
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                if (left.left != null && right.right == null || left.left == null && right.right != null) {
                    return false;
                } else {
                    treeNodes.add(left.left);
                    treeNodes.add(right.right);
                }
                if (left.right != null && right.left == null || left.right == null && right.left != null) {
                    return false;
                } else {
                    treeNodes.add(left.right);
                    treeNodes.add(right.left);
                }
            }
        }

        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
