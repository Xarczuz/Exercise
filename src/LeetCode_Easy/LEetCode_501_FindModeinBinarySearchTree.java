package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LEetCode_501_FindModeinBinarySearchTree {
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

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        stack.push(root);
        int max = 0;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            int nr = map.getOrDefault(node.val, 0) + 1;
            max = Math.max(nr, max);
            map.put(node.val, nr);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        ArrayList<Integer> resArr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (max == set.getValue()) {
                resArr.add(set.getKey());
            }
        }
        int[] res = new int[resArr.size()];
        for (int j = 0; j < resArr.size(); j++) {
            int i = resArr.get(j);
            res[j] = i;
        }
        return res;
    }
}
