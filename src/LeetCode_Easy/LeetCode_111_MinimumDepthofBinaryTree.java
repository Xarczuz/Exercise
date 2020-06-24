package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_111_MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Object> treeNodes = new Stack<>();
        treeNodes.push(1);
        treeNodes.push(root);
        int minDepth = Integer.MAX_VALUE;

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
                minDepth = Math.min(minDepth, depth);
            }
        }

        return minDepth;
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
