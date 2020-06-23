package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();
            if (node.left != null) {
                treeNodes.push(node.left);
            }
            if (node.right != null) {
                treeNodes.push(node.right);
            }
            if (!(Math.abs(maxDepth(node.left) - maxDepth(node.right)) <= 1)) {
                return false;
            }
        }
        return true;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Object> treeNodes = new Stack<>();
        int max = 1;
        treeNodes.push(max);
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = (TreeNode) treeNodes.pop();
            int depth = (int) treeNodes.pop();

            if (node.left != null) {
                treeNodes.push(depth + 1);
                treeNodes.push(node.left);
            }
            if (node.right != null) {
                treeNodes.push(depth + 1);
                treeNodes.push(node.right);
            }

            if (node.left == null && node.right == null) {
                max = Math.max(max, depth);
            }
        }

        return max;
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
