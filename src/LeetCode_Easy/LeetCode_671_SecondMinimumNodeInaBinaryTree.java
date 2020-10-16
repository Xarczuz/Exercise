package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_671_SecondMinimumNodeInaBinaryTree {
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

    public int findSecondMinimumValue(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        long min = Long.MAX_VALUE, secondMin = Long.MAX_VALUE;
        while (!stack.empty()) {
            TreeNode t = stack.pop();
            if (min > t.val) {
                secondMin = min;
                min = t.val;
            } else if (min != t.val && secondMin > t.val) {
                secondMin = t.val;
            }

            if (t.left != null && secondMin > t.left.val) {
                stack.push(t.left);
            }
            if (t.right != null && secondMin > t.right.val) {
                stack.push(t.right);
            }

        }
        if (min == Long.MAX_VALUE || secondMin == Long.MAX_VALUE) {
            return -1;
        }
        return (int) secondMin;
    }
}
