package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null) {
            return false;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(p);
        treeNodeStack.push(q);
        while (!treeNodeStack.empty()) {
            p = treeNodeStack.pop();
            q = treeNodeStack.pop();
            if (p.val != q.val) {
                return false;
            }

            if (p.left != null && q.left != null) {
                treeNodeStack.push(p.left);
                treeNodeStack.push(q.left);
            } else if (p.left == null && q.left != null) {
                return false;
            } else if (p.left != null) {
                return false;
            }
            if (p.right != null && q.right != null) {
                treeNodeStack.push(p.right);
                treeNodeStack.push(q.right);
            } else if (p.right == null && q.right != null) {
                return false;
            } else if (p.right != null) {
                return false;
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
