package LeetCode_Easy;

import java.util.LinkedList;

public class LeetCode_112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.push(new Node(root.val, root));
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            if (node.node.left != null) {
                nodes.addFirst(new Node(node.sum + node.node.left.val, node.node.left));
            }
            if (node.node.right != null) {
                nodes.addFirst(new Node(node.sum + node.node.right.val, node.node.right));
            }
            if (node.node.left == null && node.node.right == null && node.sum == sum) {
                return true;
            }
        }
        return false;
    }

    private static class Node {
        int sum;
        TreeNode node;

        public Node(int sum, TreeNode node) {
            this.sum = sum;
            this.node = node;
        }
    }

    private static class TreeNode {
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
