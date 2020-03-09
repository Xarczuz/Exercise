package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_700_SearchinaBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.val == val)
                return root;
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
