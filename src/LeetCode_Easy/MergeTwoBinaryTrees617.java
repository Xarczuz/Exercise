package LeetCode_Easy;

import java.util.LinkedList;

public class MergeTwoBinaryTrees617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t2 == null) {
            return t1;
        } else if (t1 == null) {
            return t2;
        }
        LinkedList<TreeNode> treeNodesLeft = new LinkedList<>();
        LinkedList<TreeNode> treeNodesRight = new LinkedList<>();
        treeNodesLeft.push(t1);
        treeNodesRight.push(t2);
        while (!treeNodesLeft.isEmpty()) {
            TreeNode tLeft = treeNodesLeft.pop();
            TreeNode tRight = treeNodesRight.pop();
            tLeft.val += tRight.val;
            if (tLeft.left != null && tRight.left != null) {
                treeNodesLeft.push(tLeft.left);
                treeNodesRight.push(tRight.left);
            } else if (tLeft.left == null) {
                tLeft.left = tRight.left;
            }
            if (tLeft.right != null && tRight.right != null) {
                treeNodesLeft.push(tLeft.right);
                treeNodesRight.push(tRight.right);
            } else if (tLeft.right == null) {
                tLeft.right = tRight.right;
            }
        }
        return t1;
    }

    public static void main(String[] args) {

    }
}
