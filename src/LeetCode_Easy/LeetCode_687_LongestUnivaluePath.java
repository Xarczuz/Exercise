package LeetCode_Easy;

public class LeetCode_687_LongestUnivaluePath {
    int maxLength;

    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;
        findPath(root, 0);
        return maxLength;
    }

    private int findPath(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        int left = findPath(root.left, root.val);
        int right = findPath(root.right, root.val);

        maxLength = Math.max(maxLength, left + right);

        if (root.val == val) {
            return 1 + Math.max(left, right);
        }
        return 0;
    }

    private class TreeNode {

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
