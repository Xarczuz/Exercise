package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_107_BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        Stack<Integer> treeNodesDepth = new Stack<>();
        treeNodes.push(root);
        treeNodesDepth.add(1);
        int maxDepth = 0;
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.pop();
            int depth = treeNodesDepth.pop();
            maxDepth = Math.max(depth, maxDepth);
            if (depth > lists.size()) {
                lists.add(0, new ArrayList<>());
            }
            lists.get(maxDepth - depth).add(current.val);
            if (current.right != null) {
                treeNodesDepth.push(depth + 1);
                treeNodes.push(current.right);
            }
            if (current.left != null) {
                treeNodesDepth.push(depth + 1);
                treeNodes.push(current.left);
            }
        }
        return lists;
    }

    public static class TreeNode {
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
