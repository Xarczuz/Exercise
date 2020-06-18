package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        root.val = 1;
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.pop();
            if (current.left != null) {
                current.left.val = current.val + 1;
                treeNodes.push(current.left);
            }
            if (current.right != null) {
                current.right.val = current.val + 1;
                treeNodes.push(current.right);
            }
            maxDepth = Math.max(current.val, maxDepth);
        }
        return maxDepth;
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
