package LeetCode_Easy;

public class LeetCode_563_BinaryTreeTilt {

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

    public int findTilt(TreeNode root) {
        return find(root)[0];
    }

    public int[] find(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = find(root.left);
        int[] right = find(root.right);
        return new int[]{Math.abs(left[1] - right[1]) + left[0] + right[0], root.val + left[1] + right[1]};
    }

}
