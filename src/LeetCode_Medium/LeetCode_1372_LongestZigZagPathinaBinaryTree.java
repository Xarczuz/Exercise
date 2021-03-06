package LeetCode_Medium;

import java.util.Stack;

public class LeetCode_1372_LongestZigZagPathinaBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        //TODO
        public int zigZag(TreeNode root, boolean b) {
            int path = 0;
            Stack<TreeNode> treeNodes = new Stack<>();
            treeNodes.push(root);
            boolean left = b;
            while (!treeNodes.isEmpty()) {
                TreeNode t = treeNodes.pop();
                if (t.val > 1) {
                    path += t.val;
                    break;
                }
                if (t.left != null && left) {
                    treeNodes.push(t.left);
                    left = false;
                    path++;
                    t.val = path;
                    continue;
                } else if (t.right != null && !left) {
                    treeNodes.push(t.right);
                    left = true;
                    path++;
                    t.val = path;
                    continue;
                }
                break;
            }
            return path;
        }

        public int longestZigZag(TreeNode root) {
            int longest = 0;
            Stack<TreeNode> treeNodes = new Stack<>();
            treeNodes.push(root);
            while (!treeNodes.isEmpty()) {
                TreeNode t = treeNodes.pop();
                if (t.left != null) {
                    treeNodes.push(t.left);
                    int sum = zigZag(t, true);
                    if (sum > longest) {
                        longest = sum;
                    }
                }
                if (t.right != null) {
                    treeNodes.push(t.right);
                    int sum = zigZag(t, false);
                    if (sum > longest) {
                        longest = sum;
                    }
                }
            }
            return longest;
        }
    }
}
