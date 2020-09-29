package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_257_BinaryTreePaths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> strings = new ArrayList<>();
        if (root == null) {
            return strings;
        }
        StringBuilder st = new StringBuilder();
        findAllPaths(root, st, strings);
        return strings;
    }

    private void findAllPaths(TreeNode root, StringBuilder s, ArrayList<String> strings) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s.append("->").append(root.val);
            strings.add(s.substring(2));

        } else {
            s.append("->").append(root.val);
            StringBuilder right = new StringBuilder(s);
            findAllPaths(root.left, s, strings);
            findAllPaths(root.right, right, strings);
        }
    }
}
